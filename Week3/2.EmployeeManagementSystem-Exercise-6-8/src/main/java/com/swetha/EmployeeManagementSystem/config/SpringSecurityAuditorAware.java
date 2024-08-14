package com.swetha.EmployeeManagementSystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Assuming you are using Spring Security
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                       .map(auth -> auth.getName());
    }
}