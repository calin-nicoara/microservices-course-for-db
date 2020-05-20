package ro.esolacad.microservicesdemo.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.auth.entitites.CustomUserDetails;

import java.util.Arrays;

@Service
@Primary
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public CustomUserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        return new CustomUserDetails("calin", passwordEncoder.encode("password"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")), "CAlin Nicoara");
    }
}
