package com.iudtu.lunchbox.dto.mapper;

import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.model.Lunchbox;

public class LunchboxMapper {

    public static LunchboxDto toLunchboxDto(Lunchbox lunchbox) {
        LunchboxDto lunchboxDto = new LunchboxDto();
        lunchboxDto.setId(lunchbox.getId());
        lunchboxDto.setOwner(lunchbox.getOwner());
        lunchboxDto.setDescription(lunchbox.getDescription());
        lunchboxDto.setCapacity(lunchbox.getCapacity());
        lunchboxDto.setLunchboxItemsList(lunchbox.getLunchboxItemsList());
        return lunchboxDto;
    }

    public static LunchboxDto findByOwner(String owner) {
        return null;
    }
}
