package se.miun.dt170g_projekt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.entites.*;
import se.miun.dt170g_projekt.persistanceManager.Manager;
//import se.miun.dt170g_projekt.persistanceManager.dailyLunch;

import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "AdminAddALaCarte", value = "/AdminAddALaCarte")
public class AdminAddALaCarteToDatabase extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String kategori = request.getParameter("Kategori");
        String price = request.getParameter("price");
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");

        System.out.println(kategori);
        System.out.println(price);
        System.out.println(name);
        System.out.println(desc);

        Manager addALaCarte = null;

        try {
            addALaCarte = new Manager();
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
