<%--
  Created by IntelliJ IDEA.
  User: silve
  Date: 2023-02-16
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<%@ include file="navbar.jsp" %>

<h1 class="display-1 text-center mt-3"><%= "Boka ditt bord" %></h1>

<section class="h-100 h-custom" >
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registrerings info</h3>

            <form action="${pageContext.request.contextPath}/bookingPage" method="post" id="bookingForm" class="px-md-2">
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline mb-4">
                    <label class="form-label" for="checkin-date">Välj Dag</label>
                    <input type="date" id="checkin-date" name="checkin" class="form-control" value="" required>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="form-outline mb-4">
                    <label for="bokning-tid" class="mb-2">Välj Tid</label>
                    <input type="time" id="bokning-tid" class="form-control"
                           name="bokning-tid" value="17:00"
                           min="16:00" max="20:00" step="900"  required>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline mb-4">
                    <label class="form-label" for="form3fnamn">Förnamn</label>
                    <input type="text" id="form3fnamn" name="fname" class="form-control" required/>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="form-outline mb-4">
                    <label class="form-label" for="form3enamn">Efternamn</label>
                    <input type="text" id="form3enamn" name="ename" class="form-control" required/>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline mb-4">
                    <label class="form-label" for="form3tel">Telefonnummer</label>
                    <input type="text" id="form3tel" name="telnum" class="form-control" required/>
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline mb-4">
                    <label class="form-label" for="form3mail">Mail</label>
                    <input type="text" id="form3mail" name="mail" class="form-control" required/>
                  </div>
                </div>
              </div>

              <div class="row">

                <div class="col-md-6 mb-4">

                  <div class="form-outline mb-5">
                    <label class="form-label" for="form3num">Antal personer</label>
                    <input type="number" id="form3num" name="numpeople" class="form-control" value="2" min="1" max="6" required/>
                  </div>

                </div>

                <div class="col-md-6 md-4">

                  <div class="form-outline mb-5">
                    <label class="form-label" for="form3extra">Extra</label>
                    <textarea type="text" id="form3extra" name="extra" class="form-control"></textarea>
                  </div>

                </div>

              </div>
              <div class="row d-flex justify-content-center align-items-center">
                <button type="submit" class="btn btn-warning mb-1">Boka</button>
              </div>


            </form>
            <form action="">
              <input type="hidden" name="myField" id="myField" value="" />
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<%@include file="footer.jsp"%>
<script src="js/BookingValues.js"></script>
</body>
</html>
