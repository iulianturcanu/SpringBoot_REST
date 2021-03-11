package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.LunchboxDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LunchboxServiceTest {

    @Autowired
    LunchboxService lunchboxService;

    @Test
    public void testCreate() {
        LunchboxDto lunchboxDto = lunchboxService.create();
        Assertions.assertNotNull(lunchboxDto);
    }
}
