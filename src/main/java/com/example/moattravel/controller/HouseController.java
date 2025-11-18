package com.example.moattravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel.model.House;
import com.example.moattravel.repository.HouseRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/houses")
public class HouseController {

    private final HouseRepository houseRepository;

    // 一覧表示
    @GetMapping
    public String index(Model model) {
        model.addAttribute("houses", houseRepository.findAll());
        return "admin/houses/index";
    }

    // 新規登録フォーム
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("house", new House());
        return "admin/houses/create";
    }

    // 新規登録処理
    @PostMapping("/store")
    public String store(@ModelAttribute House house) {
        houseRepository.save(house);
        return "redirect:/admin/houses";
    }

    // 編集フォーム
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("house", houseRepository.findById(id).orElseThrow());
        return "admin/houses/edit";
    }

    // 編集処理
    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id, @ModelAttribute House house) {
        house.setId(id);
        houseRepository.save(house);
        return "redirect:/admin/houses";
    }

    // 削除
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        houseRepository.deleteById(id);
        return "redirect:/admin/houses";
    }
}
