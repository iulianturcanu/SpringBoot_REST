package com.example.demo.visitor;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Import(MyTestConfiguration.class)
@SpringBootTest
public class VisitorTest {

    @Autowired
    VisitorRepository visitorRepository;

    @BeforeTestClass
    public void purgeDbAddTwoVisitors(){
        visitorRepository.deleteAll();
        Visitor v1 = new Visitor("Moe", 24,"al@gmail.com");
        Visitor v2 = new Visitor("Joe", 42,"li@gmail.com");
        List<Visitor> visitorList = new ArrayList<>();
        visitorList.add(v1);
        visitorList.add(v2);
        visitorRepository.saveAll(visitorList);
    }

    @AfterTestClass
    public void purgeDb(){
        visitorRepository.deleteAll();
    }


    @Test
    @Order(1)
    public void testAddVisitor() {
        Visitor testVisitor = new Visitor("John", 55, "john@gmail.ca");
        visitorRepository.save(testVisitor);
        Assertions.assertEquals(3, testVisitor.getId());
    }

    @Order(2)
    @Test
    public void testDeleteById(){
        visitorRepository.deleteById(2L);
        Assertions.assertEquals(2, visitorRepository.findAll().size());
        Assertions.assertTrue(!(visitorRepository.existsById(2L)));
    }

    @Order(3)
    @Test
    public void testGetByEmail(){
    Visitor testVisitor = new Visitor("Mike", 77, "mike@gmail.ca");
    visitorRepository.save(testVisitor);
    Assertions.assertEquals(testVisitor,visitorRepository.findVisitorByEmail("mike@gmail.ca").get());
    }


}
