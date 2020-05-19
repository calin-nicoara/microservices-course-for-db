package ro.esolacad.microservicesdemo.checkout.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.esolacad.microservicesdemo.checkout.config.KafkaGateway;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestResource {

    private final KafkaGateway kafkaGateway;

//    @PostMapping
//    public void pushMessage(@RequestBody String message) {
//        kafkaGateway.writTest(message);
//    }
}
