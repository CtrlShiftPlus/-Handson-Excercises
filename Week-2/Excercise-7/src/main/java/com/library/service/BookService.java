package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String libraryName;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void displayBook() {
        System.out.println("Library Name: " + libraryName);
        System.out.println("BookService is working");
        bookRepository.getBook();
    }

}