<%--
  Created by IntelliJ IDEA.
  User: Engma
  Date: 2023-02-20
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<%@ include file="navbar.jsp" %>
<div class="container mt-5">
  <p><%= request.getAttribute("savedValues") %></p>
</div>
<div class="container mt-5">
  <p><%= request.getAttribute("savedValues2") %></p>
</div>
<%@ include file="footer.jsp" %>