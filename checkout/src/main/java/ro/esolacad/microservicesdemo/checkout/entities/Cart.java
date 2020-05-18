package ro.esolacad.microservicesdemo.checkout.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private String clientCode;
}
