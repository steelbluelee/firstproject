package com.example.firstproject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstproject.entity.Article;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ArticleSerivceTest {
  @Autowired
  ArticleService articleService;

  @Test
  void index() {
    List<Article> articles = articleService.index();

    Article a = new Article(9999991L, "가가가가", "1111");
    Article b = new Article(9999992L, "나나나나", "1111");
    Article c = new Article(9999993L, "다다다다", "1111");
    List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

    assertEquals(expected.toString(), articles.toString());

  }
}
