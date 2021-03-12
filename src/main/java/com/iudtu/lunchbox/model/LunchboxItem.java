package com.iudtu.lunchbox.model;

import com.iudtu.lunchbox.dto.ItemType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "lunchbox_item")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LunchboxItem {

    @Id
    @SequenceGenerator(name="lunchboxItem_sequence",
            sequenceName = "lunchboxItem_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "lunchboxItem_sequence")
    private Long id;

    private String name;
    private boolean isHealthy;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;




    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    private Lunchbox lunchbox;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    public LunchboxItem(String name, boolean isHealthy, ItemType itemType, Lunchbox lunchbox){
        this.setName(name);
        this.setHealthy(isHealthy);
        this.setItemType(itemType);
        this.setLunchbox(lunchbox);
    }



}
