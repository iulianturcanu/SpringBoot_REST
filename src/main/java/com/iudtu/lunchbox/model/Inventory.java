package com.iudtu.lunchbox.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private Integer count;

    @OneToMany(mappedBy = "inventory")
    private List<LunchboxItem> itemList;


    public Inventory(Integer count, List<LunchboxItem> itemList){
        this.setCount(count);
        this.setItemList(itemList);
    }
}
