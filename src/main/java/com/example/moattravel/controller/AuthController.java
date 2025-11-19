package com.example.moattravel.controller;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moattravel.entity.User;
import com.example.moattravel.entity.VerificationToken;
import com.example.moattravel.repository.VerificationTokenRepository;
import com.example.moattravel.service.EmailService;
import com.example.moattravel.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.registerGeneralUser(user);

        // トークン生成
        String tokenStr = UUID.randomUUID().toString();
        VerificationToken token = new VerificationToken();
        token.setUser(user);
        token.setToken(tokenStr);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        token.setCreatedAt(now);
        token.setUpdatedAt(now);
        tokenRepository.save(token);

        emailService.sendVerificationMail(user, tokenStr);

        model.addAttribute("message", "登録ありがとうございます。メールを確認してください（ダミー）。");
        return "login";
    }

    @GetMapping("/verify")
    public String verify(@RequestParam("token") String tokenValue, Model model) {
        var tokenOpt = tokenRepository.findByToken(tokenValue);
        if (tokenOpt.isEmpty()) {
            model.addAttribute("message", "トークンが不正です。");
            return "login";
        }
        var token = tokenOpt.get();
        User user = token.getUser();
        user.setEnabled(true);
        userService.save(user);

        model.addAttribute("message", "メール認証が完了しました。ログインしてください。");
        return "login";
    }
}
