package ro.esolacad.microservicesdemo.store.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductInventoryInitialServiceTest {
    private ProductInventoryRepository productInventoryRepository = Mockito.mock(ProductInventoryRepository.class);

    private ProductInventoryService productInventoryService;

    @BeforeEach
    void initUseCase() {
        productInventoryService = new ProductInventoryService(productInventoryRepository);
    }

    @Test
    public void save() {
        String productCode = "PR_1";

        ProductInventory productInventory = ProductInventory.builder()
                .id(1L)
                .productCode(productCode)
                .build();

        ProductInventoryModel productInventoryModel = ProductInventoryModel.builder()
                .productCode(productCode)
                .build();

        Mockito.when(productInventoryRepository.findByProductCode(productCode))
                .thenReturn(Optional.of(productInventory));

        final Optional<ProductInventoryModel> byProductCode = productInventoryService.findByProductCode(productCode);

        assertThat(byProductCode).isEqualTo(Optional.of(productInventoryModel));
    }
}
