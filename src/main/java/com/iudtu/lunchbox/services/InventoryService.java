package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.InventoryItemDto;
import com.iudtu.lunchbox.dto.LunchboxItemDto;
import com.iudtu.lunchbox.dto.mapper.InventoryItemMapper;
import com.iudtu.lunchbox.dto.mapper.Mapper;
import com.iudtu.lunchbox.model.InventoryItem;
import com.iudtu.lunchbox.model.LunchboxItem;
import com.iudtu.lunchbox.repository.InventoryItemRepository;
import com.iudtu.lunchbox.repository.LunchboxItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


@Service
public class InventoryService  {
    private final InventoryItemRepository inventoryItemRepository;
    private final LunchboxItemRepository lunchboxItemRepository;

    private final int MINIMAL_STOCK = 5;

    @Autowired
    public InventoryService(InventoryItemRepository inventoryItemRepository, LunchboxItemRepository lunchboxItemRepository){
        this.inventoryItemRepository = inventoryItemRepository;
        this.lunchboxItemRepository = lunchboxItemRepository;
    }



    public InventoryItemDto create() {
        return InventoryItemMapper.toInventoryDto(new InventoryItem());
    }

    public Set<LunchboxItem> whatItemsNeedRestocking() {
        return null;
    }

    public boolean needsRestocking() {
//        return inventory.getCount() <= MINIMAL_STOCK;
        return false;
    }

    public boolean needsRestocking(LunchboxItem item) {
        Optional<InventoryItem> optionalInventoryItem = inventoryItemRepository.findOneByItem(item);
        if (!optionalInventoryItem.isPresent()) {
            throw new IllegalStateException("no such item");
        }
        return optionalInventoryItem.get().getCount() <= MINIMAL_STOCK;
    }

    public List<InventoryItemDto> getAllAvailableItems() {
        List<InventoryItem> foundItems = inventoryItemRepository.findAll();
        List<InventoryItemDto> result = Mapper.mapAll(foundItems, InventoryItemDto.class);
        return result;
    }

    public Map<LunchboxItemDto, Integer> getAllAvailableItemsWithCounts() {
        return null;
    }

    public void addItems(LunchboxItemDto item, int count) {

    }

    public void removeItems(LunchboxItemDto item, int count) throws InventoryException {

    }


    public InventoryItemDto createNewInventoryItem(LunchboxItemDto newItem) {
        LunchboxItem newLunchboxItem = new LunchboxItem();
        newLunchboxItem.setItemType(newItem.getItemType());
        newLunchboxItem.setHealthy(newItem.isHealthy());
        newLunchboxItem.setName(newItem.getName());
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setCount(0);
        inventoryItem.setItem(newLunchboxItem);
        newLunchboxItem.setInventoryItem(inventoryItem);
        LunchboxItem savedLunchboxItem = lunchboxItemRepository.save(newLunchboxItem);
        InventoryItem savedInventoryItem = savedLunchboxItem.getInventoryItem();

        InventoryItemDto inventoryItemDto = Mapper.map(savedInventoryItem, InventoryItemDto.class);
        return inventoryItemDto;
    }
}
