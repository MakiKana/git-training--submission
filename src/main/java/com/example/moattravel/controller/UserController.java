package com.example.moattravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel.entity.User;
import com.example.moattravel.repository.UserRepository;
import com.example.moattravel.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public String myPage(@AuthenticationPrincipal UserDetails userDetails,
                         Model model) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow();
        model.addAttribute("user", user);
        return "users/detail";
    }

    @GetMapping("/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails,
                       Model model) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow();
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User form,
                         @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow();
        user.setName(form.getName());
        user.setFurigana(form.getFurigana());
        user.setPostalCode(form.getPostalCode());
        user.setAddress(form.getAddress());
        user.setPhoneNumber(form.getPhoneNumber());
        userService.update(user);
        return "redirect:/user/me";
    }
}
