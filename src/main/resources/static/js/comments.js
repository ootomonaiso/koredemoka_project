$(document).ready(function() {
    // ページ読み込み時に過去のコメントを取得して表示
    loadPastComments();

    // コメント投稿ボタンのクリックイベント
    $('#add-comment').on('click', function() {
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

function loadPastComments() {
    $.ajax({
        url: "/api/past-comments",
        type: "GET",
        success: function(comments) {
            // 成功時の処理
            console.log("過去のコメントを取得しました:", comments);
            var pastCommentsList = $('#past-comments-list');
            pastCommentsList.empty();
            comments.forEach(function(comment) {
                var listItem = $('<li>').text(comment.user + ': ' + comment.content);
                pastCommentsList.append(listItem);
            });
        },
        error: function(xhr, status, error) {
            // エラー時の処理
            console.error("過去のコメントを取得できませんでした:", status, error);
        }
    });
}

// コメント投稿する関数
function addComment() {
    var nickname = $('#nickname-input').val();
    var text = $('#comment-input').val();

    $.ajax({
        type: 'POST',
        url: '/api/add-comment',
        data: {
            nickname: nickname,
            text: text
        },
        success: function() {
            // コメント追加成功時の処理
            loadPastComments(); // 過去コメントを再読み込み
            $('#nickname-input').val(''); // 入力フォームをクリア
            $('#comment-input').val(''); // 入力フォームをクリア
        },
        error: function() {
            alert('コメントの投稿に失敗しました。');
        }
    });
}
