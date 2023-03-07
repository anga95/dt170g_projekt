package se.miun.dt170g_projekt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.miun.dt170g_projekt.persistanceManager.Manager;
import se.miun.dt170g_projekt.entities.BookingEntity;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Enumeration;



@WebServlet(name = "BookingPage", value = "/bookingPage")
public class AddBookingToDataBase extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {

        Enumeration paramNames = request.getParameterNames();
        ArrayList<String> paramValue = new ArrayList<String>();
        String savedValues = "";
        // read all param names and request value for each param
        while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                // Add the param name and value to the savedValues string
                paramValue.add(paramValues[0]);
                savedValues += " " +  paramName + ": " + paramValues[0];
            }
        }

        BookingEntity booking = new BookingEntity();

        booking.setDate(paramValue.get(0));
        booking.setTime(paramValue.get(1));
        booking.setFname(paramValue.get(2));
        booking.setLname(paramValue.get(3));
        booking.setTelnumber(paramValue.get(4));
        booking.setEmail(paramValue.get(5));
        booking.setNumberOfPeople(paramValue.get(6));
        booking.setExtra(paramValue.get(7));

        Manager newBooking = null;

        try {
            newBooking = new Manager();
        } catch (Exception e) {
            e.printStackTrace();
        }

        newBooking.saveData(booking);


        request.setAttribute("savedValues2", savedValues);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/savedValues.jsp");
        dispatcher.forward(request, response);




    }

}
