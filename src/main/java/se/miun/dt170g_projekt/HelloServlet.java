package se.miun.dt170g_projekt;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message, message2;

    public void init() {
        message = "Hello World!";
        message2 = "Helloooo ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<p>"  + message2 + "</p>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}