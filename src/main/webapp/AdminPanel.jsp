<%--
  Created by IntelliJ IDEA.
  User: Engma
  Date: 2023-02-14
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<%@ include file="navbar.jsp" %>
<h1 class="display-1 text-center mt-3"><%= "VECKOMENY" %></h1>
<br/>
<div class="container-fluid d-flex justify-content-center">
    <div class="row">
        <div class="col-6 d-flex align-items-center">
            <ul>
                <li class="list-group-item border-0 mb-2" id="veckomeny" onclick="showChoiceInfo('veckomeny')">Veckomeny</li>
                <li class="list-group-item border-0 mb-2" id="anställda" onclick="showChoiceInfo('anställda')">Anställda</li>
                <li class="list-group-item border-0 mb-2" id="schema" >Schema</li>
                <li class="list-group-item border-0 mb-2" id="carte" >A la carte</li>
            </ul>
        </div>
        <div class="col-6">
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
                                <button type="submit" class="btn btn-primary">Spara</button>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="choice-info" id="anställda-info">
                    <div class="card-body">
                        <p>HEJSAN ALLA</p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>


<script src="js/adminPageJS.js"></script>


<%@include file="footer.jsp"%>
</body>
</html>
