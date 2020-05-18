package ro.esolacad.microservicesdemo.store.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ro.esolacad.microservicesdemo.store.models.ProductInventoryModel;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class InventoryService {


    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl;

    public InventoryService(@Value("${api.url.inventory}") String apiUrl) {
        this.apiUrl = Objects.requireNonNull(apiUrl, "apiUrl should not be null");
    }

    public ProductInventoryModel findProductInventoryByCode(final String code) {
        String urlForProductCode = this.apiUrl + code;
        try {
            ResponseEntity<ProductInventoryModel> forEntity = restTemplate.getForEntity(urlForProductCode, ProductInventoryModel.class);
            return forEntity.getBody();
        } catch(HttpClientErrorException exception) {
            log.error("Product Inventory not found", exception);

            return ProductInventoryModel.builder()
                    .price(BigDecimal.ZERO)
                    .stock(0)
                    .build();
        }
    }

    public Optional<ProductInventoryModel> findOptionalProductInventoryByCode(final String code) {
        String urlForProductCode = "http://localhost:8080/inventory/" + code;
        try {
            ResponseEntity<ProductInventoryModel> forEntity = restTemplate.getForEntity(urlForProductCode, ProductInventoryModel.class);
            return Optional.ofNullable(forEntity.getBody());
        } catch(HttpClientErrorException exception) {
            return Optional.empty();
        }
    }
}
