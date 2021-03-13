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




    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "lunchbox_id", nullable = true)
    private Lunchbox lunchbox;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private InventoryItem inventoryItem;

    public LunchboxItem(String name, boolean isHealthy, ItemType itemType, Lunchbox lunchbox){
        this.setName(name);
        this.setHealthy(isHealthy);
        this.setItemType(itemType);
        this.setLunchbox(lunchbox);
    }



}
