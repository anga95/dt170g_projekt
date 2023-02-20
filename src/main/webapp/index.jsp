<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="head.jsp" %>


 <%@ include file="navbar.jsp" %>

<h1 class="display-1 text-center mt-3"><%= "Dagens lunch" %></h1>
<br/>
<div class="container-fluid d-flex justify-content-center mt-3 mb-5">
    <div class="row">
        <div class="col-6 d-flex align-items-center">
            <ul>
                <li class="list-group-item border-0 mb-2" id="måndag">Måndag</li>
                <li class="list-group-item border-0 mb-2" id="tisdag">Tisdag</li>
                <li class="list-group-item border-0 mb-2" id="onsdag">Onsdag</li>
                <li class="list-group-item border-0 mb-2" id="torsdag">Torsdag</li>
                <li class="list-group-item border-0" id="fredag">Fredag</li>
            </ul>
        </div>
        <div class="col-6">
            <div class="card mt-3 pb-5" style="width: 20rem;" id="day-info">
                <!-- Add information about the selected day here -->
            </div>
        </div>
    </div>
</div>
<br/>
<script src="js/dagensLunch.js"></script>
<%@ include file="footer.jsp" %>
</body>
</html>