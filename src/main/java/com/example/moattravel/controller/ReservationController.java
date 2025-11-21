package com.example.moattravel.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * ① 入力画面（input.html）
     */
    @GetMapping("/input")
    public String showInputForm(@RequestParam("houseId") Integer houseId, Model model) {

        House house = houseService.findById(houseId);
        if (house == null) {
            return "redirect:/";
        }
        model.addAttribute("house", house);

        return "reservations/input";
    }

    /**
     * ② 確認画面（confirm.html）
     */
    @PostMapping("/confirm")
    public String showConfirm(
            @RequestParam Integer houseId,
            @RequestParam String checkinDate,
            @RequestParam String checkoutDate,
            @RequestParam Integer numPeople,
            Model model) {

        House house = houseService.findById(houseId);

        LocalDate in = LocalDate.parse(checkinDate);
        LocalDate out = LocalDate.parse(checkoutDate);

        long nights = ChronoUnit.DAYS.between(in, out);
        int totalPrice = (int) (house.getPrice() * nights * numPeople);

        model.addAttribute("house", house);
        model.addAttribute("checkinDate", checkinDate);
        model.addAttribute("checkoutDate", checkoutDate);
        model.addAttribute("numPeople", numPeople);
        model.addAttribute("nights", nights);
        model.addAttribute("totalPrice", totalPrice);

        return "reservations/confirm";
    }

    /**
     * ③ 完了画面（complete.html）
     */
    @PostMapping("/complete")
    public String completeReservation(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam Integer houseId,
            @RequestParam String checkinDate,
            @RequestParam String checkoutDate,
            @RequestParam Integer numPeople,
            Model model) {

        House house = houseService.findById(houseId);
        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        LocalDate in = LocalDate.parse(checkinDate);
        LocalDate out = LocalDate.parse(checkoutDate);

        Reservation reservation = reservationService.createReservation(
                house,
                user,
                in,
                out,
                numPeople
        );

        model.addAttribute("reservation", reservation);

        return "reservations/complete";
    }

    /**
     * マイページから予約一覧を見る
     */
    @GetMapping("/my")
    public String myReservations(
            @AuthenticationPrincipal UserDetails userDetails,
            Model model) {

        User user = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();
        model.addAttribute("reservations", reservationService.findByUser(user));

        return "reservations/list";
    }
}
