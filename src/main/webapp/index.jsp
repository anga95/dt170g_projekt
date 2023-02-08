<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="head.jsp" %>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Antons Skafferi</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

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