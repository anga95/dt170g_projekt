<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>


<h1 class="display-1 text-center"><%= "Dagens lunch" %></h1>
<br/>
<div class="container-fluid d-flex justify-content-center mt-3">
    <div class="row">
        <div class="col-4">
            <ul class="list-group">
                <li class="list-group-item" id="Monday">Monday</li>
                <li class="list-group-item" id="Tuesday">Tuesday</li>
                <li class="list-group-item" id="Wednesday">Wednesday</li>
                <li class="list-group-item" id="Thursday">Thursday</li>
                <li class="list-group-item" id="Friday">Friday</li>
            </ul>
        </div>
        <div class="col-8">
            <div class="card" style="width: 18rem;" id="day-info">
                <!-- Add information about the selected day here -->
            </div>
        </div>
    </div>
</div>
<script>
    const days = document.querySelectorAll(".list-group-item");
    const dayInfo = document.getElementById("day-info");
    days.forEach(day => {
        day.addEventListener("click", function() {
            switch (day.id) {
                case "Monday":
                    dayInfo.innerHTML = `
            <div class="card-body">
              <h5 class="card-title">Monday</h5>
              <p class="card-text">Fatimas köttfärslimpa med brunsås och potatismos.</p>
            </div>
          `;
                    break;
                case "Tuesday":

                    break;
                case "Wednesday":
                    // Add information about Wednesday here
                    break;
                case "Thursday":
                    // Add information about Thursday here
                    break;
                case "Friday":
                    // Add information about Friday here
                default:
                    break;
            }
        });
    });
</script>
</body>
</html>