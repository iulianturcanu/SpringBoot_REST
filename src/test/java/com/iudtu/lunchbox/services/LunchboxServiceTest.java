package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.model.Lunchbox;
import com.iudtu.lunchbox.model.LunchboxItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class LunchboxServiceTest {

    @Autowired
    LunchboxService lunchboxService;

    @Test
    public void testCreate() {
        LunchboxDto lunchboxDto = lunchboxService.create(new Lunchbox());
        Assertions.assertNotNull(lunchboxDto);
    }
}
