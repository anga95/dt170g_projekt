<%--
  Created by IntelliJ IDEA.
  User: Engma
  Date: 2023-02-03
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%@ include file="head.jsp" %>

<%@ include file="navbar.jsp" %>
<h1 class="display-1 text-center"><%= "A La Carte" %></h1>

<div class ="container-fluid">

    <div class="row d-flex align-items-center justify-content-center">
        <div class="col-3">
            <ul class="list-group">
                <li class="list-group-item border-0" id="forratt">
                    <p class="testing">FÖRRÄTT</p><hr>
                    <p>This is some text under item  da daadsadadaadddada1</p></li>
                <li class="list-group-item border-0" id="huvudratt">
                    HUVUDRÄTT<br><hr>
                    <p>This is some text under item 2</p></li>
                <li class="list-group-item border-0" id="dessert">
                    DESSERT<br><hr>
                    <p>This is some text under item 3</p></li>
            </ul>

        </div>
    </div>

</div>

</body>
</html>
