package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryService {
    private final Inventory inventory;

    @Autowired
    public InventoryService(Inventory inventory){
        this.inventory = inventory;
    }
}
