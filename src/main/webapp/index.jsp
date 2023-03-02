<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>

<%@ include file="head.jsp" %>


 <%@ include file="navbar.jsp" %>


<h1 class="display-1 text-center mt-3"><%= "Dagens lunch" %></h1>
<br/>
<div class="container-fluid d-flex justify-content-center mt-3 mb-5">
    <div class="row">
        <div class="col-6 d-flex align-items-center">
            <ul>
                <li class="list-group-item border-0 mb-2" id="måndag" onclick="showDayInfo('måndag')">Måndag</li>
                <li class="list-group-item border-0 mb-2" id="tisdag" onclick="showDayInfo('tisdag')">Tisdag</li>
                <li class="list-group-item border-0 mb-2" id="onsdag" onclick="showDayInfo('onsdag')">Onsdag</li>
                <li class="list-group-item border-0 mb-2" id="torsdag" onclick="showDayInfo('torsdag')">Torsdag</li>
                <li class="list-group-item border-0" id="fredag" onclick="showDayInfo('fredag')">Fredag</li>
            </ul>
        </div>
        <div class="col-6">
            <div class="card mt-3 pb-5" style="width: 20rem;">
                <div class="day-info" id="måndag-info">
                    <div class="card-body">
                        <h5 class="card-title">Måndag</h5>
                        <p class="card-text"><%= request.getAttribute("dish1Mon") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish2Mon") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish3Mon") %></p>
                    </div>
                </div>


                <div class="day-info" id="tisdag-info">
                    <div class="card-body">
                        <h5 class="card-title">Tisdag</h5>
                        <p class="card-text"><%= request.getAttribute("dish1Tis") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish2Tis") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish3Tis") %></p>
                    </div>
                </div>

                <div class="day-info" id="onsdag-info">
                    <div class="card-body">
                        <h5 class="card-title">Onsdag</h5>
                        <p class="card-text"><%= request.getAttribute("dish1Ons") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish2Ons") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish3Ons") %></p>
                    </div>
                </div>

                <div class="day-info" id="torsdag-info">
                    <div class="card-body">
                        <h5 class="card-title">Torsdag</h5>
                        <p class="card-text"><%= request.getAttribute("dish1Tor") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish2Tor") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish3Tor") %></p>
                    </div>
                </div>

                <div class="day-info" id="fredag-info">
                    <div class="card-body">
                        <h5 class="card-title">Fredag</h5>
                        <p class="card-text"><%= request.getAttribute("dish1Fre") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish2Fre") %></p>
                        <br/>
                        <p class="card-text"><%= request.getAttribute("dish3Fre") %></p>
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