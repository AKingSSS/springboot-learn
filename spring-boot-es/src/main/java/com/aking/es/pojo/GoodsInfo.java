package com.aking.es.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @ClassName GoodsInfo
 * @Description
 * indexName索引名称 可以理解为数据库名 必须为小写
 * 不然会报 org.elasticsearch.indices.InvalidIndexNameException 异常
 * type 类型 可以理解为表名
 * @Author yk
 * @Date 2020/7/6 9:34
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * testgoods，小写， 类似数据库，goods类似数据库中的表
 */
@Document(indexName = "testgoods",type = "goods")
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = -233887536894620653L;
    private Long id;
    private String name;
    private String description;
}
