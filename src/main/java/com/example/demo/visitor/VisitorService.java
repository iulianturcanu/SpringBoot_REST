package com.example.demo.visitor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    @Autowired
    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public List<Visitor> getVisitors() {
        return visitorRepository.findAll();
    }

    public void saveVisitor(Visitor v){
        visitorRepository.save(v);
    }

    public void addNewVisitor(Visitor visitor) {
        Optional<Visitor> visitorByEmail = visitorRepository.findVisitorByEmail(visitor.getEmail());
    if(visitorByEmail.isPresent()){
        throw new IllegalStateException("email already exists");
        }
        visitorRepository.save(visitor);
    }

    public void deleteById(Long id) {
        if(!(visitorRepository.existsById(id))){
            throw new IllegalStateException("visitor with id " + id + " does not exist");
        }
        visitorRepository.deleteById(id);

    }

    public void deleteAll(){
        visitorRepository.deleteAll();
    }
}
