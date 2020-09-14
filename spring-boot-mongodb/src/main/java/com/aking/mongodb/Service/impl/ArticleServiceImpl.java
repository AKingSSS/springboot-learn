package com.aking.mongodb.Service.impl;

import com.aking.mongodb.Service.ArticleService;
import com.aking.mongodb.domin.Article;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@ClassName ArticleServiceImpl
 *@Description
 *@Author yk
 *@Date 2020/9/14 17:07
 *@Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveDemo(Article article) {
        mongoTemplate.save(article);
    }

    @Override
    public void removeDemo(Long id) {
        mongoTemplate.remove(id);
    }

    @Override
    public void updateDemo(Article article) {
        Query query = new Query(Criteria.where("id").is(article.getId()));

        Update update = new Update();
        update.set("title", article.getTitle());
        update.set("description", article.getDescription());
        update.set("by", article.getBy());
        update.set("url", article.getUrl());

        mongoTemplate.updateFirst(query, update, Article.class);
    }

    @Override
    public Article findDemoById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        Article article = mongoTemplate.findOne(query, Article.class);
        return article;
    }
}
