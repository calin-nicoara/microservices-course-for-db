package ro.esolacad.microservicesdemo.store.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

//@ExtendWith(SpringExtension.class)
//@WebMvcTest
public class ProductInventoryMvcTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private ProductService productService;
//
//    @MockBean
//    private ProductRepository productRepository;
//
////    @Test
//    public void testAddProduct() throws Exception{
//        ProductModel productModel = ProductModel.builder().code("PR_1").build();
//
//        when(productService.save(productModel)).thenReturn(productModel);
//
//        mockMvc.perform(
//                post("/v1/products")
//                .contentType("application/json")
//                .content(objectMapper.writeValueAsString(productModel))
//        )
//                .andExpect(status().isOk());
//    }
}
