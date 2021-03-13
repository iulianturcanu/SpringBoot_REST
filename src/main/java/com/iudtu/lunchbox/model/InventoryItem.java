package com.iudtu.lunchbox.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table
@Setter
@Getter
@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
public class InventoryItem {

    @Id
    @Column(name = "item_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @OneToOne
    @JoinColumn(name = "item_id")
    @MapsId
    private LunchboxItem item;


//    public InventoryItem(Integer count, LunchboxItem item){
//        this.setCount(count);
//        this.setItem(item);
//    }
}
