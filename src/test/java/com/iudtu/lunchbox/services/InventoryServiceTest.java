package com.iudtu.lunchbox.services;


import com.iudtu.lunchbox.dto.InventoryItemDto;
import com.iudtu.lunchbox.dto.ItemType;
import com.iudtu.lunchbox.dto.LunchboxItemDto;
import com.iudtu.lunchbox.dto.mapper.Mapper;
import com.iudtu.lunchbox.model.InventoryItem;
import com.iudtu.lunchbox.model.LunchboxItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    InventoryService inventoryService;


    @AfterEach
    public void deleteAll() {
        inventoryService.deleteAll();
    }

    @Test
    public void testEmptyInventory() {
        List<InventoryItemDto> items = inventoryService.getAllAvailableItems();
        Assertions.assertNotNull(items);
        assertEquals(0, items.size());
    }


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
        LunchboxItemDto newItem = new LunchboxItemDto();
        newItem.setName("apple");
        newItem.setHealthy(true);
        newItem.setItemType(ItemType.FRUIT);
        InventoryItemDto inventoryItem = inventoryService.createNewInventoryItem(newItem);
        assertNotNull(inventoryItem);

        inventoryService.deleteLunchboxItem(newItem);
        assertEquals(0, inventoryService.getAllAvailableItems().size());
    }

    @Test
    public void testAddItems() {
        LunchboxItemDto newItem = new LunchboxItemDto();
        newItem.setName("apple");
        newItem.setHealthy(true);
        newItem.setItemType(ItemType.FRUIT);
        InventoryItemDto inventoryItem = inventoryService.createNewInventoryItem(newItem);
        assertNotNull(inventoryItem);

        inventoryService.addItems(newItem, 3);
        assertEquals(3, inventoryService.findOneByItem(Mapper.map(newItem, LunchboxItem.class)).getCount());

    }
    @Test
    public void testRemoveItems() throws InventoryException {
        LunchboxItemDto newItem = new LunchboxItemDto();
        newItem.setName("apple");
        newItem.setHealthy(true);
        newItem.setItemType(ItemType.FRUIT);

        InventoryItem newInventoryItem = new InventoryItem();
        newInventoryItem.setCount(10);
        newItem.setInventoryItem(newInventoryItem);
        InventoryItemDto inventoryItem = inventoryService.createNewInventoryItem(newItem);
        assertNotNull(inventoryItem);

//        inventoryService.removeItems(Mapper.map(newItem, LunchboxItem.class), 4);
//        assertEquals(6, inventoryService.findOneByItem(Mapper.map(newItem, LunchboxItem.class)).getCount());

    }
    @Test
    public void testGetAllAvailableItems() {
        assertNotNull(null);
    }
}