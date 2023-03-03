package se.miun.dt170g_projekt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.entites.AfterfoodEntity;
import se.miun.dt170g_projekt.entites.DailyLunchEntity;
import se.miun.dt170g_projekt.entites.MainfoodEntity;
import se.miun.dt170g_projekt.entites.PrefoodEntity;
import se.miun.dt170g_projekt.persistanceManager.Manager;
//import se.miun.dt170g_projekt.persistanceManager.dailyLunch;

import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "AdminAddALaCarte", value = "/AdminAddALaCarte")
public class AdminAddALaCarteToDatabase extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String pre = request.getParameter("pre");
        String main = request.getParameter("main");
        String after = request.getParameter("after");

        Manager addALaCarte = null;
        try {
            addALaCarte = new Manager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Forward the request to a JSP page to display the saved values
        if(pre != null){
            PrefoodEntity Pre = new PrefoodEntity();
            Pre.setName(pre);
            addALaCarte.saveData(Pre);
        }
        if(main != null){
            MainfoodEntity Main = new MainfoodEntity();
            Main.setName(main);
            addALaCarte.saveData(Main);
        }
        if(after != null){
            AfterfoodEntity After = new AfterfoodEntity();
            After.setName(after);
            addALaCarte.saveData(After);
        }
        // Redirect to employee list page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPanel.jsp");
        dispatcher.forward(request, response);
    }
}
