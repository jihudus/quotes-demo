package com.example.quotes.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class RequestMatcherManager implements AuthorizationManager<RequestAuthorizationContext> {

    private final UserDetailsService memberService;

    /* Quote id must be in authorities list */
    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        String path = object.getRequest().getServletPath().replaceFirst("/", "");
        String[] split = path.split("/");
        if (split.length != 2 || !split[0].equals("quotes")) return null;
        String name = object.getRequest().getUserPrincipal().getName();
        boolean grant = memberService.loadUserByUsername(name)
            .getAuthorities()
            .stream()
            .anyMatch(a -> match(a, split[1]));
        return new AuthorizationDecision(grant);
    }

    private boolean match(GrantedAuthority a, String s) {
        String authString = a.getAuthority();
        String scope = authString.substring(authString.indexOf("_") + 1); // Remove prefix "SCOPE_"
        return s.equals(scope);
    }
}
