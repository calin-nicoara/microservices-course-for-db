package ro.esolacad.microservicesdemo.store.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;
import ro.esolacad.microservicesdemo.store.resource.InventoryResource;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * MVC test this in plus besides what a regular unit test would do:
 * - listen to http request
 * - deserialize input
 * - validate input
 * - serialize the output
 * - Translate Exceptions
 *
 * FAIL!!!!
 */

@WebMvcTest(controllers = InventoryResource.class)
public class ProductInventoryMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductInventoryService productService;

    @MockBean
    private ProductInventoryRepository productInventoryRepository;

    @Test
    @WithMockUser(username = "hello")
    public void testGEt() throws Exception{
        String productCode = "PR_1";


        ProductInventoryModel productInventoryModel = ProductInventoryModel.builder()
                .productCode(productCode)
                .build();

        when(productService.findByProductCode(productCode))
                .thenReturn(Optional.of(productInventoryModel));

        mockMvc.perform(
                get("/inventory/" + productCode))
                .andExpect(status().isOk());
    }

//    @Test
//    public void testAddProduct() throws Exception{
//        ProductModel productModel = ProductModel.builder().code("PR_1").build();
//
//        when(productService.save(productModel)).thenReturn(productModel);
//
//        mockMvc.perform(
//                post("/v1/products")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(productModel))
//        )
//                .andExpect(status().isOk());
//    }
}
