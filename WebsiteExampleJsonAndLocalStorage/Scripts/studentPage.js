function studentPageFill(){
    var studentPage = document.getElementById("studentInfo");

    //Grabs personal info from local storage and adds to the page.
    studentPage.innerHTML += `<h1 class="studentInf">My name is ${localStorage.getItem('name')}</h1>`;
    studentPage.innerHTML += `<h2 class="studentInf">My Sheridan student ID is ${localStorage.getItem('studentId')}</h2>`;
    studentPage.innerHTML += `<h3 class="studentInf">My Sheridan login is ${localStorage.getItem('login')}</h3>`;
    studentPage.innerHTML += `<h4 class="studentInf">My Sheridan program is ${localStorage.getItem('program')}</h4>`;
    studentPage.innerHTML += `<h5 class="studentInf">My home country is ${localStorage.getItem('homeCountry')}</h5>`;

    //Gives each header a different text colour
    var inf = document.getElementsByClassName("studentInf")
    var colors = 111;
    for(c of inf){
        c.style.color = `rgb(${colors + 55},${colors},${colors + 22})`;
        colors += 33;
    }
}