package com.example.demo.visitor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Visitor {

    @Id
    @SequenceGenerator(name="visitor_sequence",
                        sequenceName = "visitor_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "visitor_sequence")
    private Long id;
    private String name;
    private Integer age;
    private String email;



    public Visitor(Long id, String name, Integer age, String email) {
        setId(id);
        setName(name);
        setAge(age);
        setEmail(email);
    }

    public Visitor(String name, Integer age, String email) {
        setName(name);
        setAge(age);
        setEmail(email);
    }

    public Visitor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    @Override
    public String toString() {
        return "Visitor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

}
