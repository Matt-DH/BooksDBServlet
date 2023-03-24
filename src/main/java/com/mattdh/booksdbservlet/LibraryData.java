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

        System.out.println("TEST MSG: INSIDE DOGET");

        try {
            Class.forName(DBConfiguration.MARIA_DB_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        response.setContentType("text/html");
        String view = request.getParameter("view");
        Library library = BookDatabaseManager.loadLibrary();

        if (view.equals("book_view")) {
            System.out.println("TEST MSG: INSIDE VIEW EQUALS BOOK");
            List<Book> bookList = library.getBookList();
            RequestDispatcher rd = request.getRequestDispatcher("book_view.jsp");
            request.setAttribute("bookList", bookList);
            rd.forward(request, response);
        }

        if (view.equals("author_view")) {
            System.out.println("TEST MSG: INSIDE VIEW EQUALS AUTHOR");
            List<Author> authorList = library.getAuthorList();
            RequestDispatcher rd = request.getRequestDispatcher("author_view.jsp");
            request.setAttribute("authorList", authorList);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("TEST MSG: POST REQUEST RECEIVED");

        try {
            Class.forName(DBConfiguration.MARIA_DB_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String view = request.getParameter("view");

        if (view.equals("book_add")) {
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

            RequestDispatcher rdBookAdded = request.getRequestDispatcher("book_added.jsp");
            rdBookAdded.forward(request, response);

        }

        if (view.equals("author_add")) {
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

            RequestDispatcher rdAuthorAdded = request.getRequestDispatcher("author_added.jsp");
            rdAuthorAdded.forward(request, response);

        }
    }
}