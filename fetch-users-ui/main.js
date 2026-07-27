const worker = new Worker("worker.js");

worker.postMessage("start");

worker.onmessage = function(event) {

    let div = document.getElementById("users");

    if(event.data.error){
        div.innerHTML = event.data.error;
        return;
    }

    for(let i = 0; i < event.data.length; i++){

        let user = event.data[i];

        div.innerHTML += user.name + " - ";

        if(user.active){
            div.innerHTML += "Active";
        }
        else{
            div.innerHTML += "Inactive";
        }

        div.innerHTML += "<br>";
    }

};