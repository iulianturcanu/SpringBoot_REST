package com.iudtu.lunchbox.dto.mapper;

import com.iudtu.lunchbox.dto.InventoryDto;
import com.iudtu.lunchbox.model.Inventory;

public class InventoryMapper {

    public  static InventoryDto toInventoryDto(Inventory inventory){
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(inventory.getId());
        inventoryDto.setCount(inventory.getCount());
        inventoryDto.setItemList(inventory.getItemList());
        return inventoryDto;
    }
}
