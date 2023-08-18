package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ArticleController {
  @Autowired
  private ArticleRepository articleRepository;

  @GetMapping("/articles/new")
  public String newArticleForm() {
    return "articles/new";
  }

  @PostMapping("/articles/create")
  public String createArticle(ArticleForm form) {
    log.info(form.toString());
    Article article = form.toEntity();
    log.info(article.toString());
    Article saved = articleRepository.save(article);
    log.info(saved.toString());
    return "";
  }

  @GetMapping("/articles/{id}")
  public String show(@PathVariable long id, Model model) {
    log.info("id = " + id);
    Article articleEntity = articleRepository.findById(id).orElse(null);
    log.info(articleEntity.toString());
    model.addAttribute("article", articleEntity);
    return "articles/show";
  }
}
