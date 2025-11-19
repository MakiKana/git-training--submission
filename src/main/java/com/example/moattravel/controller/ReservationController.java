package com.example.moattravel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel.entity.House;
import com.example.moattravel.entity.Reservation;
import com.example.moattravel.entity.User;
import com.example.moattravel.repository.UserRepository;
import com.example.moattravel.service.HouseService;
import com.example.moattravel.service.ReservationService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/new/{houseId}")
    public String showConfirm(@PathVariable("houseId") Integer houseId,
                              @AuthenticationPrincipal UserDetails userDetails,
                              Model model) {
        House house = houseService.findById(houseId);
        if (house == null) {
            return "redirect:/";
        }
        model.addAttribute("house", house);
        model.addAttribute("reservation", new Reservation());
        return "reservations/confirm";
    }

    @PostMapping("/new/{houseId}")
    public String create(@PathVariable("houseId") Integer houseId,
                         @ModelAttribute("reservation") Reservation form,
                         @AuthenticationPrincipal UserDetails userDetails) {
        House house = houseService.findById(houseId);
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        reservationService.createReservation(house, user, form);
        return "redirect:/reservations/my";
    }

    @GetMapping("/my")
    public String myReservations(@AuthenticationPrincipal UserDetails userDetails,
                                 Model model) {
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        model.addAttribute("reservations", reservationService.findByUser(user));
        return "reservations/list";
    }
}
