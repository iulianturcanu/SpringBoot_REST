package com.example.demo.visitor;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
@RequestMapping(path = "api/v1/visitor")
public class VisitorController {
    private final VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public List<Visitor> getVisitors(){
        return visitorService.getVisitors();
    }

    @PostMapping
    public void registerNewVisitor(@RequestBody Visitor visitor){
        visitorService.addNewVisitor(visitor);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteVisitor(@PathVariable("studentId") Long id){
        visitorService.deleteById(id);
    }

//    @PostMapping
//    public ResponseEntity<?> addVisitor(@RequestBody VisitorDTO visitorDTO){
//        return ResponseEntity.accepted().build();
//    }

}
