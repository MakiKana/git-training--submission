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

    /**
     * 一覧表示
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("houses", houseService.findAll());
        return "houses/admin-list";
    }

    /**
     * 新規登録画面
     */
    @GetMapping("/new")
    public String newHouse(Model model) {
        model.addAttribute("house", new House());
        return "houses/form";
    }

    /**
     * 新規登録処理
     */
    @PostMapping("/new")
    public String create(@ModelAttribute House house) {
        houseService.save(house);
        return "redirect:/admin/houses";
    }

    /**
     * 編集画面
     */
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        House house = houseService.findById(id);
        if (house == null) {
            return "redirect:/admin/houses";
        }
        model.addAttribute("house", house);
        return "houses/form";
    }

    /**
     * 編集処理
     */
    @PostMapping("/{id}/edit")
    public String update(@PathVariable("id") Integer id, @ModelAttribute House house) {
        house.setId(id); // IDをセット
        houseService.save(house);
        return "redirect:/admin/houses";
    }

    /**
     * 削除処理
     */
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        houseService.delete(id);
        return "redirect:/admin/houses";
    }
}
