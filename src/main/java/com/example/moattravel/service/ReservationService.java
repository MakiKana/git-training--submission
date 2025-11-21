package com.example.moattravel.service;

import java.time.LocalDate;
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

    /**
     * 予約を作成する（料金計算含む）
     */
    public Reservation createReservation(House house, User user,
                                         LocalDate checkinDate,
                                         LocalDate checkoutDate,
                                         int numPeople) {

        // 泊数計算
        long nights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);

        // 合計金額計算
        int totalPrice = (int) (house.getPrice() * nights * numPeople);

        // 新しい予約エンティティを作成
        Reservation reservation = new Reservation();
        reservation.setHouse(house);
        reservation.setUser(user);
        reservation.setCheckinDate(checkinDate);
        reservation.setCheckoutDate(checkoutDate);
        reservation.setNumberOfPeople(numPeople);
        reservation.setAmount(totalPrice);

        // 保存
        return reservationRepository.save(reservation);
    }

    /**
     * 指定ユーザーの予約一覧
     */
    public List<Reservation> findByUser(User user) {
        return reservationRepository.findByUser(user);
    }
}
