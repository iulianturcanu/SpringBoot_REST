package com.iudtu.lunchbox.dto.mapper;

import com.iudtu.lunchbox.dto.InventoryItemDto;
import com.iudtu.lunchbox.model.InventoryItem;

public class InventoryItemMapper {

    public  static InventoryItemDto toInventoryDto(InventoryItem inventoryItem){
        InventoryItemDto inventoryItemDto = new InventoryItemDto();
        inventoryItemDto.setId(inventoryItem.getId());
        inventoryItemDto.setCount(inventoryItem.getCount());
        inventoryItemDto.setItem(inventoryItem.getItem());
        return inventoryItemDto;
    }

}
