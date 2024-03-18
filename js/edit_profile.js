// ELEMENTS AND VARIABLES
const change_profile_picture_area = document.getElementById('change_profile_picture_area');
const fileUpload = document.getElementById('file_upload');
const profile_picture = document.getElementById('profile_picture');


// EVENT LISTENERS
change_profile_picture_area.addEventListener('click', uploadPicture);
fileUpload.addEventListener('change', showUploadedProfilePicture);



// FUNCTIONS
function uploadPicture(Event) {
    Event.preventDefault();
    fileUpload.click();
}
function showUploadedProfilePicture() {
    const file = fileUpload.files[0];
    profile_picture.src = URL.createObjectURL(file);
}