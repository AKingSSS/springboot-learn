package com.aking.mongodb.Service;

import com.aking.mongodb.domin.Article;

/**
 *@ClassName ArticleService
 *@Description
 *@Author yangkang
 *@Date 2020/9/14 17:07
 *@Version 1.0
 **/
public interface ArticleService {
    void saveDemo(Article article);

    void removeDemo(Long id);

    void updateDemo(Article article);

    Article findDemoById(Long id);
}
