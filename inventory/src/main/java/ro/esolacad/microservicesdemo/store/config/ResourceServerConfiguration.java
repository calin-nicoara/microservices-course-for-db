package ro.esolacad.microservicesdemo.store.config;

//@EnableResourceServer
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@Profile("security")
public class ResourceServerConfiguration
//        extends ResourceServerConfigurerAdapter
{

//    @Value("${security.jwt.public-key}")
//    private Resource publicKey;
//
//    @Bean
//    public DefaultTokenServices tokenServices(final TokenStore tokenStore) {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setTokenStore(tokenStore);
//        return tokenServices;
//    }
//
//    @Bean
//    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
//        return new JwtTokenStore(jwtAccessTokenConverter);
//    }
//
//    @Bean
//    @Primary
//    public JwtAccessTokenConverter jwtAccssTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setVerifierKey(getPublicKeyAsString());
//        return converter;
//    }
//
//    private String getPublicKeyAsString() {
//        try {
//            return IOUtils.toString(publicKey.getInputStream());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
