package com.mongoDemo.demo.Service;

import com.mongoDemo.demo.ExceptionHandler.BookException;
import com.mongoDemo.demo.Model.Book;
import com.mongoDemo.demo.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpliment implements BookService{
    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book addBook(Book book) throws BookException{
        Optional<Book> book1= bookRepo.findByName(book.getName());
        if(book1.get()!=null){
            throw  new BookException("Book Alredy present");
        }
        return bookRepo.save(book);

    }

    @Override
    public Book getBookById(String id) throws BookException {
       Book book1= bookRepo.findById(id).orElseThrow(()->new BookException("book not found"));
        return book1;
    }

    @Override
    public Book getBookByName(String name) throws BookException {

        Book book1= bookRepo.findByName(name).orElseThrow(()->new BookException("book not found"));
        return book1;
    }

    @Override
    public Book updateTeacher(String id, String tecaher)throws BookException {

        Book book1= bookRepo.findById(id).orElseThrow(()->new BookException("book not found"));

        book1.setTeacher(tecaher);

        return  bookRepo.save(book1);

    }

    @Override
    public boolean deleteBook(String id) throws BookException{

        Book book1= bookRepo.findById(id).orElseThrow(()->new BookException("book not found"));

        bookRepo.delete(book1);

        return true;
    }
}
