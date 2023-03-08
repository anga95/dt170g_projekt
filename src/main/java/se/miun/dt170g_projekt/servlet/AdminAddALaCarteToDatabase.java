package se.miun.dt170g_projekt.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.entities.*;
import se.miun.dt170g_projekt.persistanceManager.ServletManager;
//import se.miun.dt170g_projekt.persistanceManager.dailyLunch;

import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "AdminAddALaCarte", value = "/AdminAddALaCarte")
public class AdminAddALaCarteToDatabase extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String kategori = request.getParameter("kategori");
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String price = request.getParameter("price");

        System.out.println(kategori);
        System.out.println(price);
        System.out.println(name);
        System.out.println(desc);

        ServletManager addALaCarte = null;

        try {
            addALaCarte = new ServletManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Forward the request to a JSP page to display the saved values
        MenuItemsEntity newFood = new MenuItemsEntity();
        if(kategori.equals("Starters")){
            newFood.setName(name);
            newFood.setPrice(Integer.parseInt(price));
            newFood.setDescription(desc);
            newFood.setCategory(kategori);
        }
        else if(kategori.equals("MainCourse")){
            newFood.setName(name);
            newFood.setPrice(Integer.parseInt(price));
            newFood.setDescription(desc);
            newFood.setCategory(kategori);
        }
        else if(kategori.equals("Dessert")){
            newFood.setName(name);
            newFood.setPrice(Integer.parseInt(price));
            newFood.setDescription(desc);
            newFood.setCategory(kategori);
        }

        addALaCarte.saveData(newFood);

        // Redirect to employee list page
        String redirectUrl = "/AdminPanel.jsp?functionCarte=showCarte";
        RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
        dispatcher.forward(request, response);
    }
}
