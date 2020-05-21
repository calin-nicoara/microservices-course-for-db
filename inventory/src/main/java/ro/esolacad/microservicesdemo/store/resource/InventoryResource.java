package ro.esolacad.microservicesdemo.store.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.model.StockChangeModel;
import ro.esolacad.microservicesdemo.store.service.IProductInventoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryResource {

    private final IProductInventoryService productInventoryService;

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProductInventoryModel> getProductByCode(@PathVariable("code") String code) {
        return productInventoryService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/stock")
    public ResponseEntity<Void> modifyStock(@RequestBody StockChangeModel stockChangeModel) {
        productInventoryService.modifyStock(stockChangeModel);

        return ResponseEntity.ok().build();
    }
}
