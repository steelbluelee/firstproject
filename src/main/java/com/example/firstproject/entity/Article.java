package com.example.firstproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {
  @Id
  @GeneratedValue
  private Long id;
  @Column
  private String title;
  @Column
  private String content;

  public Article patch(Article newArticle) {
    return new Article(id,
        newArticle.title != null ? newArticle.title : this.title,
        newArticle.content != null ? newArticle.content : this.content);
  }
}
