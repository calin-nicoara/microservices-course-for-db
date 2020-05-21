package ro.esolacad.microservicesdemo.store;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
public class InventoryApplication {


	private final ProductInventoryRepository productInventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@PostConstruct
	public void init() {
		productInventoryRepository.save(ProductInventory.builder()
				.productCode("PR_1")
				.extraStock(3)
				.price(BigDecimal.TEN)
				.build());
	}

}
