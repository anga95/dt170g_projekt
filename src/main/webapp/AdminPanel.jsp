<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="se.miun.dt170g_projekt.entites.EmployeeEntity" %>
<%@ page import="se.miun.dt170g_projekt.AdminGetEmployeeFromDatabase" %>
<%@ page import="se.miun.dt170g_projekt.persistanceManager.Manager" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="head.jsp" %>


 <div class="container-fluid">
    <h1 class="display-1 mt-3 text-center"><%= "ADMIN PANEL" %></h1>
  <div class="row">
        <nav class="col-sm-2 navbar navbar-dark position-fixed ms-5">
            <div class="container-fluid">
                <div class="sidebar">
                    <ul class="list-group">
                        <li class="list-group-item border-0 mb-2" id="veckomeny" onclick="showChoiceInfo('veckomeny'); showSecondCard()">Veckomeny</li>
                        <li class="list-group-item border-0 mb-2" id="carte" onclick="showChoiceInfo('carte'); showSecondCard()">A la carte</li>
                        <li class="list-group-item border-0 mb-2" id="anställda" onclick="showChoiceInfo('anställda'); displaySecondCard()">Anställda</li>
                        <li class="list-group-item border-0 mb-2" id="schema" onclick="showChoiceInfo('schema'); showSecondCard()">Schema</li>
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
                                    <button type="button" class="btn btn-secondary me-2" onclick="previousDay()">Föregående dag</button>
                                    <button type="button" class="btn btn-secondary" onclick="nextDay()">Nästa dag</button>
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
                            <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/AdminAddALaCarte" method="post">
                                <div class="form-group">
                                    <h3 class="text-center mb-4">Måltider</h3>
                                    <textarea type="text" class="form-control" id="preFood" name="pre" placeholder="Förrätt"></textarea>
                                        <div class="d-flex justify-content-center mt-3">
                                            <button type="submit" class="btn btn-success justify-content-center" onclick="showCarte()">Lägg till</button>
                                        </div>
                                    <textarea type="text" class="form-control mt-3 " id="mainFood" name="main" placeholder="Huvudrätt"></textarea>
                                        <div class="d-flex justify-content-center mt-3">
                                            <button type="submit" class="btn btn-success justify-content-center" onclick="showCarte()">Lägg till</button>
                                        </div>
                                    <textarea type="text" class="form-control mt-3" id="afterFood" name="after" placeholder="Efterrätt"></textarea>
                                        <div class="d-flex justify-content-center mt-3">
                                            <button type="submit" class="btn btn-success justify-content-center" onclick="showCarte()">Lägg till</button>
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
                <ul>
                    <%
                        List<EmployeeEntity> list = Manager.getAllEmployee();
                        for (EmployeeEntity obj : list) {
                    %>
                    <li><%= obj.getFirstName() + " " + obj.getLastName() %></li>
                    <% } %>
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

    function showEmp() {
        const emp = document.getElementById("anställda");
        emp.click();
    }

</script>



</body>
</html>
