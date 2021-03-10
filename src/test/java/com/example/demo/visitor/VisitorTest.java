package com.example.demo.visitor;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.fail;

@Import(MyTestConfiguration.class)
@SpringBootTest
public class VisitorTest {

    @Autowired
    VisitorRepository visitorRepository;

    @BeforeEach
    public void purgeDbAddTwoVisitors(){
        Visitor v1 = new Visitor("Moe", 24,"al@gmail.com");
        Visitor v2 = new Visitor("Joe", 42,"li@gmail.com");
        List<Visitor> visitorList = new ArrayList<>();
        visitorList.add(v1);
        visitorList.add(v2);
        visitorRepository.saveAll(visitorList);
    }

    @AfterEach
    public void purgeDb(){
        visitorRepository.deleteAll();
    }



    @Test
    public void testAddVisitor() {
        Visitor testVisitor = new Visitor("John", 55, "john@gmail.ca");
        visitorRepository.save(testVisitor);
        Visitor foundVisitor = visitorRepository.findVisitorByEmail("john@gmail.ca").orElseThrow(IllegalStateException::new);
        Assertions.assertEquals(55, foundVisitor.getAge());
    }

    @Test
    public void testDeleteById(){
        Assertions.assertEquals(2, visitorRepository.findAll().size());
        Optional<Visitor> optionalVisitor = visitorRepository.findVisitorByEmail("al@gmail.com");
        if (!optionalVisitor.isPresent()) {
            fail("not good");
        }
        Visitor visitor = optionalVisitor.get();
        Long id = visitor.getId();
        visitorRepository.deleteById(id);
        Assertions.assertFalse(visitorRepository.existsById(id));
    }

    @Test
    public void testGetByEmail(){
    Visitor testVisitor = new Visitor("Mike", 77, "mike@gmail.ca");
    visitorRepository.save(testVisitor);
    Assertions.assertEquals(testVisitor,visitorRepository.findVisitorByEmail("mike@gmail.ca").get());
    }


}
