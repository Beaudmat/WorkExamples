function loadData(){
    var studentData;
    var animalData;

    fetch("JSON/a1.json")
    .then(data => data.json())
    .then((dataJSON) => {

        //Creates Header
        var headerText = `<p>Fall 2022 Assignment #1 for <strong>${dataJSON.student.name}</strong> from 
        <strong>${dataJSON.student.homeCountry}</strong><a href="Pages/studentPage.html"> LINK TO SECOND PAGE</a></p>`;
        document.getElementById("header").innerHTML = headerText;

        //Creates footer
        var footerText = `<p>My Login: ${dataJSON.student.login} / My ID: 
        ${dataJSON.student.studentId} / My Program: ${dataJSON.student.program}</p>`;
        document.getElementById("footer").innerHTML = footerText;

        //Stores personal data and puts it in local storage
        studentData = dataJSON.student;
        localStorage.setItem('name', studentData.name);
        localStorage.setItem('homeCountry', studentData.homeCountry);
        localStorage.setItem('login', studentData.login);
        localStorage.setItem('studentId', studentData.studentId);
        localStorage.setItem('program', studentData.program);

        //Stores animal data
        animalData = dataJSON.animals;

        //Creates Animal Data Panel
        var animalPrintout = "<h1>Animal List</h1>";
        for(animals of animalData){
            animalPrintout += `<p class="${animals.classification}">${animals.id}/${animals.name}
            / ${animals.classification}</p>`;
            console.log(`<p class="${animals.classification}>`);
        }
        document.getElementById("leftPanel").innerHTML = animalPrintout;
    });

   
}

//Changes the style of the data display area
function changeStyle(){
    var dataDisplay = document.getElementById("leftPanel");
    if(dataDisplay.classList.contains("leftPanelAlt")){
        dataDisplay.classList.remove("leftPanelAlt");
    }
    else{
        dataDisplay.classList.add("leftPanelAlt");
    }
}

//toggles borders on mammals
function addMamBorder(){
    document.getElementById("leftPanel").querySelectorAll("p[class=Mammal]").forEach(x => {
        if(x.style.border == '3px solid black')
            x.style.border = 'none';
        else
            x.style.border = '3px solid black';
    });
}

//Changes the background colour of reptiles
function changeRepBack(){
    document.getElementById("leftPanel").querySelectorAll("p[class=Reptile]").forEach(x => {
        x.style.backgroundColor = "DarkGreen";
    });
}