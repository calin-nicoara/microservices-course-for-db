package ro.esolacad.microservicesdemo.store.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductInventoryServiceTest {

    @Mock
    private ProductInventoryRepository productInventoryRepository;

    @InjectMocks
    private ProductInventoryService productInventoryService;

    @BeforeEach
    void initUseCase() {
        productInventoryService = new ProductInventoryService(productInventoryRepository);
    }

    @Test
    void testStuff() {
        String productCode = "PR_1";

        when(productInventoryRepository.findByProductCode(productCode))
                .thenReturn(Optional.of(ProductInventory
                        .builder()
                        .productCode("PR_1")
                        .price(BigDecimal.TEN)
                        .build()));

        Optional<ProductInventoryModel> byProductCode = productInventoryService.findByProductCode(productCode);

        assertEquals(byProductCode, Optional.of(
                ProductInventoryModel.builder()
                        .productCode("PR_1")
                        .price(BigDecimal.TEN)
                        .build()
        ));
    }
}
