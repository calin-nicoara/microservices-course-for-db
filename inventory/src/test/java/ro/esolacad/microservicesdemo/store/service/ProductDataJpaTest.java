package ro.esolacad.microservicesdemo.store.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import java.math.BigDecimal;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductDataJpaTest {

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @Test
    void testSomeCustomMethod() {
        ProductInventory product1 = productInventoryRepository.save(ProductInventory.builder().id(1L).productCode("PR_2").extraStock(2).price(BigDecimal.valueOf(5)).build());
        ProductInventory product2 = productInventoryRepository.save(ProductInventory.builder().id(2L).productCode("PR_3").extraStock(2).price(BigDecimal.valueOf(11)).build());


        Collection<ProductInventory> eligibleProducts = productInventoryRepository.findAll();

        assertThat(eligibleProducts).containsOnly(product1);
    }
}
