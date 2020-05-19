package ro.esolacad.microservicesdemo.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ro.esolacad.microservicesdemo.checkout.entities.Cart;
import ro.esolacad.microservicesdemo.checkout.repository.CartRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class CheckoutApplication {

	private final CartRepository cartRepository;

	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Cart cart = Cart.builder()
				.clientCode("CL_1")
				.build();

		cartRepository.save(cart);
	}
}
