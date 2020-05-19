package ro.esolacad.microservicesdemo.checkout.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCartItemModel {

    private Long cartId;

    private String productCode;

    private Integer quantityToAdd;
}
