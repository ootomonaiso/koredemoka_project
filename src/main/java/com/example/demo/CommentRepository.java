package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// モデル部分
// JPAリポジトリ使ってSQL書かないで済んだからsecurity面で安心安全だと思う
// Spring data JPAのインターフェース使用
// エンティティクラス=Comment comment.javaが本体
// ID= Long
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
