package ro.esolacad.microservicesdemo.store.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import java.math.BigDecimal;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductInventoryIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductInventoryRepository productRepository;

    @Test
    void fullFledged() throws Exception{
        ProductInventoryModel productModel = ProductInventoryModel.builder()
                .productCode("PR_1")
                .price(BigDecimal.TEN)
                .stock(4)
                .build();

        mockMvc.perform(
                post("/v1/products")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(productModel))
        )
                .andExpect(status().isOk());

        Collection<ProductInventory> productFrom = productRepository.findAll();
        assertThat(productFrom).hasSize(1);
        productFrom.forEach(product -> {
            assertThat(product).isEqualTo(ProductInventory.builder()
                    .id(1L)
                    .productCode("PR_1")
                    .price(BigDecimal.TEN.setScale(2))
                    .extraStock(4)
                    .build());
        });
    }
}
