package com.iudtu.lunchbox.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.iudtu.lunchbox.model.InventoryItem;
import com.iudtu.lunchbox.model.Lunchbox;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LunchboxItemDto {
    private Long id;
    private String name;
    private boolean isHealthy;
    private ItemType itemType;
    private Lunchbox lunchbox;
    private InventoryItem inventoryItem;

}
