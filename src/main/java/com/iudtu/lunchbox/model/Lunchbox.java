package com.iudtu.lunchbox.model;

import com.iudtu.lunchbox.dto.LunchboxItemDto;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
public class Lunchbox {

    private String owner;
    private String description;
    private Integer capacity;
    private List<LunchboxItem> lunchboxItemsList;
}
