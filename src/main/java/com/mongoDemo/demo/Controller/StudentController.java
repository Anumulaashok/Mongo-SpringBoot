package com.mongoDemo.demo.Controller;

import com.mongoDemo.demo.Config.config;
import com.mongoDemo.demo.ExceptionHandler.BookException;
import com.mongoDemo.demo.ExceptionHandler.StudentException;
import com.mongoDemo.demo.Model.Student;
import com.mongoDemo.demo.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private RabbitTemplate template;
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student) throws StudentException {
        Student s1 = studentService.saveStudent(student);
        template.convertAndSend(config.MYEXCHANGE, config.ROUTING_KEY, s1);
        return s1;
    }

    @PutMapping("/update/email/{id}")
    public Student updateEmail(@PathVariable("id") String id, @RequestParam("email") String email) throws StudentException {
        return studentService.updateStudentemail(id, email);

    }

    @GetMapping("/get/{id}")
    public Student findById(@PathVariable String id) throws StudentException {
        return studentService.findStudentById(id);
    }
    @GetMapping("/getbysorting")
    public List<Student> getBySortingonRollNumber(@RequestParam("sort") String sort) throws StudentException {
        return studentService.getAllStudentsBySort(sort);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteStudentById(@PathVariable String id) throws StudentException {

        return studentService.deleteStudent(id);
    }


    @GetMapping("/getall")
    public List<Student> getAllStudent() throws StudentException {

        return studentService.getAllStudents();
    }

    @PutMapping("/add-book/{id}")
    public boolean addBookInStudent(@PathVariable String id, @RequestParam("bookid") String bookId) throws StudentException, BookException {
        System.out.println(bookId);
        return studentService.addBook(id, bookId);

    }
}
