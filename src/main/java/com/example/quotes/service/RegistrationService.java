package com.example.quotes.service;

import com.example.quotes.controller.RegistrationController;
import com.example.quotes.dto.MemberDTO;
import org.springframework.transaction.annotation.Transactional;

public interface RegistrationService {

    @Transactional
    MemberDTO registerNewMember(RegistrationController.RegisterDTO registerDTO);
}
