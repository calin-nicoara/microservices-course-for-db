package ro.esolacad.microservicesdemo.store.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductInventoryComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @Test
    public void test() throws Exception {
        productInventoryRepository.findAll();

        String productCode = "PR_1";

        ProductInventoryModel productInventoryModel = ProductInventoryModel.builder()
                .productCode("PR_1")
                .stock(2)
                .build();

        productInventoryRepository.save(ProductInventory.builder()
                .id(1L)
                .productCode(productCode)
                .extraStock(2)
                .build());

        final MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/inventory/" + productCode)
                .contentType("application/json")
                .content("{}")
        )
                .andExpect(status().isOk())
                .andReturn();

        final String contentAsString = mvcResult.getResponse().getContentAsString();

        Assertions.assertThat(contentAsString).isEqualTo(objectMapper.writeValueAsString(productInventoryModel));
    }
}
