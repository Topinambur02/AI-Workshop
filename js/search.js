// ELEMENTS AND VARIABLES
const header_searchbar = document.getElementById('header_searchbar');
const header_searchbar_input_container = document.getElementById('header_searchbar_input_container');
const header_search_input = document.getElementById('header_search_input');
const header_input_button = document.getElementById('header_input_button');

var inactive = true;


// EVENT LISTENERS
window.addEventListener('onload', search());

header_input_button.addEventListener('mouseenter', showSearch);
header_searchbar.addEventListener('mouseleave', hideSearch);
header_input_button.addEventListener('click', search_from_header);
header_search_input.addEventListener('keydown', header_input_keyboard_listeners);



// FUNCTIONS

// Header Search
function showSearch() {
    header_searchbar_input_container.style.transition = 'width 0.8s cubic-bezier(0.65, 0.01, 0.41, 1.02), \
    opacity 1.6s';
    header_searchbar_input_container.style.width = '100%';
    header_searchbar_input_container.style.opacity = '1';
    setTimeout(() => {
        header_search_input.style.transition = 'opacity 0.5s cubic-bezier(0.65, 0.01, 0.41, 1.02)';
        header_search_input.style.opacity = '1';
    }, 400);
    setTimeout(() => {
        inactive = false;
    }, 1000);
    header_search_input.style.cursor = 'text';
    header_search_input.focus();
}
function hideSearch() {
    header_searchbar_input_container.style.transition = 'width 0.8s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s, \
    opacity 1.6s';
    header_searchbar_input_container.style.width = '0%';
    header_searchbar_input_container.style.opacity = '0';
    header_search_input.style.transition = 'opacity 0.5s cubic-bezier(0.65, 0.01, 0.41, 1.02)';
    header_search_input.style.opacity = '0';
    setTimeout(() => {
        inactive = true;
    }, 1000);
    header_search_input.style.cursor = 'default';
    header_search_input.blur();
}

function search_from_header() {
    inputValue = header_search_input.value
    if (inactive === true) {
        showSearch();
        inactive = false;
    }
    else {
        // Encode the input value to safely include it in a URL
        var encodedInputValue = encodeURIComponent(inputValue);
        // Include the input value as a URL parameter
        window.location.href = 'search.html?search=' + encodedInputValue;
        setTimeout(() => {
            inactive = true;
        }, 1000);
    }
}
function search() {
    var urlParams = new URLSearchParams(window.location.search);
    if (urlParams.size > 0) {
        // Get the input value from the URL parameters
        var inputValue = urlParams.get('search');
        const search_input = document.getElementById('search_input');
        search_input.value = inputValue;
    }
    header_search_input.style.cursor = 'default';

}
function header_input_keyboard_listeners(event) {
    if (event.key === 'Enter') {
        inactive = false;
        search_from_header()
    }
    else if (event.key === 'Escape') {
        hideSearch();
    }
}