package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.ItemType;
import com.iudtu.lunchbox.dto.LunchboxItemDto;
import com.iudtu.lunchbox.dto.mapper.LunchboxItemMapper;
import com.iudtu.lunchbox.model.LunchboxItem;
import com.iudtu.lunchbox.repository.LunchboxItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class LunchboxItemService {
    private final LunchboxItemRepository lunchboxItemRepository;

    @Autowired
    public LunchboxItemService(LunchboxItemRepository lunchboxItemRepository) {
        this.lunchboxItemRepository = lunchboxItemRepository;
    }

    public LunchboxItemDto findByName(String name){
        LunchboxItem found = lunchboxItemRepository.findByName(name).orElseThrow(IllegalStateException::new);
        return LunchboxItemMapper.toLunchboxItemDto(found);
    }

    public ArrayList<LunchboxItemDto> findByItemType(ItemType itemType){
        ArrayList<LunchboxItem> found =(ArrayList<LunchboxItem>)lunchboxItemRepository.findByItemType(itemType);
        if(!found.isEmpty()) {
            ArrayList<LunchboxItemDto> ofType = new ArrayList<>();
            for (LunchboxItem item : found) {
                ofType.add(LunchboxItemMapper.toLunchboxItemDto(item));
            }
            return ofType;
        }return new ArrayList<>();
    }
}
