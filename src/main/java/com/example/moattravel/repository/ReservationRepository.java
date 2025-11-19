package com.example.moattravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel.entity.Reservation;
import com.example.moattravel.entity.User;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByUserOrderByCreatedAtDesc(User user);
}
