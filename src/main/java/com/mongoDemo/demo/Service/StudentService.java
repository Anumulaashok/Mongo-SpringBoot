package com.mongoDemo.demo.Service;

import com.mongoDemo.demo.ExceptionHandler.BookException;
import com.mongoDemo.demo.ExceptionHandler.StudentException;
import com.mongoDemo.demo.Model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student) throws StudentException;

    public Student updateStudentemail(String id, String email) throws StudentException;

    public List<Student> getAllStudents()throws  StudentException;

    public List<Student> getAllStudentsBySort(String sorted)throws  StudentException;
    public Student findStudentById(String id)throws  StudentException;
    public Boolean addBook(String id, String bookId)throws StudentException, BookException;

    public Boolean deleteStudent(String id)throws  StudentException;
}
