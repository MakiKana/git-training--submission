package com.example.moattravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.moattravel.repository.HouseRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HouseRepository houseRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("houses", houseRepository.findAll());
        return "home/index";
    }
}
