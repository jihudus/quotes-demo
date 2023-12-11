package com.example.quotes.dto;

import com.example.quotes.entity.Member;
import com.example.quotes.entity.Quote;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@ToString
public class MemberDetails implements UserDetails {

    private final String username;

    private final String password;

    private final List<SimpleGrantedAuthority> authorities;

    public MemberDetails(Member member) {
        username = member.getEmail();
        password = member.getPassword();
        authorities = member.getQuotes().stream()
                .map(Quote::getId)
                .map(n -> new SimpleGrantedAuthority(n.toString()))
                .toList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
