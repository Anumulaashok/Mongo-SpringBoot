package com.mongoDemo.demo.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    private String studentId;
    private String name;

    private String email;

    @NotNull(message = "Roll no is Compulsory")

    private String rollNo;

    private Set<String> books = new HashSet<>();

}
