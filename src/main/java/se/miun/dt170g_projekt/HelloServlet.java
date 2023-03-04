package se.miun.dt170g_projekt;

import java.io.*;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import static java.lang.System.out;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello world!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        response.setContentType("text/html");
//
//
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        int time = Integer.parseInt(request.getParameter("time"));




//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html><head>" +"<title>Form Submitted</title>" + "</head><body>");
//            out.println("<h1>Form Submitted successfully</h1>");
//            out.println("Price: " + price);
//            out.println("Description: " + description);
//            out.println("Time: " + time);
//            out.println("</body></html>");
//        }
    }

}