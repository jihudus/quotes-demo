package com.example.quotes.controller;

import com.example.quotes.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> authenticate(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String authHeader) {
        if (!authHeader.startsWith("Basic ")) {
            return new ResponseEntity<>("GET NO AUTHENTICATION", HttpStatus.UNAUTHORIZED);
        }
        String substring = authHeader.substring(6);
        String token = memberService.getAuthToken(substring);
        return ResponseEntity.ok(token);
    }

    @GetMapping
    public ResponseEntity<String> hello(Authentication auth) {
        return ResponseEntity.ok(auth.toString());
    }
}
