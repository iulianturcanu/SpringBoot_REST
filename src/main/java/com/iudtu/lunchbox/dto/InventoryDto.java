package com.iudtu.lunchbox.dto;

import lombok.Data;

@Data
public class InventoryDto {
    private Long count;
    private ItemType itemType;
}
