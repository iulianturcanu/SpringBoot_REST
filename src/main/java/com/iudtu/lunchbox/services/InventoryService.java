package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.InventoryDto;
import com.iudtu.lunchbox.dto.mapper.InventoryMapper;
import com.iudtu.lunchbox.model.Inventory;
import com.iudtu.lunchbox.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryDto> needsRestocking(Integer count){
        ArrayList<InventoryDto> foundItems= new ArrayList<>();
        Optional<Inventory> toRestock = inventoryRepository.findByLunchboxItemNameAndCount(count);
        if(toRestock.isPresent()){
            foundItems.add(InventoryMapper.toInventoryDto(toRestock.get()));
            return foundItems;
        } throw new IllegalStateException("nothing to restock");
    }
}
