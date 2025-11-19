package com.example.moattravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel.entity.House;
import com.example.moattravel.service.HouseService;

@Controller
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("houses", houseService.findAll());
        return "houses/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        House house = houseService.findById(id);
        if (house == null) {
            return "redirect:/houses";
        }
        model.addAttribute("house", house);
        return "houses/detail";
    }
}
