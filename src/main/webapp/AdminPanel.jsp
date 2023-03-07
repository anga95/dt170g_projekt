<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="se.miun.dt170g_projekt.entites.EmployeeEntity" %>
<%@ page import="se.miun.dt170g_projekt.AdminGetEmployeeFromDatabase" %>
<%@ page import="se.miun.dt170g_projekt.persistanceManager.Manager" %>
<%@ page import="se.miun.dt170g_projekt.entites.MenuItemsEntity" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="head.jsp" %>


 <div class="container-fluid">
    <h1 class="display-1 mt-3 text-center"><%= "ADMIN PANEL" %></h1>
  <div class="row">
        <nav class="col-sm-2 navbar navbar-dark position-fixed ms-5">
            <div class="container-fluid">
                <div class="sidebar">
                    <ul class="list-group">
                        <li class="lista list-group-item border-0 mb-2" id="veckomeny" onclick="showChoiceInfo('veckomeny'); hideSecondCard(); hideAddCarteCard()">Veckomeny</li>
                        <li class="lista list-group-item border-0 mb-2" id="carte" onclick="showChoiceInfo('carte'); hideSecondCard(); displayAddCarteCard()">A la carte</li>
                        <li class="lista list-group-item border-0 mb-2" id="anställda" onclick="showChoiceInfo('anställda'); displaySecondCard(); hideAddCarteCard()">Anställda</li>
                        <li class="lista list-group-item border-0 mb-2" id="schema" onclick="showChoiceInfo('schema'); hideSecondCard(); hideAddCarteCard()">Schema</li>
                    </ul>
                </div>
            </div>
        </nav>
    <div class="col-5 container-fluid d-flex justify-content-center">


        <div class="row">
            <div class="col">
                <div class="card mt-3 pb-5 bg-gradient d-flex align-items-center" style="width: 20rem;">

                    <div class="choice-info" id="veckomeny-info">
                        <div class="card-body">
                            <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/AdminPage" method="post">
                                <input type="hidden" id="selectedDay" name="selectedDay" value="Måndag">
                                <div class="form-group">
                                    <h3 class="text-center mb-4" id="day">Måndag</h3>
                                    <textarea type="text" class="form-control" id="exampleFormControlInput1" name="dish1" placeholder="Maträtt 1"></textarea>
                                    <textarea type="text" class="form-control mt-3 " id="exampleFormControlInput2" name="dish2" placeholder="Maträtt 2"></textarea>
                                    <textarea type="text" class="form-control mt-3" id="exampleFormControlInput3" name="dish3" placeholder="Maträtt 3"></textarea>
                                </div>
                                <div class="mt-5 d-flex justify-content-between">
                                    <button type="button" class="btn btn-secondary me-2" onclick="previousDay()"><-Föregående dag</button>
                                    <button type="button" class="btn btn-secondary" onclick="nextDay()">Nästa dag-></button>
                                </div>
                                <div class="mt-5 d-flex justify-content-center">
                                    <button type="submit" class="btn btn-success">Spara</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="choice-info" id="anställda-info">
                            <div class="card-body">
                                <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/AddEmp" method="post">
                                    <div class="form-group">
                                        <h3 class="text-center mb-4">Lägg till Anställd</h3>
                                        <label class="form-label" for="fname">Förnamn</label>
                                        <input class="form-control mb-2" name="fname" type="text" id="fname">

                                        <label class="form-label" for="ename">Efternamn</label>
                                        <input class="form-control mb-2" name="ename" type="text" id="ename">

                                        <label class="form-label" for="email">E-post</label>
                                        <input class="form-control mb-2" name="email" type="text" id="email">

                                        <label class="form-label" for="telnr">Telefonnummer</label>
                                        <input class="form-control mb-5" name="telnr" type="text" id="telnr">
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success justify-content-center">Lägg till</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                    </div>
                    <div class="choice-info" id="schema-info">
                        <div class="card-body">
                            <form accept-charset="UTF-8" action="#" method="post">
                                <div class="form-group">

                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="choice-info" id="carte-info">
                        <div class="card-body">
                            <form accept-charset="UTF-8" action=""  method="post" id="carteForm">
                                <div class="form-group">
                                    <h3 class="text-center mb-4">Måltider</h3>
                                    <label for="category">Kategori</label>
                                    <select name="Kategori" id="category" class="form-control">
                                        <option selected>Välj...</option>
                                        <option value="Starters">Förrätt</option>
                                        <option value="MainCourse">Huvudrätt</option>
                                        <option value="Dessert">Efterrätt</option>
                                    </select>
                                    <label for="namn">Namn</label>
                                    <input class="form-control" name="name" type="text" id="namn">
                                    <label for="description">Beskrivning</label>
                                    <textarea class="form-control" name="desc" type="text" id="description"></textarea>
                                    <label for="price">Pris</label>
                                    <input class="form-control" name="price" type="number" id="price">
                                    <div class="mt-5 d-flex justify-content-center">
                                        <button type="submit" class="btn btn-success">Lägg till</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col card mt-3 bg-gradient d-flex align-items-center ms-3" style="width:  5rem;" id="listaEMP">
            <div class="card-body">
                <h3 class="text-center mb-4">Lista över anställda</h3>
                <ul class="list-group">

                        <%
                            List<EmployeeEntity> list = Manager.getAllEmployee();
                            for (EmployeeEntity obj : list) {
                        %>

                    <li class="list-group-item d-flex justify-content-between"><%= obj.getFirstName() + " " + obj.getLastName() %>
                        <div>
                            <buttton type="button" class="btn btn-sm btn-danger" onclick="deleteEmployee(<%=obj.getId()%>)">Ta bort</buttton>
                        </div>
                    </li>
                        <% } %>

                </ul>
            </div>
        </div>
        <div class="col card mt-3 bg-gradient d-flex align-items-center ms-3" style="width:  5rem;" id="addCarte">
            <div class="card-body">
                <h3 class="mb-4">Måltider på sidan nu</h3>
                <h5 class="mb-2">Förrätter</h5>
                <ul class="list-group mb-2">
                    <%
                        List<MenuItemsEntity> list2 = Manager.getAllMENY();
                        for (MenuItemsEntity obj2 : list2) {
                            if (obj2.getCategory().equals("Starters")) {
                    %>
                    <li class="list-group-item d-flex justify-content-between">
                        <%= obj2.getName() %>
                        <div>
                            <button type="button" class="btn btn-sm btn-danger" onclick="deleteMenuItem(<%=obj2.getId()%>);">Delete</button>
                        </div>
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>

                <h5 class="mb-2">Huvudrätter</h5>
                <ul class="list-group mb-2">
                    <%
                        for (MenuItemsEntity obj2 : list2) { %>
                    <%
                        if (obj2.getCategory().equals("MainCourse")) {%>
                    <li class="list-group-item d-flex justify-content-between">
                        <%= obj2.getName() %>
                        <div>
                            <button type="button" class="btn btn-sm btn-danger" onclick="">Delete</button>
                        </div>
                    </li>
                    <% }
                    }
                    %>
                </ul>
                <h5 class="mb-2">Efterrätter</h5>
                <ul class="list-group mb-2">
                    <%
                        for (MenuItemsEntity obj2 : list2) { %>
                    <%
                        if (obj2.getCategory().equals("Dessert")) {%>
                    <li class="list-group-item d-flex justify-content-between">
                        <%= obj2.getName() %>
                        <div>
                            <button type="button" class="btn btn-sm btn-danger" onclick="">Delete</button>
                        </div>
                    </li>
                    <% }
                    }
                    %>
                </ul>
            </div>

        </div>
    </div>
   </div>
 </div>

    <script src="js/adminPageJS.js"></script>
<script>

    var functionName = '<%= request.getParameter("functionName") %>';
    if (functionName === 'myFunction') {
        showEmp();
    }
    var functionCarte = '<%= request.getParameter("functionCarte") %>';
    if(functionCarte === 'showCarte'){
        showCarte();
    }
    function showEmp() {
        const emp = document.getElementById("anställda");
        emp.click();
    }
    function showCarte() {
        const carte = document.getElementById("carte");
        carte.click();
    }

</script>



</body>
</html>
