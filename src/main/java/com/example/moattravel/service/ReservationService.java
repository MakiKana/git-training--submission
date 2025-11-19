package com.example.moattravel.service;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moattravel.entity.House;
import com.example.moattravel.entity.Reservation;
import com.example.moattravel.entity.User;
import com.example.moattravel.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(House house, User user, Reservation reservationForm) {
        Reservation r = new Reservation();
        r.setHouse(house);
        r.setUser(user);
        r.setCheckinDate(reservationForm.getCheckinDate());
        r.setCheckoutDate(reservationForm.getCheckoutDate());
        r.setNumberOfPeople(reservationForm.getNumberOfPeople());

        long days = ChronoUnit.DAYS.between(
                r.getCheckinDate(),
                r.getCheckoutDate()
        );
        if (days <= 0) {
            days = 1;
        }
        r.setAmount((int) days * house.getPrice());

        Timestamp now = new Timestamp(System.currentTimeMillis());
        r.setCreatedAt(now);
        r.setUpdatedAt(now);

        return reservationRepository.save(r);
    }

    public List<Reservation> findByUser(User user) {
        return reservationRepository.findByUserOrderByCreatedAtDesc(user);
    }
}
