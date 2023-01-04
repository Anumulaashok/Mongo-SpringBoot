package com.mongoDemo.demo.Repository;

import com.mongoDemo.demo.Model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.Optional;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {



    public Student findByName(String s);

    @Query(value="{}",sort = "{'rollNo':1}")
    public List<Student> sortByRollASC();
    @Query(value="{}",sort = "{'rollNo':-1}")
    public List<Student> sortByRollDESC();
}
