package com.example.moattravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.moattravel.model.House;

public interface HouseRepository extends JpaRepository<House, Integer> {
}
