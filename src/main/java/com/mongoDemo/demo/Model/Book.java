package com.mongoDemo.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection = "book")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    private String bookId;
    private String name;
    private String teacher;

}
