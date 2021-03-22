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


import java.util.*;


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

        Iterable<LunchboxItem> allItems = lunchboxItemRepository.findAll();
        Set<LunchboxItem> needRestocking = new HashSet<>();
        for(LunchboxItem item: allItems){
            if(needsRestocking(item)){
                needRestocking.add(item);
            }
        }
        return needRestocking;
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
        LunchboxItem foundLunchboxItem = lunchboxItemRepository.findOneByName(item.getName()).orElseThrow(IllegalStateException::new);
        InventoryItem foundItem = foundLunchboxItem.getInventoryItem();
        int oldCount = foundItem.getCount();
        foundItem.setCount(oldCount+count);
        foundLunchboxItem.setInventoryItem(foundItem);
        lunchboxItemRepository.save(foundLunchboxItem);
    }



    public void removeItems(LunchboxItemDto item, int count) throws InventoryException {

        LunchboxItem foundLunchboxItem = lunchboxItemRepository.findOneByName(item.getName()).orElseThrow(IllegalStateException::new);
        InventoryItem foundItem = foundLunchboxItem.getInventoryItem();

        int oldCount = foundItem.getCount();
        if(count > oldCount){
            throw new InventoryException();
        }
        foundItem.setCount(oldCount-count);
        foundLunchboxItem.setInventoryItem(foundItem);
        lunchboxItemRepository.save(foundLunchboxItem);
    }


    public InventoryItemDto createNewInventoryItem(LunchboxItemDto newItem) {
        LunchboxItem newLunchboxItem = new LunchboxItem();
        newLunchboxItem.setItemType(newItem.getItemType());
        newLunchboxItem.setHealthy(newItem.isHealthy());
        newLunchboxItem.setName(newItem.getName());
        InventoryItem inventoryItem = new InventoryItem(1);
        inventoryItem.setItem(newLunchboxItem);
        newLunchboxItem.setInventoryItem(inventoryItem);
        LunchboxItem savedLunchboxItem = lunchboxItemRepository.save(newLunchboxItem);
        InventoryItem savedInventoryItem = savedLunchboxItem.getInventoryItem();

        InventoryItemDto inventoryItemDto = Mapper.map(savedInventoryItem, InventoryItemDto.class);
        return inventoryItemDto;
    }

    public void deleteLunchboxItem(LunchboxItemDto item) {
    Optional<LunchboxItem> itemToDelete = lunchboxItemRepository.findOneByName(item.getName());
    lunchboxItemRepository.delete(itemToDelete.get());
    }

    public void deleteAll() {
        lunchboxItemRepository.deleteAll();
    }

    public InventoryItemDto findOneByItem(LunchboxItem lunchboxItem) {
        InventoryItem foundItem = inventoryItemRepository.findOneByItem(lunchboxItem).orElseThrow(IllegalStateException::new);
        return Mapper.map(foundItem, InventoryItemDto.class);

    }
}
