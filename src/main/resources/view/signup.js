function getRandomNumber(min, max) {
    return String(Math.floor(Math.random() * (max - min + 1)) + min);
}


    async function submitForm() {
    // var fullName = document.getElementById('FullName').value;
    // var mail = document.getElementById('Mail').value;
    // var mobileNumber = document.getElementById('MobileNumber').value;
    // var password = document.getElementById('Password').value;
    // var birthDate = document.getElementById('BirthDate').value;
    //
    // // Check if the input field is empty
    // if (
    //     fullName.trim() === '' ||
    //     mail.trim() === '' ||
    //     mobileNumber.trim() === '' ||
    //     password.trim() === '' ||
    //     birthDate.trim() === ''
    // ) {
    //     alert('Please fill all fields');
    //     return false; // Prevent the form submission
    // }
    try {
        const requestBody = {
            FullName: "fullName",
            Mail: "mail",
            MobileNumber: getRandomNumber(100,10000),
            Password: "password",
            BirthDate: "birthDate",
        };
        const requestHeaders = {
            'Content-Type': 'application/json',
            'Cache-Control': 'no-cache',
            'Access-Control-Allow-Origin': '*',
            'ccess-Control-Allow-Methods': 'POST'
        };

        const controller = new AbortController();
        const timeoutId = setTimeout(() => controller.abort(), 5000); // Timeout set to 5 seconds (5000 milliseconds)

        const endpointUrl = 'http://localhost:8085/register-user';

        // const timeout = 5000; // 5 seconds
        // const response = await fetch(endpointUrl, {
        //     method: 'POST',
        //     headers: requestHeaders,
        //     body: JSON.stringify(requestBody), // Convert the data to a JSON string
        //     signal: controller.signal, // Associate the signal with the request
        // });

        fetch(endpointUrl, {
            method: 'POST',
            headers: requestHeaders,
            body: JSON.stringify(requestBody)
        })
            .then(response => {
                // Check if the response status is OK (200)
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                // Parse the JSON response
                return response.json();
            })
            .then(data => {
                // Log the entire response for debugging
                console.log('Response:', data);
                if (data["Message"] === "200") {
                    window.location.href = "roomSearch.html"
                }
            })
            .catch(error => {
                // Handle any errors that occurred during the fetch
                alert(error)
            });

    } catch (error) {
        alert(error);
        console.error('There was a problem with the fetch operation:', error);
    }
    document.getElementById("signup-form").reset();
}
