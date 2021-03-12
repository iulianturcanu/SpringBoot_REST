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
    private Integer count;

    @Column(name = "name", unique = true)
    private String name;

//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "name", nullable = false)
//    private LunchboxItem lunchboxItem;

    public Inventory(String name, Integer count){
        this.setName(name);
        this.setCount(count);
    }
}
