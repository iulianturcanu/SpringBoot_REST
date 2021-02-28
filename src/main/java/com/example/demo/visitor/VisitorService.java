package com.example.demo.visitor;

import com.sun.tools.javac.util.List;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    public List<Visitor> getVisitors(){
        return List.of(new Visitor(1L,"Al", 24,"al@gmail.com"));
    }
}
