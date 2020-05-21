package ro.esolacad.microservicesdemo.store.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;
import ro.esolacad.microservicesdemo.store.resource.InventoryResource;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = InventoryResource.class)
public class ProductInventoryMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductInventoryService productInventoryService;

    @MockBean
    private ProductInventoryRepository productInventoryRepository;

    @Test
    @WithMockUser(username = "calin")
    public void testGet() throws Exception {
        String productCode = "PR_1";

        ProductInventoryModel productInventoryModel = ProductInventoryModel.builder()
                .productCode(productCode)
                .build();

        Mockito.when(productInventoryService.findByProductCode(productCode))
                .thenReturn(Optional.of(productInventoryModel));

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
