package com.mongoDemo.demo.Service;

import com.mongoDemo.demo.ExceptionHandler.BookException;
import com.mongoDemo.demo.ExceptionHandler.StudentException;
import com.mongoDemo.demo.Model.Book;
import com.mongoDemo.demo.Model.Student;
import com.mongoDemo.demo.Repository.BookRepo;
import com.mongoDemo.demo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpliment implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BookRepo bookRepo;
    @Override
    public Student saveStudent(Student student) throws StudentException {

        Student student1= studentRepo.findByName(student.getName());

         if(student1!=null){
                throw new StudentException("student already there with the name");
            }
        return studentRepo.save(student);

    }

    @Override
    public Student updateStudentemail(String id, String email) throws StudentException {

       Student student1 = studentRepo.findById(id).orElseThrow(()-> new StudentException("student not found"));

       student1.setEmail(email);

       return studentRepo.save(student1);
    }

    @Override
    public List<Student> getAllStudents() throws  StudentException{

       return  studentRepo.findAll();

    }
    @Override
    public List<Student> getAllStudentsBySort(String sorted) throws  StudentException{
        sorted=sorted.toUpperCase();
    switch (sorted){
        case "ASC":return  studentRepo.sortByRollASC();

        case "DESC":return  studentRepo.sortByRollDESC();

        default: throw new StudentException(" please Enter 1 for asc -1 for desc");

    }


    }

    @Override
    public Student findStudentById(String id)throws  StudentException {

        return studentRepo.findById(id).orElseThrow(()-> new StudentException("student not found"));

    }

    @Override
    public Boolean addBook(String id, String bookId) throws StudentException, BookException {
        Student s1=  studentRepo.findById(id).orElseThrow(()-> new StudentException("student not found"));
        Book b1=  bookRepo.findById(bookId).orElseThrow(()-> new StudentException("book not found"));
        s1.getBooks().add(b1.getBookId());
        studentRepo.save(s1);
        return true;
    }

    @Override
    public Boolean deleteStudent(String id)throws  StudentException {

      Student s1=  studentRepo.findById(id).orElseThrow(()-> new StudentException("student not found"));

      studentRepo.delete(s1);

      return true;
    }
}
