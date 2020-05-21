package ro.esolacad.microservicesdemo.store.service;

import org.junit.jupiter.api.Test;
import ro.esolacad.microservicesdemo.store.assertions.ProductInventoryAssertion;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;

import java.math.BigDecimal;

public class CustomAssertionTest {

    @Test
    public void testCustomAssertion() {
        final ProductInventoryModel productInvetoryExpected = ProductInventoryModel.builder()
                .productCode("PR_1")
                .price(BigDecimal.TEN)
                .stock(4)
                .build();

        ProductInventoryAssertion.assertThat(productInvetoryExpected)
                .hasProductCodeEqualTo("PR_2");
    }
}
