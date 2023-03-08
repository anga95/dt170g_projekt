package martin_test.deeper.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.Path;

import java.io.IOException;

@WebServlet(name = "addMenuItem", value = "/addMenuItem")
public class addMenuItem extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello");
    }
}
