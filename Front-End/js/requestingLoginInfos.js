import {
    displayUserInfos
} from './app.js';

const requestingLogingInfos = (usernameValue, passwordValue) => {

    const user = {
        "username": usernameValue,
        "password": passwordValue
    }
    let chosenData = document.querySelector('select').value;
    let endpoint = "";
    if (chosenData == "Teacher") {
        endpoint = "http://localhost:8080/login/teacher";
    } else if (chosenData == "Student") {
        endpoint = "http://localhost:8080/login/student";
    }
    fetch(endpoint, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        })
        .then(response => response.json())
        .then(JSONresponse => displayUserInfos(JSONresponse))
        .catch(err => console.error(err));

}

export {
    requestingLogingInfos
}