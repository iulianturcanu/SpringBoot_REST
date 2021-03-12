package com.iudtu.lunchbox.services;

import com.iudtu.lunchbox.dto.LunchboxDto;
import com.iudtu.lunchbox.model.Lunchbox;
import com.iudtu.lunchbox.model.LunchboxItem;
import com.iudtu.lunchbox.repository.LunchboxRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class LunchboxServiceTest {

    @Autowired
    LunchboxService lunchboxService;

    @BeforeEach
    public void addTwoLunchboxes(){
        Lunchbox lunchbox1 = new Lunchbox("Bogdan", "blue", 5, new ArrayList<LunchboxItem>(5));
        Lunchbox lunchbox2 = new Lunchbox("Gabriel", "green", 6, new ArrayList<LunchboxItem>(8));
        ArrayList<Lunchbox> saved = new ArrayList<>();
        saved.add(lunchbox1);
        saved.add(lunchbox2);
        lunchboxService.saveAll(saved);
    }

    @AfterEach
    public void deleteAll(){
        lunchboxService.deleteAll();
    }

    @Test
    public void testCreate() {
        LunchboxDto lunchboxDto = lunchboxService.create();
        Assertions.assertNotNull(lunchboxDto);
    }

    @Test
    public void testAddWithOwner(){
        LunchboxDto lunchboxDto = lunchboxService.createWithOwner("Cristian");
        Assertions.assertEquals("Cristian", lunchboxService.findWithDescription(lunchboxDto.getDescription()).getOwner());
    }

    @Test
    public void testFindByDescription(){
        LunchboxDto found = lunchboxService.findWithDescription("green");
        Assertions.assertEquals("Gabriel", found.getOwner());
    }


}
