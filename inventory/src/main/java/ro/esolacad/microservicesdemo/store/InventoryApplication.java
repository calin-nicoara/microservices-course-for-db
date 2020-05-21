package ro.esolacad.microservicesdemo.store;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

@SpringBootApplication
@RequiredArgsConstructor
//@EnableDiscoveryClient
public class InventoryApplication {

	private final ProductInventoryRepository productInventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
