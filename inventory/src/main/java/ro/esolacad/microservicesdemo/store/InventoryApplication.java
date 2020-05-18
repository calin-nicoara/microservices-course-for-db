package ro.esolacad.microservicesdemo.store;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
@RequiredArgsConstructor
public class InventoryApplication {

	private final ProductInventoryRepository productInventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@PostConstruct
	public void init() {
		ProductInventory productInventory = ProductInventory.builder()
				.price(BigDecimal.TEN)
				.productCode("PR_1")
				.stock(3)
				.build();

		productInventoryRepository.save(productInventory);
	}
}
