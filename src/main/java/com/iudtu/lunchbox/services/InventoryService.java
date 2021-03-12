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


}
