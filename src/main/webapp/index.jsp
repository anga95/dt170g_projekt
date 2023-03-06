<%@ page import="se.miun.dt170g_projekt.entites.EmployeeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="se.miun.dt170g_projekt.persistanceManager.Manager" %>
<%@ page import="se.miun.dt170g_projekt.entites.DailyLunchEntity" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>

<%@ include file="head.jsp" %>


 <%@ include file="navbar.jsp" %>


<h1 class="display-1 text-center mt-3"><%= "Dagens lunch" %></h1>
<br/>
<div class="container-fluid d-flex justify-content-center mt-3 mb-5">
    <div class="row">
        <div class="col-6 d-flex align-items-center">
            <ul>
                <li class="lista list-group-item border-0 mb-2" id="måndag" onclick="showDayInfo('måndag')">Måndag</li>
                <li class="lista list-group-item border-0 mb-2" id="tisdag" onclick="showDayInfo('tisdag')">Tisdag</li>
                <li class="lista list-group-item border-0 mb-2" id="onsdag" onclick="showDayInfo('onsdag')">Onsdag</li>
                <li class="lista list-group-item border-0 mb-2" id="torsdag" onclick="showDayInfo('torsdag')">Torsdag</li>
                <li class="lista list-group-item border-0" id="fredag" onclick="showDayInfo('fredag')">Fredag</li>
            </ul>
        </div>
        <div class="col-6">
            <div class="card mt-3 pb-5" style="width: 20rem;">
                <div class="day-info" id="måndag-info">
                    <div class="card-body">
                        <h5 class="card-title">Måndag</h5>
                        <%
                            List<DailyLunchEntity> list = Manager.getAllDaily();
                            for (DailyLunchEntity obj : list) {
                                if (obj.getWeekday().equals("Måndag")) {
                        %>
                        <p class="card-text"><%= obj.getLunch1() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch2() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch3() %></p>
                        <% }} %>
                    </div>
                </div>


                <div class="day-info" id="tisdag-info">
                    <div class="card-body">
                        <h5 class="card-title">Tisdag</h5>
                        <%
                            for (DailyLunchEntity obj : list) {
                                if (obj.getWeekday().equals("Tisdag")) {
                        %>
                        <p class="card-text"><%= obj.getLunch1() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch2() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch3() %></p>
                        <% }} %>
                    </div>
                </div>

                <div class="day-info" id="onsdag-info">
                    <div class="card-body">
                        <h5 class="card-title">Onsdag</h5>
                        <%
                            for (DailyLunchEntity obj : list) {
                                if (obj.getWeekday().equals("Onsdag")) {
                        %>
                        <p class="card-text"><%= obj.getLunch1() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch2() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch3() %></p>
                        <% }} %>
                    </div>
                </div>

                <div class="day-info" id="torsdag-info">
                    <div class="card-body">
                        <h5 class="card-title">Torsdag</h5>
                        <%
                            for (DailyLunchEntity obj : list) {
                                if (obj.getWeekday().equals("Torsdag")) {
                        %>
                        <p class="card-text"><%= obj.getLunch1() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch2() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch3() %></p>
                        <% }} %>
                    </div>
                </div>

                <div class="day-info" id="fredag-info">
                    <div class="card-body">
                        <h5 class="card-title">Fredag</h5>
                        <%
                            for (DailyLunchEntity obj : list) {
                                if (obj.getWeekday().equals("Fredag")) {
                        %>
                        <p class="card-text"><%= obj.getLunch1() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch2() %></p>
                        <br/>
                        <p class="card-text"><%= obj.getLunch3() %></p>
                        <% }} %>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<br/>
<script src="js/dagensLunch.js"></script>
<%@ include file="event.jsp" %>
<%@ include file="footer.jsp" %>
</body>
</html>