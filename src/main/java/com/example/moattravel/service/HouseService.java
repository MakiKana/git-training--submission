package com.example.moattravel.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moattravel.entity.House;
import com.example.moattravel.repository.HouseRepository;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    public List<House> findAll() {
        return houseRepository.findAll();
    }

    public House findById(Integer id) {
        return houseRepository.findById(id).orElse(null);
    }

    public House save(House house) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        if (house.getId() == null) {
            house.setCreatedAt(now);
        }
        house.setUpdatedAt(now);
        return houseRepository.save(house);
    }

    public void delete(Integer id) {
        houseRepository.deleteById(id);
    }
}
