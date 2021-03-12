package com.iudtu.lunchbox.model;

import com.iudtu.lunchbox.dto.LunchboxItemDto;
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
public class Lunchbox {

    @Id
    @SequenceGenerator(name="lunchbox_sequence",
            sequenceName = "lunchbox_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "lunchbox_sequence")
    private Long id;
    private String owner;
    private String description;
    private Integer capacity;

    @OneToMany(mappedBy = "lunchbox")
    private List<LunchboxItem> lunchboxItemsList;

    public Lunchbox(String owner, String description, Integer capacity, List<LunchboxItem> lunchboxItemsList){
        this.setOwner(owner);
        this.setDescription(description);
        this.setCapacity(capacity);
        this.setLunchboxItemsList(lunchboxItemsList);

    }
}
