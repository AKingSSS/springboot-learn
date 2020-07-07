package com.aking.es.controller;

import com.aking.es.pojo.GoodsInfo;
import com.aking.es.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassName GoodsController
 * @Description
 * @Author yk
 * @Date 2020/7/6 9:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 增
     * 1594015390005
     * @return
     */
    @GetMapping("save")
    public String save() {
        long id = System.currentTimeMillis();
        GoodsInfo goodsInfo = new GoodsInfo(id,
                "商品" + id, "测试商品");
        log.info("id = [{}]", id);
        goodsService.save(goodsInfo);
        return "success";
    }

    /**
     * 删
     *
     * @param id
     * @return
     */
    @GetMapping("delete")
    public String delete(long id) {
        goodsService.deleteById(id);
        return "success";
    }

    /**
     * 改
     *
     * @param id
     * @param name
     * @param description
     * @return
     */
    @GetMapping("update")
    public String update(long id, String name, String description) {
        GoodsInfo goodsInfo = new GoodsInfo(id,
                name, description);
        goodsService.save(goodsInfo);
        return "success";
    }

    /**
     * 查
     *
     * @param id
     * @return
     */
    @GetMapping("getOne")
    public GoodsInfo getOne(long id) {
        Optional<GoodsInfo> goodsInfo = goodsService.findById(id);
        return goodsInfo.get();
    }
}
