package com.example.moattravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel.entity.House;
import com.example.moattravel.service.HouseService;

@Controller
@RequestMapping("/admin/houses")
public class AdminHouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping
    public String adminList(Model model) {
        model.addAttribute("houses", houseService.findAll());
        return "houses/admin-list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("house", new House());
        return "houses/form";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("house") House house) {
        houseService.save(house);
        return "redirect:/admin/houses";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        House house = houseService.findById(id);
        if (house == null) {
            return "redirect:/admin/houses";
        }
        model.addAttribute("house", house);
        return "houses/form";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable("id") Integer id,
                         @ModelAttribute("house") House form) {
        form.setId(id);
        houseService.save(form);
        return "redirect:/admin/houses";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        houseService.delete(id);
        return "redirect:/admin/houses";
    }
}
