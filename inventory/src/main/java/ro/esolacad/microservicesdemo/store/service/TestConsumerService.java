package ro.esolacad.microservicesdemo.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.store.model.StockChangeModel;

@Service
@RequiredArgsConstructor
public class TestConsumerService {

    private final ProductInventoryContract productInventoryService;

    @StreamListener("stockChannel")
    public void testReceive(final Message<StockChangeModel> message) {
        System.out.println();
        System.out.println("REceived message " + message.getPayload());
        System.out.println();

        productInventoryService.modifyStock(message.getPayload());
    }
}
