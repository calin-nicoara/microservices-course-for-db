package ro.esolacad.microservicesdemo.store.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductInventoryServiceTest {

    @Mock
    private ProductInventoryRepository productInventoryRepository;

    @InjectMocks
    private ProductInventoryService productInventoryService;

    @Test
    public void getProductByCode() {
        String productCodeInput = "PR_1";
        final Optional<ProductInventory> mockProductInventory = Optional.of(ProductInventory
                .builder()
                .productCode("PR_1")
                .id(1L)
                .extraStock(3)
                .price(BigDecimal.TEN)
                .build());


        Mockito.when(productInventoryRepository.findByProductCode(productCodeInput))
                .thenReturn(mockProductInventory);

        final Optional<ProductInventoryModel> expctedProductInventoryModel = Optional.of(ProductInventoryModel
                .builder()
                .productCode("PR_1")
                .stock(3)
                .price(BigDecimal.TEN)
                .build());

        final Optional<ProductInventoryModel> actualProductInventoryModelOpt =
                productInventoryService.findByProductCode(productCodeInput);

        assertThat(actualProductInventoryModelOpt).isEqualTo(expctedProductInventoryModel);
    }


}
