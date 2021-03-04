package com.example.demo.visitor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VisitorTest {

    @Autowired
    VisitorRepository visitorRepository;

    @Test
    public void testOne() {
        Visitor v = new Visitor();
        visitorRepository.save(v);
        Assertions.assertEquals(3, v.getId());
    }
}
