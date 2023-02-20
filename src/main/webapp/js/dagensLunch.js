const days = document.querySelectorAll(".list-group-item");
const dayInfo = document.getElementById("day-info");

const currentDay = new Date().toLocaleString('default', { weekday: 'long' });
console.log(currentDay);
const currentDayElement = document.getElementById(currentDay);

days.forEach(day => {
    day.addEventListener("click", function() {
        switch (day.id) {
            case "måndag":
                dayInfo.innerHTML = `
          <div class="card-body">
            <h5 class="card-title">Måndag</h5>
            <p class="card-text">Fatimas köttfärslimpa med brunsås och potatismos.</p>
            <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
                <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
            </div>
        `
                break;
            case "tisdag":
                dayInfo.innerHTML = `
          <div class="card-body">
            <h5 class="card-title">Tisdag</h5>
            <p class="card-text">Fatimas köttfärslimpa med brunsås och potatismos.</p>
            <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
                <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
            </div>
        `
                break;
            case "onsdag":
                dayInfo.innerHTML = `
          <div class="card-body">
            <h5 class="card-title">Onsdag</h5>
            <p class="card-text">Fatimas köttfärslimpa med brunsås och potatismos.</p>
            <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
                <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
            </div>
        `
                break;
            case "torsdag":
                dayInfo.innerHTML = `
          <div class="card-body">
            <h5 class="card-title">Torsdag</h5>
            <p class="card-text">Fatimas köttfärslimpa med brunsås och potatismos.</p>
            <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
                <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
            </div>
          `
                break;
            case "fredag":
                dayInfo.innerHTML = `
            <div class="card-body">
            <h5 class="card-title">Fredag</h5>
            <p class="card-text">Fatimas köttfärslimpa med brunsås och potatismos.</p>
            <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
                <br/>
                <p class="card-text">Vegetariskt: Vegetarisk köttfärslimpa med brunsås och potatismos.</p>
            </div>
          `
            default:
                break;
        }
    });
});

if (currentDayElement) {
    currentDayElement.click();
}