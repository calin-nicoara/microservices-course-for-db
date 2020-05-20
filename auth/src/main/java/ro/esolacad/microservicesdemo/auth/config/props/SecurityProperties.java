package ro.esolacad.microservicesdemo.auth.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@ConfigurationProperties("security")
public class SecurityProperties {

    @Getter
    @Setter
    private JwtProperties jwt;

    @Getter
    @Setter
    public static class JwtProperties {
        private Resource keyStore;
        private String keyStorePassword;
        private String keyPairAlias;
    }
}
