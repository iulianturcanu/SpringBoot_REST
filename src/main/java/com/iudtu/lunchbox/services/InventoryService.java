package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.InventoryDto;
import com.iudtu.lunchbox.dto.mapper.InventoryMapper;
import com.iudtu.lunchbox.model.Inventory;
import com.iudtu.lunchbox.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public abstract class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    private boolean mustRestock(Inventory inventory){
        return inventory.getCount() <= 5;
    }

    public ArrayList<InventoryDto> needsRestocking(){
        ArrayList<Inventory> allInventory =(ArrayList<Inventory>)inventoryRepository.findAll();
        ArrayList<InventoryDto> toRestock = new ArrayList<>();
        for(Inventory item: allInventory){
            if(mustRestock(item)){
                toRestock.add(InventoryMapper.toInventoryDto(item));
            }return toRestock;
        }return new ArrayList<>();
    }

}
