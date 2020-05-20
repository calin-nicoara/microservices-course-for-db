package ro.esolacad.microservicesdemo.auth.entitites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;


public class CustomUserDetails extends User {
    @Getter
    private final String fullName;

    public CustomUserDetails(final String username, final String password,
                             final List<SimpleGrantedAuthority> authorities, final String fullName) {
        super(username, password, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, authorities);
        this.fullName = fullName;
    }


}
