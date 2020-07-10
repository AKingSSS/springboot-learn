package com.aking.excel.controller;

import com.aking.excel.pojo.PersonExportVo;
import com.aking.excel.utils.excel.easy.ExcelEasyPoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EasyPoiController
 * @Description
 * @Author yk
 * @Date 2020/7/9 10:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/easyPoi")
@Slf4j
public class EasyPoiController {
    /**
     * 导出
     *
     * @param response
     */
    @GetMapping(value = "/exportExcel.do")
    public void exportExcel(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        List<PersonExportVo> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PersonExportVo personVo = PersonExportVo.builder()
                    .name("测试" + i)
                    .phoneNumber("1880000000" + i)
                    .imageUrl("https://www.baidu.com")
                    .username("测试" + i)
                    .build();
        }
        log.debug("导出excel所花时间：" + (System.currentTimeMillis() - start));
        ExcelEasyPoiUtil.exportExcel(personList, "员工信息表", "员工信息", PersonExportVo.class, "员工信息", response);
    }
}
