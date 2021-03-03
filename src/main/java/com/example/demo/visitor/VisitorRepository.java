package com.example.demo.visitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Long> {
//    List<Visitor> findAllByName(String name);
//    List<Visitor> findAllByNameAndEmailOrderById(String name, String email);

    Optional<Visitor> findVisitorByEmail(String email);
}
