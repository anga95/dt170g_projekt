<%@ page import="se.miun.dt170g_projekt.entities.MenuItemsEntity" %>
<%@ page import="se.miun.dt170g_projekt.persistanceManager.ServletManager" %>
<%@ page import="java.util.List" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: Engma
  Date: 2023-02-03
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="head.jsp" %>


<%@ include file="navbar.jsp" %>


<div class ="container-fluid">
    <div class="row d-flex align-items-center justify-content-center">
        <img src="css/logga.png" class="img-fluid" style="max-width: 35%" alt="Responsive image">
    </div>

    <div class="row d-flex align-items-center justify-content-center mt-5">
        <div class="col-3">
            <ul class="list-group">
                <li class="list-group-item border-0" id="forratt">
                    <h2><strong>FÖRRÄTTER</strong></h2><hr><%
                    List<MenuItemsEntity> list = ServletManager.getAllMENY();
                    for (MenuItemsEntity obj : list) { %>
                    <h3 class="text-center"><%
                        if (obj.getCategory().equals("Starters")) {
                            out.println(obj.getName() + " " + obj.getPrice() + ":-");
                            out.println("<br>"); %>
                    </h3><p class="text-center"> <%= obj.getDescription() %> </p>
                    <% }
                    }
                    %></li>

                <li class="list-group-item border-0" id="huvudratt">
                    <h2><strong>HUVUDRÄTTER</strong></h2><hr><%
                        for (MenuItemsEntity obj : list) { %>
                    <h3 class="text-center"><%
                            if (obj.getCategory().equals("MainCourse")) {
                                out.println(obj.getName() + " " + obj.getPrice() + ":-");
                                out.println("<br>"); %>
                                </h3><p class="text-center"> <%= obj.getDescription() %> </p>
                                <% }
                        }
                    %></li>
                <li class="list-group-item border-0" id="dessert">
                    <h2><strong>DESSERTER</strong></h2><hr>
                    <%
                        for (MenuItemsEntity obj : list) { %>
                    <h3 class="text-center"><%
                        if (obj.getCategory().equals("Dessert")) {
                        out.println(obj.getName() + " " + obj.getPrice() + ":-");
                        out.println("<br>"); %>
                    </h3><p class="text-center"> <%= obj.getDescription() %> </p>
                    <% }
                        }
                    %></li>
            </ul>

        </div>
    </div>

</div>
<%@include file="footer.jsp"%>
</body>
</html>