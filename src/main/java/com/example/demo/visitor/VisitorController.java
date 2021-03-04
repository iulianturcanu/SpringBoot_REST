package com.example.demo.visitor;


import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/authenticated")
    public String checkAuthenticated(Principal user) {
        if(user != null) {
            return "You're authenticated, " + user.getName() + "!";
        } else {
            return "No principal";
        }
    }
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('SCOPE_my-hello-resource/hello.read')")
    public String hello(Principal user) {
        return "Hello " + user.getName();
    }

    @GetMapping("/user-info")
    @PreAuthorize("hasAuthority('SCOPE_my-hello-resource/hello.read')")
    public String userInfo(Principal user) {
        return "Confidential user data";
    }

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
