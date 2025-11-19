package com.example.moattravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.moattravel.service.HouseService;

@Controller
public class HomeController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("houses", houseService.findAll());
        return "index";
    }
}
