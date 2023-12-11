package com.example.quotes.service;

import com.example.quotes.entity.Member;

public interface MemberService {

    String getAuthToken(String authString);

    Member readMemberByEmail(String email);
}
