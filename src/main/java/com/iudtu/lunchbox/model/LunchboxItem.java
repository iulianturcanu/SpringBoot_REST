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
    @ManyToOne
    @JoinColumn(name="itemId", nullable=false)
    private Lunchbox lunchbox;
    @Column(unique = true)
    private String name;
    private boolean isHealthy;
    private ItemType itemType;

    public LunchboxItem(String name, boolean isHealthy, ItemType itemType){
        this.setName(name);
        this.setHealthy(isHealthy);
        this.setItemType(itemType);
    }



}
