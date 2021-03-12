package com.iudtu.lunchbox.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.iudtu.lunchbox.model.LunchboxItem;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class InventoryDto {

    private Long id;
    private Integer count;
    private List<LunchboxItem> itemList;
}
