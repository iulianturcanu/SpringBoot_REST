package com.iudtu.lunchbox.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Inventory {

    @Id
    @SequenceGenerator(name="inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "inventory_sequence")
    private Long id;
    @Column(unique = true)
    private String itemName;
    private Integer count;

    public Inventory(String itemName, Integer count){
        this.setItemName(itemName);
        this.setCount(count);
    }
}
