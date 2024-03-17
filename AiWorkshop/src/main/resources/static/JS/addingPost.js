document.getElementById('addingPostForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var userData = {
        title: document.getElementById('title').value,
        fullText: document.getElementById('full_text').value,
        additionDate: String(new Date()).slice(4,15).replaceAll(" ", "-"),
        countOfLikes: 0,
        countOfDislikes: 0
    };

    console.log(userData);

    fetch('http://localhost:8080/api/post/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
    .then(response => {
        if (response.ok){
            console.log();
        }

        else{
            showErrorMessage("Ошибка сохранения!");
        }
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});

function showErrorMessage(message) {
    const errorMessageDiv = document.createElement('div');
    errorMessageDiv.id = "errorMessage";

    errorMessageDiv.textContent = message;
    errorMessageDiv.style.color = 'rgb(99, 6, 0)';
    errorMessageDiv.style.backgroundColor = 'rgb(163, 118, 118)';
    errorMessageDiv.style.padding = '10px';
    errorMessageDiv.style.margin = '10px 0';
    errorMessageDiv.style.borderRadius = '5px';
    errorMessageDiv.style.border = '1px solid #C3E6CB';

    const container = document.getElementById('messageContainer');
    container.appendChild(errorMessageDiv);
}