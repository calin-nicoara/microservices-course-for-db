package ro.esolacad.microservicesdemo.store.services;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.esolacad.microservicesdemo.store.models.ProductInventoryModel;

import java.math.BigDecimal;

@Component
@Slf4j
public class InventoryClientFallFactory implements FallbackFactory<InventoryClient> {

    @Override
    public InventoryClient create(final Throwable throwable) {
        log.error("error", throwable);
        return new InventoryClient() {
            @Override
            public ResponseEntity<ProductInventoryModel> getProductInventory(final String code) {
                return ResponseEntity.ok(
                        ProductInventoryModel.builder()
                                .productCode(code)
                                .price(BigDecimal.ZERO)
                                .stock(0)
                                .build()
                );
            }
        };
    }
}
