package com.aking.mongodb.Service.impl;

import com.aking.mongodb.BaseTest;
import com.aking.mongodb.Service.ArticleService;
import com.aking.mongodb.domin.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceImplTest extends BaseTest {
    @Autowired
    private ArticleService articleService;

    @Test
    public void testSaveDemo() {
        for (int i = 10; i < 2; i++) {
            Article article = new Article();
            article.setTitle("Spring Boot 中使用 MongoDB");
            article.setDescription("断剑重铸之日，其势归来之时");
            article.setBy("Python大星");
            article.setUrl("http://www.toutiao.com");
            articleService.saveDemo(article);
        }
    }

    @Test
    public void testRemoveDemo() {
    }

    @Test
    public void testUpdateDemo() {
    }

    @Test
    public void testFindDemoById() {
    }
}