// ELEMENTS AND VARIABLES
const change_profile_info = document.getElementById('profile_change_profile_info')
const current_profile_tab = document.getElementsByClassName('tab_button_active')

const saved_tab = document.getElementById('saved_tab')
const liked_tab = document.getElementById('liked_tab')
const history_tab = document.getElementById('history_tab')
const comments_tab = document.getElementById('comments_tab')


// EVENT LISTENERS
change_profile_info.addEventListener('click', goToEditProfile)

saved_tab.addEventListener('click', savedTab)
liked_tab.addEventListener('click', likedTab)
history_tab.addEventListener('click', historyTab)
comments_tab.addEventListener('click', commentsTab)


// FUNCTIONS
function goToEditProfile() {window.location.href = 'edit_profile.html'}

function savedTab() {
    // Activate tab animation
    const current_profile_tab = document.getElementsByClassName('tab_button_active')[0]
    if (current_profile_tab === saved_tab) {return}
    try {
        const current_profile_tab_underline = current_profile_tab.querySelector('hr')
        
        current_profile_tab_underline.style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        current_profile_tab_underline.style.width = '0%'
        setTimeout(() => (
            current_profile_tab.classList.remove('tab_button_active')
        ), 250)
        saved_tab.classList.add('tab_button_active')
        saved_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        saved_tab.querySelector('hr').style.width = '100%'
        setTimeout(() => (
            window.location.href = 'profile.html'
        ), 250)
    }
    catch (error) {
        console.log(error)
        saved_tab.classList.add('tab_button_active')
        saved_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        saved_tab.querySelector('hr').style.width = '100%'
    }
}
function likedTab() {
    // Activate tab animation
    const current_profile_tab = document.getElementsByClassName('tab_button_active')[0]
    if (current_profile_tab === liked_tab) {return}
    try {
        const current_profile_tab_underline = current_profile_tab.querySelector('hr')
        
        current_profile_tab_underline.style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        current_profile_tab_underline.style.width = '0%'
        setTimeout(() => (
            current_profile_tab.classList.remove('tab_button_active')
        ), 250)
        liked_tab.classList.add('tab_button_active')
        liked_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        liked_tab.querySelector('hr').style.width = '100%'
    }
    catch (error) {
        console.log(error)
        liked_tab.classList.add('tab_button_active')
        liked_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        liked_tab.querySelector('hr').style.width = '100%'
    }
}
function historyTab() {
    // Activate tab animation
    const current_profile_tab = document.getElementsByClassName('tab_button_active')[0]
    if (current_profile_tab === history_tab) {return}
    try {
        const current_profile_tab_underline = current_profile_tab.querySelector('hr')
        
        current_profile_tab_underline.style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        current_profile_tab_underline.style.width = '0%'
        setTimeout(() => (
            current_profile_tab.classList.remove('tab_button_active')
        ), 250)
        history_tab.classList.add('tab_button_active')
        history_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        history_tab.querySelector('hr').style.width = '100%'
    }
    catch (error) {
        console.log(error)
        history_tab.classList.add('tab_button_active')
        history_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        history_tab.querySelector('hr').style.width = '100%'
    }
}
function commentsTab() {
    // Activate tab animation
    const current_profile_tab = document.getElementsByClassName('tab_button_active')[0]
    if (current_profile_tab === comments_tab) {return}
    try {
        const current_profile_tab_underline = current_profile_tab.querySelector('hr')
        
        current_profile_tab_underline.style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        current_profile_tab_underline.style.width = '0%'
        setTimeout(() => (
            current_profile_tab.classList.remove('tab_button_active')
        ), 250)
        comments_tab.classList.add('tab_button_active')
        comments_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        comments_tab.querySelector('hr').style.width = '100%'
        setTimeout(() => (
            window.location.href = 'profile_comments.html'
        ), 250)
    }
    catch (error) {
        console.log(error)
        comments_tab.classList.add('tab_button_active')
        comments_tab.querySelector('hr').style.transition = 'width 0.3s cubic-bezier(0.65, 0.01, 0.41, 1.02) 0s'
        comments_tab.querySelector('hr').style.width = '100%'
    }
}