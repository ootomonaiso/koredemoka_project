let comments = [];

// ローカルストレージからコメントを読み込む関数
function loadComments() {
  const savedComments = localStorage.getItem("comments");
  if (savedComments) {
    comments = JSON.parse(savedComments);
  }
}

// コメントをローカルストレージに保存する関数
function saveComments() {
  localStorage.setItem("comments", JSON.stringify(comments));
}

// 1ヶ月以上経過したコメントを削除する関数
function deleteOldComments() {
  const oneMonthAgo = new Date();
  oneMonthAgo.setMonth(oneMonthAgo.getMonth() - 1);
  comments = comments.filter(comment => new Date(comment.timestamp) > oneMonthAgo);
  saveComments();
  displayComments();
}

// コメントを削除する関数
function deleteComment(index) {
  comments.splice(index, 1);
  saveComments();
  displayComments();
}

// コメントを表示する関数
function displayComments() {
  const commentsList = document.getElementById("comments-list");
  commentsList.innerHTML = "";
  comments.forEach((comment, index) => {
    const listItem = document.createElement("li");
    listItem.className = "comment";

    const nicknameElem = document.createElement("div");
    nicknameElem.className = "nickname";
    nicknameElem.textContent = comment.nickname;

    const textElem = document.createElement("div");
    textElem.textContent = comment.text;

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "削除";
    deleteButton.onclick = () => deleteComment(index);

    listItem.appendChild(nicknameElem);
    listItem.appendChild(textElem);
    listItem.appendChild(deleteButton);
    commentsList.appendChild(listItem);
  });
}

// コメントを追加する関数
function addComment() {
  const nicknameField = document.getElementById("nickname-input");
  const inputField = document.getElementById("comment-input");
  const nickname = nicknameField.value.trim();
  const commentText = inputField.value.trim();

  if (nickname === "") {
    alert("ニックネームを入力してください。");
    return;
  }

  if (commentText === "") {
    alert("コメントを入力してください。");
    return;
  }

  const newComment = { nickname: nickname, text: commentText, timestamp: new Date().toISOString() };
  comments.push(newComment);
  saveComments();
  displayComments();
  nicknameField.value = "";
  inputField.value = "";
}

// ポップアップの表示・非表示を制御する関数
function togglePopup() {
  const popup = document.getElementById("popup");
  popup.style.display = popup.style.display === "flex" ? "none" : "flex";
}

// 初期化
loadComments();
deleteOldComments();
displayComments();

// ポップアップボタンと閉じるボタンにイベントリスナーを追加
document.getElementById("open-popup").addEventListener("click", togglePopup);
document.querySelector(".close-button").addEventListener("click", togglePopup);
