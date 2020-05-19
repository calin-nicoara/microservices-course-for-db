package ro.esolacad.microservicesdemo.checkout.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;

import java.util.Objects;


public class InventoryClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl;

    public InventoryClient(@Value("${api.url.inventory}") String apiUrl) {
        this.apiUrl = Objects.requireNonNull(apiUrl, "apiUrl should not be null");
    }

    public void addStockQuantity(final AddCartItemModel addCartItemModel) {
        String urlForAddingStock = apiUrl + "/stock/";
        restTemplate.postForEntity(urlForAddingStock, addCartItemModel, Void.class);
    }
}
