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

        String view = request.getParameter("view");

        switch (view) {

            case "authorView":


                break;

            case "bookView":
                List<Book> bookList = null;
                try {
                    Library library = new Library();
                    bookList = library.getBookList();
                    RequestDispatcher rd = request.getRequestDispatcher("booksdbservlet/book_view.jsp");
                    request.setAttribute("bookList", bookList);
                    rd.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }

//
//

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (firstName == null || lastName == null || firstName.isEmpty() || lastName.isEmpty()) {
            System.out.println("Something is wrong");
        } else {
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("TEST MSG: POST REQUEST RECEIVED");

        String view = request.getParameter("view");

        switch(view) {
            case "bookAdd":
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

            case "authorAdd":
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