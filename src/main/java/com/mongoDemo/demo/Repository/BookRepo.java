package com.mongoDemo.demo.Repository;

import com.mongoDemo.demo.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends MongoRepository<Book,String> {


   public Optional<Book> findByName(String s);

}
