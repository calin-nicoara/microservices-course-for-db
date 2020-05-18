package ro.esolacad.microservicesdemo.store.entities;

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
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;
}
