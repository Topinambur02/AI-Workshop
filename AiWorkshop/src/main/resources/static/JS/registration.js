document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var userData = {
        login: document.getElementById('login').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/api/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
    .then(response => {
        if (response.ok){
            showSuccessMessage("Пользователь успешно зарегистрирован");
        }
        else {
            showErrorMessage("Ошибка регистрации пользователя");
            throw new Error("Registration failed");
        }})
    .catch((error) => {
        console.error('Error:', error);
    });
});

function showSuccessMessage(message) {
    const successMessageDiv = document.createElement('div');
    successMessageDiv.id = "successMessage"

    successMessageDiv.textContent = message;
    successMessageDiv.style.color = 'rgb(0, 89, 0)';
    successMessageDiv.style.backgroundColor = 'rgb(118, 163, 129)';
    successMessageDiv.style.padding = '10px';
    successMessageDiv.style.margin = '10px 0';
    successMessageDiv.style.borderRadius = '5px';
    successMessageDiv.style.border = '1px solid #C3E6CB';

    const container = document.getElementById('messageContainer');
    container.appendChild(successMessageDiv);
}

function showErrorMessage(message) {
    const errorMessageDiv = document.createElement('div');
    errorMessageDiv.id = "errorMessage"

    errorMessageDiv.textContent = message;
    errorMessageDiv.style.color = 'rgb(99, 6, 0)';
    errorMessageDiv.style.backgroundColor = 'rgb(163, 118, 118)';
    errorMessageDiv.style.padding = '10px';
    errorMessageDiv.style.margin = '10px 0';
    errorMessageDiv.style.borderRadius = '5px';
    errorMessageDiv.style.border = '1px solid #C3E6CB';

    const container = document.getElementById('messageContainer');
    container.appendChild(successMessageDiv);
}
