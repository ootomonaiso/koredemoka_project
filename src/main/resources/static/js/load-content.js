document.addEventListener('DOMContentLoaded', function() {
    const headerContainer = document.getElementById('header-container');
    const footerContainer = document.getElementById('footer-container');
    const chatContainer = document.getElementById('chat-container');
    const url = window.location.pathname;

    let headerTemplateUrl, footerTemplateUrl, chatTemplateUrl;

    if (url === '/chat') {
        headerTemplateUrl = '/chat/header';
        footerTemplateUrl = '/chat/footer';
        chatTemplateUrl = '/chat';
    } else {
        headerTemplateUrl = '/header';
        footerTemplateUrl = '/footer';
        chatTemplateUrl = '/showchat';
    }

    fetch(headerTemplateUrl)
        .then(response => response.text())
        .then(html => {
            headerContainer.innerHTML = html;
        })
        .catch(error => console.error('Header fetch error:', error));

    fetch(footerTemplateUrl)
        .then(response => response.text())
        .then(html => {
            footerContainer.innerHTML = html;
        })
        .catch(error => console.error('Footer fetch error:', error));

    fetch(chatTemplateUrl)
        .then(response => response.text())
        .then(html => {
            chatContainer.innerHTML = html;
        })
        .catch(error => console.error('Chat template fetch error:', error));
});
