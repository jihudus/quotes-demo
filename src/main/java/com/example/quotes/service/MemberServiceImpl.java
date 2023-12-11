package com.example.quotes.service;

import com.example.quotes.entity.Member;
import com.example.quotes.repo.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    @Transactional
    @Override
    public String getAuthToken(String authString) {
        String decoded = new String(Base64.getDecoder().decode(authString), StandardCharsets.UTF_8);
        int delimiter = decoded.indexOf(':');
        String email = decoded.substring(0, delimiter);
        String password = decoded.substring(delimiter+1);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = basicAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return jwtService.generateToken(userDetails);
    }

    @Transactional
    @Override
    public Member readMemberByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow();
    }

    private AuthenticationManager basicAuthenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(daoAuthenticationProvider);
    }
}
