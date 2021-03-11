package com.iudtu.lunchbox.dto.mapper;

import com.iudtu.lunchbox.dto.LunchboxItemDto;
import com.iudtu.lunchbox.model.LunchboxItem;

public class LunchboxItemMapper {

    public static LunchboxItemDto toLunchboxItemDto (LunchboxItem lunchboxItem){
        LunchboxItemDto lunchboxItemDto = new LunchboxItemDto();
        lunchboxItemDto.setId(lunchboxItem.getId());
        lunchboxItemDto.setItemType(lunchboxItem.getItemType());
        lunchboxItemDto.setName(lunchboxItem.getName());
        lunchboxItemDto.setHealthy(lunchboxItem.isHealthy());
        return lunchboxItemDto;
    }
}
