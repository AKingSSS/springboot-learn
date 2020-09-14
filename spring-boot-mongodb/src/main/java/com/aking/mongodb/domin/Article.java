package com.aking.mongodb.domin;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *@ClassName Article
 *@Description
 *@Author yk
 *@Date 2020/9/14 16:00
 *@Version 1.0
 **/
@Data
@Document(collection="col")
@NoArgsConstructor
public class Article {
    @Id
    private String id;
    private String title;
    private String description;
    private String by;
    private String url;
    private String tags;
    private String likes;
}
