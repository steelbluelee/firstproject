package com.example.firstproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleService {
  @Autowired
  private ArticleRepository articleRepository;

  public List<Article> index() {
    return articleRepository.findAll();
  }

  public Article show(long id) {
    return articleRepository.findById(id).orElse(null);
  }

  public Article create(ArticleForm dto) {
    Article article = dto.toEntity();
    return articleRepository.save(article);
  }

  public Article update(long id, ArticleForm dto) {
    Article newArticle = dto.toEntity();
    log.info("id: {}, article: {}", id, newArticle.toString());
    log.info(newArticle.toString());

    Article target = articleRepository.findById(id).orElse(null);
    if (target == null || id != newArticle.getId()) {
      log.info("잘못된 요청! id: {}, article: {}", id, newArticle.toString());
      return null;
    }

    Article updated = articleRepository.save(target.patch(newArticle));
    log.info("여기까지");
    return updated;
  }

  public Article delete(long id) {
    Article target = articleRepository.findById(id).orElse(null);
    if (target == null) {
      return null;
    }

    articleRepository.delete(target);
    return target;
  }
}
