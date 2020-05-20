package ro.esolacad.microservicesdemo.store;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.context.SecurityContextHolder;
import ro.esolacad.microservicesdemo.store.entities.Category;
import ro.esolacad.microservicesdemo.store.entities.Product;
import ro.esolacad.microservicesdemo.store.repositories.CategoryRepository;
import ro.esolacad.microservicesdemo.store.repositories.ProductRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class StoreApplication {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);

		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
	}

	@PostConstruct
	public void init() {
		Category category = Category.builder()
				.code("CAT_1")
				.name("Bauturi")
				.build();

		categoryRepository.save(category);

		Product product = Product.builder()
				.name("Cola")
				.code("PR_1")
				.category(category)
				.build();

		Product product2 = Product.builder()
				.name("Pepsi")
				.code("PR_2")
				.category(category)
				.build();

		productRepository.save(product);
		productRepository.save(product2);
	}
}
