package com.iudtu.lunchbox.dto;

import lombok.Data;

@Data
public class LunchboxItemDto {
    private String name;
    private boolean isHealthy;
    private ItemType itemType;
}