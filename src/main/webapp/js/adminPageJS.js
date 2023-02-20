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