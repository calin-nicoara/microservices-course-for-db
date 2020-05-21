package ro.esolacad.microservicesdemo.store.service;

import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;

import java.math.BigDecimal;

@Service
public class TestIsolatedService {

    public ProductInventory getInventoryObject() {
        return ProductInventory.builder()
                .id(1L)
                .productCode("PR_1")
                .price(BigDecimal.TEN)
                .extraStock(4)
                .build();
    }
}
