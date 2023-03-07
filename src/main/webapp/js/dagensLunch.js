const days = document.querySelectorAll(".list-group-item");
const dayInfos = document.querySelectorAll(".day-info");

const currentDay = new Date().toLocaleString('default', { weekday: 'long' });
console.log(currentDay);
const currentDayElement = document.getElementById(currentDay);

days.forEach(day => {
    day.addEventListener("click", function() {
// Remove the "selected" class from all list items
        days.forEach(d => d.classList.remove("selected"));
        // Add the "selected" class to the clicked item
        day.classList.add("selected");

        // Show the selected day's information
        showDayInfo(day.id);
    });
});

function showDayInfo(dayId) {
// Hide all the day-info divs
    dayInfos.forEach(dayInfo => {
        dayInfo.style.display = "none";
    });
    // Show the selected day's information
    const dayInfo = document.getElementById(`${dayId}-info`);
    dayInfo.style.display = "block";
}
if (currentDayElement) {
    currentDayElement.click();
}
