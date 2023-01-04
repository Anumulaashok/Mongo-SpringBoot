package com.mongoDemo.demo.Controller;

import com.mongoDemo.demo.ExceptionHandler.BookException;
import com.mongoDemo.demo.Model.Book;
import com.mongoDemo.demo.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/add")
    public Book addBook(@Valid @RequestBody Book book) throws BookException {

        Book book1= bookService.addBook(book);
      return book1;
    }
    @GetMapping("/get/{id}")
    public Book getById(@PathVariable("id") String id) throws BookException{
        return bookService.getBookById(id);
    }
    @GetMapping("/getbook")
    public Book getByName(@RequestParam("name") String name) throws BookException{
        return bookService.getBookByName(name);
    }
    @PutMapping("/update/{id}")
    public Book updateTeacherById(@PathVariable("id")String id ,@RequestParam("teacher")String teacher)throws BookException{
        return bookService.updateTeacher(id, teacher);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteBookById(@PathVariable("id") String id)throws BookException{
        return bookService.deleteBook(id);
    }
}
