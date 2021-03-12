package com.iudtu.lunchbox.model;

import com.iudtu.lunchbox.dto.ItemType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
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

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "name")
//    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name="itemId", nullable=false)
    private Lunchbox lunchbox;

    public LunchboxItem(String name, boolean isHealthy, ItemType itemType){
        this.setName(name);
        this.setHealthy(isHealthy);
        this.setItemType(itemType);
    }



}
