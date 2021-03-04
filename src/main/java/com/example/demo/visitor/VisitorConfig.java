package com.example.demo.visitor;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VisitorConfig {
    @Bean
    CommandLineRunner commandLineRunner(VisitorRepository visitorRepository){
        return args -> {
            Visitor v1 = new Visitor("Moe", 24,"al@gmail.com");
            Visitor v2 = new Visitor("Joe", 42,"li@gmail.com");
            List<Visitor> visitorList = new ArrayList<>();
            visitorList.add(v1);
            visitorList.add(v2);
            visitorRepository.saveAll(visitorList);

        };
    }
}
