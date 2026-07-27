self.onmessage = function () {

    fetch("https://dummyapi.com/users")
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch data");
            }
            return response.json();
        })
        .then(users => {

            if (users.length === 0) {
                throw new Error("No users found");
            }

            self.postMessage(users);
        })
        .catch(error => {
            self.postMessage({ error: error.message });
        });

};