let myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

document.getElementById('submitButton').addEventListener('click', handleSubmitButton)

/**+
 * Function that fetches JWT token
 */
function handleSubmitButton() {
    let tokenRequest = JSON.stringify({
        "email": document.getElementById('email').value,
        "password": document.getElementById('password').value
    });

    let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: tokenRequest,
        mode: 'cors'

    };

    fetch("http://localhost:8071/api/v1/auth/login", requestOptions)
        .then(function (response) {
            if (response.status === 200) {
                response.text()
                    .then(token => document.cookie = "Authorisation=Bearer_" + token)
                window.location.href = "/"
            } else response.text()
                .then(responseText => console.log(responseText))
        })
        .catch(error => console.log('error', error));
}

/**
 * function gets auth token from cookie
 * @returns {string}
 */
function getAuthCookie() {
    const cn = "Authorisation=";
    const idx = document.cookie.indexOf(cn);

    if (idx !== -1) {
        let end = document.cookie.indexOf(";", idx + 1);
        if (end === -1) end = document.cookie.length;
        return unescape(document.cookie.substring(idx + cn.length, end));
    } else {
        return "";
    }
}
