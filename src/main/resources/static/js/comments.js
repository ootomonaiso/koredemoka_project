// 新規追加js
$(document).ready(function() {
    // ページ読み込み時に過去のコメントを取得して表示
    loadPastComments();

    // コメント投稿ボタンのクリックイベント
    $('#add-comment').on('click', function() {
        console.log('コメント投稿ボタンがクリックされました');
        addComment();
    });

    // お問い合わせはこちらボタンのクリックイベント
    $('#open-popup').on('click', function() {
        $('#popup').css('display', 'block');
    });

    // ポップアップの閉じるボタンのクリックイベント
    $('.close-button').on('click', function() {
        $('#popup').css('display', 'none');
    });
});

// 過去のコメントをサーバーから取得して表示する関数
function loadPastComments() {
    $.ajax({
        url: "/api/past-comments", // コメント取得APIのエンドポイント
        type: "GET", // リクエストの種類（GETリクエスト）
        success: function(comments) {
            // リクエスト成功時の処理
            console.log("過去のコメントを取得しました:", comments);
            var pastCommentsList = $('#past-comments-list'); // コメントリストのDOM要素を取得
            pastCommentsList.empty(); // 既存のコメントをクリア
            comments.forEach(function(comment) {
                // 各コメントをリストアイテムとして追加
                var listItem = $('<li>').text(comment.user + ': ' + comment.content);
                pastCommentsList.append(listItem);
            });
        },
        error: function(xhr, status, error) {
            // リクエスト失敗時の処理
            console.error("過去のコメントを取得できませんでした:", status, error);
        }
    });
}

// 新しいコメントをサーバーに追加する関数
function addComment() {
    var nickname = $('#nickname-input').val(); // ニックネームの入力値を取得
    var text = $('#comment-input').val(); // コメントの入力値を取得

    // コメントデータをJSON形式で作成
    var commentData = {
        user: nickname,
        content: text
    };

    $.ajax({
        type: 'POST', // リクエストの種類（POSTリクエスト）
        url: '/api/add-comment', // コメント追加APIのエンドポイント
        data: JSON.stringify(commentData), // JSON形式に変換して送信
        contentType: 'application/json', // コンテンツタイプをJSONに設定
        success: function() {
            // コメント追加成功時の処理
            console.log('コメントが追加されました');
            loadPastComments(); // 過去コメントを再読み込み
            $('#nickname-input').val(''); // 入力フォームをクリア
            $('#comment-input').val(''); // 入力フォームをクリア
        },
        error: function() {
            // コメント追加失敗時の処理
            alert('コメントの投稿に失敗しました。');
        }
    });
}
