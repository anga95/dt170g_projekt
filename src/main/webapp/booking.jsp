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

<h1 class="display-1 text-center mt-3"><%= "Bokning" %></h1>

<section class="h-100 h-custom" >
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registrerings info</h3>

            <form class="px-md-2">
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline mb-4">
                    <input type="date" id="checkin-date" name="checkin" class="form-control" required>
                    <label class="form-label" for="checkin-date">Välj Dag</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline timepicker-inline-12">
                    <input type="text" class="form-control" id="form4" />
                    <label class="form-label" for="form4">Välj Tid</label>
                  </div>

                </div>
              </div>
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="form-outline mb-4">
                    <input type="text" id="form3fnamn" class="form-control" />
                    <label class="form-label" for="form3fnamn">Förnamn</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="form-outline mb-4">
                    <input type="text" id="form3enamn" class="form-control" />
                    <label class="form-label" for="form3enamn">Efternamn</label>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline mb-4">
                    <input type="text" id="form3tel" class="form-control" />
                    <label class="form-label" for="form3tel">Telefonnummer</label>
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline mb-4">
                    <input type="text" id="form3mail" class="form-control" />
                    <label class="form-label" for="form3mail">Mail</label>
                  </div>

                </div>
              </div>

              <button type="submit" class="btn btn-success btn-lg mb-1">Boka</button>

            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<%@include file="footer.jsp"%>
<script src="js/script.js"></script>
</body>
</html>
