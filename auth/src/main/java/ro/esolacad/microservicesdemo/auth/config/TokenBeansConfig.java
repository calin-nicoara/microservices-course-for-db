package ro.esolacad.microservicesdemo.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import ro.esolacad.microservicesdemo.auth.config.props.SecurityProperties;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class TokenBeansConfig {

    private final AuthenticationManager authenticationManager;
    private final SecurityProperties securityProperties;

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        CustomTokenEnhancer customTokenEnhancer = new CustomTokenEnhancer();

        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(securityProperties.getJwt().getKeyStore(),
                securityProperties.getJwt().getKeyStorePassword().toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(securityProperties.getJwt().getKeyPairAlias());

        customTokenEnhancer.setKeyPair(keyPair);
        return customTokenEnhancer;
    }

    @Bean
    public DefaultTokenServices tokenServices(final TokenStore tokenStore,
                                              final ClientDetailsService clientDetailsService) {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setAuthenticationManager(authenticationManager);

        return tokenServices;
    }


}
