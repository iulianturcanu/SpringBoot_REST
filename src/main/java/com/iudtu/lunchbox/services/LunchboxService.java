package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.LunchboxDto;
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

    public LunchboxDto create() {
        return null;
    }
}
