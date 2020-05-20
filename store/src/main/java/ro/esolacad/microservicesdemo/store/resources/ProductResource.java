package ro.esolacad.microservicesdemo.store.resources;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ro.esolacad.microservicesdemo.store.entities.Product;
import ro.esolacad.microservicesdemo.store.models.ProductModel;
import ro.esolacad.microservicesdemo.store.repositories.ProductRepository;
import ro.esolacad.microservicesdemo.store.services.ProductService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductResource {

    private final ProductService productService;
    private final TokenStore tokenStore;

    @GetMapping("/product/{code}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<ProductModel> getProductByCode(@PathVariable("code") String code) {
        return productService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/product3/{code}")
    @PreAuthorize("#code == 'PR_1'")
    public ResponseEntity<ProductModel> getProductByOnlyCode(
            @PathVariable("code") String code,
            @RequestHeader("Authorization") String token) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());

        log.info(accessToken.getAdditionalInformation().toString());

        return productService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/product2/{code}")
    @Secured("ROLE_GUEST")
    public ResponseEntity<ProductModel> getProductByCode2(@PathVariable("code") String code) {
        return productService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
