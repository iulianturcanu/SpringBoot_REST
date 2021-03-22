package com.iudtu.lunchbox.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class InventoryItem {

    @Id
    @Column(name = "item_id")
    private Long id;

    private Integer count;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    @MapsId
    private LunchboxItem item;


    public InventoryItem(Integer count){
        this.setCount(count);
    }
}
