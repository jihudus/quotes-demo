package com.example.quotes.controller;

import com.example.quotes.dto.MemberDTO;
import com.example.quotes.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public MemberDTO postMember(@RequestBody RegisterDTO registerDTO) {
        return registrationService.registerNewMember(registerDTO);
    }

    public record RegisterDTO(String name, String email, String password) {}
}
