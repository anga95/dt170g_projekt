<%@ page import="se.miun.dt170g_projekt.entites.MenuItemsEntity" %>
<%@ page import="se.miun.dt170g_projekt.persistanceManager.Manager" %>
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
                    <h2>FÖRRÄTT</h2><hr><p>
                    <%
                        List<MenuItemsEntity> list = Manager.getAllMENY();
                        for (MenuItemsEntity obj : list) {
                            %></p></li>
                    <% } %>
                <li class="list-group-item border-0" id="huvudratt">
                    <h2>HUVUDRÄTT</h2><hr>
                    <p>Pellentesque habitant morbi tristique senectus
                        et netus et malesuada fames ac turpis egestas.
                        Vestibulum tortor quam, feugiat vitae, ultricies
                        eget, tempor sit amet, ante. Donec eu libero sit
                        amet quam egestas semper. Aenean ultricies mi
                        vitae est. Mauris placerat eleifend leo.</p></li>
                <li class="list-group-item border-0" id="dessert">
                    <h2>DESSERT</h2><hr>
                    <p>Pellentesque habitant morbi tristique senectus
                        et netus et malesuada fames ac turpis egestas.
                        Vestibulum tortor quam, feugiat vitae, ultricies
                        eget, tempor sit amet, ante. Donec eu libero sit
                        amet quam egestas semper. Aenean ultricies mi
                        vitae est. Mauris placerat eleifend leo.</p></li>
            </ul>

        </div>
    </div>

</div>
<%@include file="footer.jsp"%>
</body>
</html>