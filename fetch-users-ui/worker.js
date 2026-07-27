self.onmessage = function() {

    fetch("https://dummyapi.com/users")

    .then(function(response){

        if(!response.ok){
            throw "Unable to fetch users";
        }

        return response.json();

    })

    .then(function(users){

        if(users.length == 0){
            throw "No users found";
        }

        self.postMessage(users);

    })

    .catch(function(error){

        self.postMessage({error : error});

    });

};