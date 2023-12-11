package com.example.quotes.service;

import com.example.quotes.controller.RegistrationController;
import com.example.quotes.dto.MemberDTO;
import com.example.quotes.entity.Member;
import com.example.quotes.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberDTO registerNewMember(RegistrationController.RegisterDTO registerDTO) {
        Member member = Member.builder()
                .email(registerDTO.email())
                .name(registerDTO.name())
                .password(passwordEncoder.encode(registerDTO.password()))
                .build();
        Member saved = memberRepository.save(member);
        return MemberDTO.fromMember(saved);
    }
}
