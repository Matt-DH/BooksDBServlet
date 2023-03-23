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
import java.util.List;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

    private String message;
    public void init() {
        message = "Library Servlet!";
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("TEST MSG: GET REQUEST RECEIVED");
        String view = request.getParameter("view");
        if (view.equals("test_get")) {
            System.out.println("TEST MSG: VIEW EQUALS TEST_GET");
        }

        //TODO Use a variable "view" to determine book or author query

//      List<Book> bookList = null;
//        try {
//            bookList = DBConnection.getAllBooks();
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher(DBConfiguration.WEBAPP_PAGES_DIR + "viewallbooks.jsp");
//            request.setAttribute("booklist", bookList);
//            String view = request.getParameter("view");
//
//            //TODO add the list to the request
//            requestDispatcher.forward(request, response);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            //TODO Navigate to some error page
//            //Navigate to 404.jsp
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher(DBConfiguration.WEBAPP_PAGES_DIR + "404.jsp");
//            requestDispatcher.forward(request, response);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TEST MSG: POST REQUEST RECEIVED");
        String view = request.getParameter("view");
        if (view.equals("test_post")) {
            System.out.println("TEST MSG: VIEW EQUALS TEST_POST");
        }

//        if(view.equals("add_book")){
//            String isbn = request.getParameter("isbn");
//            String title = request.getParameter("title");
//            int editionNumber = Integer.valueOf(request.getParameter("edition_number"));
//            String copyright = request.getParameter("copyright");
//
//            try {
//                DBConnection.insertBook(
//                        new Book(
//                                request.getParameter("isbn"),
//                                request.getParameter("title"),
//                                Integer.valueOf(request.getParameter("edition_number")),
//                                request.getParameter("copyright")
//                        ));
//            } catch (SQLException e) {
//                e.printStackTrace();
//                //Navigate somewhere?
//            }
//
//        } else if(view.equals("add_author")){
//
//            //TODO insert Author
//        } else {
//
//            //Something went wrong? Do nothing?
//        }

    }
}