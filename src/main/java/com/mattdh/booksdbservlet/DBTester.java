package com.mattdh.booksdbservlet;

import java.sql.SQLException;
import java.util.List;

public class DBTester {

    public static void main(String[] args) {
        System.out.println("Database Tester");

        List<Book> bookList = null;
        try {
            bookList = DBConnection.getAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Book book: bookList) {
            book.printBookInformation(System.out);
        }

//        try {
//            DBConnection.insertBook(new Book("23423452", "Test Insert", 12, "2022"));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }

}