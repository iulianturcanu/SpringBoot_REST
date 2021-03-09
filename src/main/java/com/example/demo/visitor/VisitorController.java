package com.example.demo.visitor;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;



    @GetMapping
    public List<Visitor> getVisitors(){
        return visitorService.getVisitors();
    }

    @GetMapping(path="{id}")
    public Visitor getById(@PathVariable("id") Long id){
        return visitorService.getVisitorById(id);
    }

    @PostMapping
    public void registerNewVisitor(@RequestBody Visitor visitor){
        visitorService.addNewVisitor(visitor);
    }

    @DeleteMapping(path="{visitorId}")
    public void deleteVisitor(@PathVariable("visitorId") Long id){
        visitorService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllVisitors(){
        visitorService.deleteAll();
    }

    @PutMapping(path="{visitorId}")
    public void updateVisitor(
            @PathVariable("visitorId") Long visitorId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email ){
        visitorService.updateVisitor(visitorId, name, email);
    }




}
