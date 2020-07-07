package com.aking.es.service;

import com.aking.es.pojo.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @ClassName GoodsService
 * @Description
 * @Author yk
 * @Date 2020/7/6 9:40
 * @Version 1.0
 **/
@Component
public interface GoodsService extends ElasticsearchRepository<GoodsInfo, Long> {
}
