package com.aking.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName MyAnalysisEventListener
 * @Description
 * @Author yk
 * @Date 2020/7/8 17:26
 * @Version 1.0
 **/
@Slf4j
public class MyAnalysisEventListener extends AnalysisEventListener<List<Object>> {
    @Override
    public void invoke(List<Object> data, AnalysisContext analysisContext) {
        log.info("解析一条数据开始：[{}]", new Gson().toJson(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("解析一条数据完成");
    }
}
