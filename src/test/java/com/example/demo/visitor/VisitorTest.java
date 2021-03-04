package com.example.demo.visitor;

import com.example.demo.VisitorJpaConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootTest
@ContextConfiguration(
        classes = {VisitorJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class VisitorTest {

    @Resource
    VisitorRepository visitorRepository;

    @Test
    public void testOne() {
        Visitor v = new Visitor();
        visitorRepository.save(v);
        Assertions.assertEquals(3, v.getId());
    }
}
