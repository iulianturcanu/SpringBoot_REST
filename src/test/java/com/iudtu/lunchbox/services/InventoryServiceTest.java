package com.iudtu.lunchbox.services;


import com.iudtu.lunchbox.dto.InventoryItemDto;
import com.iudtu.lunchbox.dto.ItemType;
import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.dto.LunchboxItemDto;
import com.iudtu.lunchbox.model.Lunchbox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    InventoryService inventoryService;

    @Test
    public void testEmptyInventory() {
        List<InventoryItemDto> items = inventoryService.getAllAvailableItems();
        Assertions.assertNotNull(items);
        assertEquals(0, items.size());
    }

//    @Test
//    public void testAdding() {
//        inventoryService.addItems(new LunchboxItemDto());
//
//    }

    @Test
    public void testCreateLunchboxItem() {
        LunchboxItemDto newItem = new LunchboxItemDto();
        newItem.setName("apple");
        newItem.setHealthy(true);
        newItem.setItemType(ItemType.FRUIT);
        InventoryItemDto inventoryItem = inventoryService.createNewInventoryItem(newItem);
        assertNotNull(inventoryItem);
    }

    @Test
    public void testDeleteLunchboxItem() {
        assertNotNull(null);
    }
    @Test
    public void testAddItems() {
        assertNotNull(null);
    }
    @Test
    public void testRemoveItems() {
        assertNotNull(null);
    }
    @Test
    public void testGetAllAvailableItems() {
        assertNotNull(null);
    }
}