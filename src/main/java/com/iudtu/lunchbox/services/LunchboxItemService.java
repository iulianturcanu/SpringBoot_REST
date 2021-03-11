package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.model.LunchboxItem;
import org.springframework.beans.factory.annotation.Autowired;

public class LunchboxItemService {
    private final LunchboxItem lunchboxItem;

    @Autowired
    public LunchboxItemService(LunchboxItem lunchboxItem) {
        this.lunchboxItem = lunchboxItem;
    }
}
