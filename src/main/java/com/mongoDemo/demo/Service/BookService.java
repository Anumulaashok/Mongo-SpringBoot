package com.mongoDemo.demo.Service;

import com.mongoDemo.demo.ExceptionHandler.BookException;
import com.mongoDemo.demo.Model.Book;

public interface BookService {
    public Book addBook(Book book) throws BookException;
    public Book getBookById(String id) throws BookException;
    public Book getBookByName(String name) throws BookException;
    public Book updateTeacher(String id ,String teacher)throws BookException;
    public boolean deleteBook(String id)throws BookException;
}
