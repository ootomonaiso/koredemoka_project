package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// モデル部分 
@Entity // これはエンティティ
@Table(name = "log") // テーブル名を "log" に設定
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDの自動入力
    private Long id;

    // リクエストされたuserとcontentの代入ゾーン
    private String user; 
    private String content;

    // 血と汗と涙とコーヒーのゲッターとセッター
    // ゲッダーは完ぺきで究極のデータベースデータをゲットします
    // セッターはデータベースにGoシュートします
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
