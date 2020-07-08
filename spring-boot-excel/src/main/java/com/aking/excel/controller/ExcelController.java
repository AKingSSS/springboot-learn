package com.aking.excel.controller;

import com.aking.excel.utils.DateUtil;
import com.aking.excel.utils.FileUtil;
import com.aking.excel.utils.excel.ExcelData;
import com.aking.excel.utils.excel.ExcelReader;
import com.aking.excel.utils.excel.ExcelUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExcelController
 * @Description
 * @Author yk
 * @Date 2020/7/8 11:50
 * @Version 1.0
 **/
@Slf4j
@RequestMapping("/excel")
@RestController
public class ExcelController {

    /**
     * 单个sheet的导出
     *
     * @param response
     * @return
     */
    @GetMapping("/exportRecord.do")
    public String exportRecord(HttpServletResponse response) {
        ExcelData data = getData();
        try {
            ExcelUtil.exportExcel(response, "data.xlsx", data);
        } catch (Exception e) {
            log.error("exportRecord error:[{}]", e);
            return "fail";
        }
        return "success";
    }

    /**
     * 多sheet的导出
     *
     * @param response
     * @return
     */
    @GetMapping("/exportRecord2.do")
    public String exportRecord2(HttpServletResponse response) {
        List<ExcelData> data = getData2();
        try {
            ExcelUtil.exportExcelList(response, "data.xlsx", data);
        } catch (Exception e) {
            log.error("exportRecord error:[{}]", e);
            return "fail";
        }
        return "success";
    }

    /**
     * 读取excel文件
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/importExcel.do")
    public String importExcel(HttpServletRequest request,
                              @RequestParam("file") MultipartFile file) throws Exception {
        String path = uploadFile(file,request.getSession().getServletContext().getRealPath("upload/"));
        ExcelReader excelReader = ExcelReader.getExcelReader(path);
        List<Map<String, String>> list =
                ExcelUtil.getExcelListMap(excelReader, "测试列表");
        return new Gson().toJson(list);
    }

    private String uploadFile(MultipartFile file,String CurrentProjectPath) throws Exception {

        String fileName = DateUtil.dateToString(new Date(),"yyyyMMddHHmmss") + file.getOriginalFilename();

        FileUtil.uploadFile(file.getBytes(), CurrentProjectPath, fileName);

        return CurrentProjectPath + fileName;
    }

    private ExcelData getData() {
        ExcelData data = new ExcelData();
        data.setName("测试列表");
        List<String> titles = new ArrayList();
        titles.add("客户姓名");
        titles.add("手机号");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        for (int i = 0; i < 10; i++) {
            List<Object> row = new ArrayList();
            row.add("测试" + i);
            row.add("1880000000" + i);
            rows.add(row);
        }
        data.setRows(rows);
        return data;
    }

    private List<ExcelData> getData2() {
        List<ExcelData> excelDataList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ExcelData data = new ExcelData();
            data.setName("测试列表");
            List<String> titles = new ArrayList();
            titles.add("客户姓名");
            titles.add("手机号");
            data.setTitles(titles);
            List<List<Object>> rows = new ArrayList();
            for (int j = 0; j < 10; j++) {
                List<Object> row = new ArrayList();
                row.add("测试" + j);
                row.add("1880000000" + j);
                rows.add(row);
            }
            data.setRows(rows);
            excelDataList.add(data);
        }
        return excelDataList;
    }
}
