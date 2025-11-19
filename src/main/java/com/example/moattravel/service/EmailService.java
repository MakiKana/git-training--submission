package com.example.moattravel.service;

import org.springframework.stereotype.Service;

import com.example.moattravel.entity.User;

@Service
public class EmailService {

    // TODO: Spring Boot Mail を使って本物のメール送信を実装
    public void sendVerificationMail(User user, String token) {
        System.out.println("Verification mail would be sent here. token=" + token);
    }
}
