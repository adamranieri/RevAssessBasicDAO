package com.revature.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.TestMethodOrder;
import com.revature.assessors.RevAssess;
import com.revature.assessors.RevaTest;
import com.revature.daos.BookDAO;
import com.revature.entities.Book;

@ExtendWith(RevAssess.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookDAOtests {

    private static BookDAO bdao = null; // replace null with your DAO implementation
    private static Book testBook = null;

    @RevaTest(points = 10, tier = 1)
    @Order(1)
    void create_book(){
        Book angelasAshes = new Book(0, "Angelas Ashes", "Frank McCourt",2,true,0);
        bdao.createBook(angelasAshes); // save or persist
        System.out.println(angelasAshes); // the id should NOT be zero
        testBook = angelasAshes;
        Assertions.assertNotEquals(0,angelasAshes.getBookId());
    }

    @RevaTest(points = 5, tier =2)
    @Order(2)
    void get_book_by_id(){
        int id = testBook.getBookId(); 
        Book book = bdao.getBookById(id);
        Assertions.assertEquals(testBook.getTitle(), book.getTitle());
        System.out.println("The book we retrived was " + book);
    }

    @RevaTest(points = 15, tier =2)
    @Order(3)
    void update_book(){
        Book book = bdao.getBookById(testBook.getBookId()); 
        book.setCondition(3); 
        bdao.updateBook(book); 
        Book updatedBook = bdao.getBookById(testBook.getBookId()); 
        Assertions.assertEquals(3,updatedBook.getCondition());

    }

    @RevaTest(points = 15, tier =2)
    @Order(4)
    void get_all_books(){

        Book b1 = new Book(0, "The Outsiders", "S. E. Hinton",1,true,0);
        Book b2 = new Book(0, "One Flew Over The Cuckoo's Nest", "Ken Kesey", 1, true,0);
        Book b3 = new Book(0, "A Christmas Carol", "A Charles Dickens", 3, true,0);

        bdao.createBook(b1);
        bdao.createBook(b2);
        bdao.createBook(b3);

        Set<Book> allBooks = bdao.getAllBooks();
        Assertions.assertTrue(allBooks.size()>2);
    }

    @RevaTest(points = 15, tier =2)
    @Order(5)
    void delete_book_by_id(){
        int id = testBook.getBookId();
        boolean result = bdao.deleteBookById(id); 
        Assertions.assertTrue(result);
    }
}
