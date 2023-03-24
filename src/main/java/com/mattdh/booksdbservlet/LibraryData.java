package com.mattdh.booksdbservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

    private String message;
    public void init() {
        message = "Library Servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String view = request.getParameter("view");

        Library library = BookDatabaseManager.loadLibrary();

        request.setAttribute("bookList", library.getBookList());
        request.setAttribute("authorList", library.getAuthorList());

//        if (view.equals("author_view")) {
//
//            System.out.println("CASE: AUTHOR VIEW");
//
//            try {
//                List<Author> authorList = library.getAuthorList();
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher("a2/viewallbooks.jsp");
//                request.setAttribute("authorlist", authorList);
//                requestDispatcher.forward(request, response);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        if (view.equals("book_view")) {
//
//            System.out.println("CASE: BOOK VIEW");
//
////                List<Book> bookList = null;
////                try {
////                    Library library = new Library();
////                    bookList = library.getBookList();
////                    RequestDispatcher rd = request.getRequestDispatcher("booksdbservlet/book_view.jsp");
////                    request.setAttribute("bookList", bookList);
////                    rd.forward(request, response);
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//
//        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("TEST MSG: POST REQUEST RECEIVED");

        String view = request.getParameter("view");

        switch(view) {
            case "book_add":
                System.out.println("TEST MSG: VIEW = BOOK ADD");

                int titlesAuthorID = Integer.valueOf(request.getParameter("titlesAuthorID"));
                String titlesIsbn = request.getParameter("titlesIsbn");
                String titlesTitle = request.getParameter("titlesTitle");
                int titlesEditionNumber = Integer.valueOf(request.getParameter("titlesEditionNum"));
                String titlesCopyright = request.getParameter("titlesCopyright");

                try {
                    BookDatabaseManager.addBook(
                            DBConfiguration.getBookDBConnection(),
                            titlesAuthorID,
                            titlesIsbn,
                            titlesTitle,
                            titlesEditionNumber,
                            titlesCopyright
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                    //Navigate somewhere?
                }
                break;

            case "author_add":
                System.out.println("TEST MSG: VIEW = AUTHOR ADD");

                int authorsAuthorID = Integer.valueOf(request.getParameter("authorsAuthorID"));
                String authorsFirstName = request.getParameter("authorsFirstName");
                String authorsLastName = request.getParameter("authorsLastName");

                try {
                    BookDatabaseManager.addAuthor(
                            DBConfiguration.getBookDBConnection(),
                            authorsAuthorID,
                            authorsFirstName,
                            authorsLastName
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                    //Navigate somewhere
                }
        }
    }
}