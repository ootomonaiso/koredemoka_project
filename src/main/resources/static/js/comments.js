// コメントを表示する関数
function displayComments() {
  fetch("/show_result")
    .then(response => response.json())
    .then(comments => {
      const commentsList = document.getElementById("comments-list");
      commentsList.innerHTML = "";
      comments.forEach(comment => {
        const listItem = document.createElement("li");
        listItem.className = "comment";

        const nicknameElem = document.createElement("div");
        nicknameElem.className = "nickname";
        nicknameElem.textContent = comment.nickname;

        const textElem = document.createElement("div");
        textElem.textContent = comment.text;

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "削除";
        deleteButton.onclick = () => deleteComment(comment.id);

        listItem.appendChild(nicknameElem);
        listItem.appendChild(textElem);
        listItem.appendChild(deleteButton);
        commentsList.appendChild(listItem);
      });
    });
}
