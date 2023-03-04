//package se.miun.dt170g_projekt;
//
//import database.beans.AlaCarteBean;
//import database.old.entities.AlaCarte;
//import jakarta.ejb.EJB;
//import jakarta.ejb.Stateless;
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.inject.Inject;
//import jakarta.inject.Named;
//import jakarta.persistence.PersistenceContext;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//import static java.lang.System.out;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Named(value="Controller servlet")
//@RequestScoped
//@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
//@PersistenceContext(unitName = "default")
//public class ControllerServlet extends HttpServlet {
//
//
////    @EJB(beanName = "database.entities.AlaCarteBean") // det är här som problemet uppstår
////    private AlaCarteBean alcBean;
////    private AlaCarte alc;
//
////    @Inject
////    private AlaCarteBean alcBean;
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
////        List<AlaCarte> entities = alcBean.findAll();
//
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>My Entities</title>");
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>My Entities:</h1>");
////            out.println("<ul>");
////            for (AlaCarte entity : entities) {
////                out.println("<li>" + entity.getPrice() +
////                        " (" + entity.getDescription() +
////                        " (" + entity.getDescription() +
////                        ")</li>");
////            }
////            out.println("</ul>");
////            out.println("</body>");
////            out.println("</html>");
//
//        }
//        PrintWriter out = response.getWriter();
//        out.println("GET HALLP hallå");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//            PrintWriter out = response.getWriter();
//            out.println("POST hallå");
//
//
//    }
//}
