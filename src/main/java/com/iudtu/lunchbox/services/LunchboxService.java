package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.model.Lunchbox;
import com.iudtu.lunchbox.repository.LunchboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LunchboxService {

    private final LunchboxRepository lunchboxRepository;

    @Autowired
    public LunchboxService(LunchboxRepository lunchboxRepository){
        this.lunchboxRepository = lunchboxRepository;
    }

    public LunchboxDto createLunchboxDto(Lunchbox lunchbox) {
        LunchboxDto lunchboxDto = new LunchboxDto();
        lunchboxDto.setId(lunchbox.getId());
        lunchboxDto.setOwner(lunchbox.getOwner());
        lunchboxDto.setDescription(lunchbox.getDescription());
        lunchboxDto.setCapacity(lunchbox.getCapacity());
        lunchboxDto.setLunchboxItemsList(lunchbox.getLunchboxItemsList());
        return lunchboxDto;
    }
}
