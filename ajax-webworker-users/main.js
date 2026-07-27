const worker = new Worker("worker.js");

worker.postMessage("start");

worker.onmessage = function (event) {

    if (event.data.error) {
        console.log(event.data.error);
        return;
    }

    event.data.forEach(user => {

        if (user.active) {
            console.log(user.name + " - Active");
        } else {
            console.log(user.name + " - Inactive");
        }

    });

};