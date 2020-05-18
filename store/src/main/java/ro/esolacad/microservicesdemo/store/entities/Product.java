package ro.esolacad.microservicesdemo.store.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;

    private String description;

    @ManyToOne
    private Category category;
}
