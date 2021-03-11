package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.model.Lunchbox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LunchboxServiceTest {

    @Autowired
    LunchboxService lunchboxService;

    @Test
    public void testCreateLunchboxDto() {
        LunchboxDto lunchboxDto = lunchboxService.createLunchboxDto(new Lunchbox());
        Assertions.assertNotNull(lunchboxDto);
    }
}
