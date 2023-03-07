// Define an array with the names of the days
const days = ["Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag"];
// Keep track of the index of the current day in the array
let currentDayIndex = 0;
function previousDay() {
    // Decrement the current day index and wrap around to the last day if necessary
    currentDayIndex = (currentDayIndex - 1 + days.length) % days.length;
    // Update the text of the day and clear the input fields
    document.getElementById("day").textContent = days[currentDayIndex];
    document.getElementById("exampleFormControlInput1").value = "";
    document.getElementById("exampleFormControlInput2").value = "";
    document.getElementById("exampleFormControlInput3").value = "";
    // Update the hidden input field with the current day value
    document.getElementById("selectedDay").value = days[currentDayIndex];
}

function nextDay() {
    // Increment the current day index and wrap around to the first day if necessary
    currentDayIndex = (currentDayIndex + 1) % days.length;
    // Update the text of the day and clear the input fields
    document.getElementById("day").textContent = days[currentDayIndex];
    document.getElementById("exampleFormControlInput1").value = "";
    document.getElementById("exampleFormControlInput2").value = "";
    document.getElementById("exampleFormControlInput3").value = "";
    // Update the hidden input field with the current day value
    document.getElementById("selectedDay").value = days[currentDayIndex];
}

const choices = document.querySelectorAll(".lista");
const choiceInfos =document.querySelectorAll(".choice-info");
const veckomeny = document.getElementById("veckomeny");
const carte = document.getElementById("carte");

choices.forEach(choice => {
    choice.addEventListener("click", function() {
// Remove the "selected" class from all list items
        choices.forEach(d => d.classList.remove("selected"));
        // Add the "selected" class to the clicked item
        choice.classList.add("selected");


        // Show the selected day's information
        console.log(choice.id);

        showChoiceInfo(choice.id);
    });
});
function showChoiceInfo(choiceId){
    choiceInfos.forEach(choiceInfo =>{
        choiceInfo.style.display = "none";
    });
    //Show the selected choice information
    const choiceInfo = document.getElementById(`${choiceId}-info`);
    choiceInfo.style.display = "block";
}
function displaySecondCard(){
    const card = document.getElementById("listaEMP");
    card.classList.remove("d-none");
}
function displayAddCarteCard(){
    const card = document.getElementById("addCarte");
    card.classList.remove("d-none");
}
function hideAddCarteCard(){
    const card = document.getElementById("addCarte");
    card.classList.add("d-none");
}

function hideSecondCard(){
    const card = document.getElementById("listaEMP");
    card.classList.add("d-none");
}

veckomeny.click();

function showCarte(){
    carte.click();
}

function deleteEmployee(id) {
    if (confirm("Är du säker på att du vill ta bort denna anställda?")) {
        $.ajax({
            url: "deleteEmployee",
            type: "POST",
            data: { id: id },
            success: function() {
                // Reload the page after the employee is deleted
                window.location.href = "AdminPanel.jsp?functionName=myFunction";
            }
        });
    }
}

function deleteMenuItem(id) {
    if (confirm("Är du säker på att du vill ta bort denna maträtt?")) {
        $.ajax({
            url: "deleteMenuItem",
            type: "POST",
            data: { id: id },
            success: function() {
                // Reload the page after the employee is deleted and show carte
                window.location.href = "AdminPanel.jsp?functionCarte=showCarte";
            }
        });
    }
}

const form = document.querySelector('#carteForm');

form.addEventListener('submit', (event) => {
    event.preventDefault(); // prevent the default form submission behavior


    let kategori = document.querySelector('#category').value;
        let name = document.querySelector('#namn').value;
        let desc = document.querySelector('#description').value;
        let price = document.querySelector('#price').value;
    $.ajax({
        type: 'POST', // set the HTTP method
        url: 'AdminAddALaCarte', // set the URL of the servlet
        data: { kategori: kategori, name: name, desc: desc, price: price },
        success: function () {
            window.location.href = "AdminPanel.jsp?functionCarte=showCarte";
        }
    });
});

const employeeForm = document.querySelector('#empForm');
employeeForm.addEventListener('submit', (event) => {
    event.preventDefault(); // prevent the default form submission behavior


    let fname = document.querySelector('#fname').value;
    let ename = document.querySelector('#ename').value;
    let email = document.querySelector('#email').value;
    let telnr = document.querySelector('#telnr').value;


    $.ajax({
        type: 'POST', // set the HTTP method
        url: 'AddEmp', // set the URL of the servlet
        data: { fname: fname, ename: ename, email: email, telnr: telnr },
        success: function () {
            window.location.href = "AdminPanel.jsp?functionName=myFunction";
        }
    });
});

