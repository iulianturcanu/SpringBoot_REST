package com.example.demo.visitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDTO {
    private String name;
    private String email;
    private Integer age;
}
