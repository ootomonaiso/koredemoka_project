// scriptタグにあったやつを関数にした
// 新規追加js
document.addEventListener('DOMContentLoaded', function() {
    const headerContainer = document.getElementById('header-container');
    const footerContainer = document.getElementById('footer-container');
    const url = window.location.pathname;

    let headerTemplateUrl, footerTemplateUrl;

    if (url === '/chat') {
        headerTemplateUrl = '/chat/header';
        footerTemplateUrl = '/chat/footer';
    } else {
        headerTemplateUrl = '/header';
        footerTemplateUrl = '/footer';
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
});
