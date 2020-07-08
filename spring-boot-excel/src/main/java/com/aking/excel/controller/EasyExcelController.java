package com.aking.excel.controller;

import com.aking.excel.listener.MyAnalysisEventListener;
import com.aking.excel.pojo.Customer;
import com.aking.excel.utils.DateUtil;
import com.aking.excel.utils.FileUtil;
import com.aking.excel.utils.excel.ExcelReader;
import com.aking.excel.utils.excel.ExcelUtil;
import com.aking.excel.utils.excel.easy.EasyExcelUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EasyExcelController
 * @Description
 * @Author yk
 * @Date 2020/7/8 15:04
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/easyExcel")
public class EasyExcelController {

    /**
     * 单个sheet导出excel
     *
     * @param response
     * @return
     */
    @GetMapping("/exportExcel.do")
    public String exportExcel(HttpServletResponse response) throws IOException {
        //以下信息从数据库中查出
        List<Customer> customers = getCustomers();
        try {
            String fileName = "excelInfo";
            String sheetName = "sheet1";
            EasyExcelUtil.writeExcel(response, customers, fileName, sheetName, Customer.class);
        } catch (Exception e) {
            log.error("模板下载失败", e);
        }
        return "success";
    }

    /**
     * 一行行读取excel文件
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/importExcel.do")
    public String importExcel(HttpServletRequest request,
                              @RequestParam("file") MultipartFile file) throws Exception {
        String path = uploadFile(file,request.getSession().getServletContext().getRealPath("upload/"));
        InputStream in = new FileInputStream(new File(path));
        Sheet sheet = new Sheet(1,0);
        EasyExcelFactory.readBySax(in,sheet,new MyAnalysisEventListener());
        return "success";
    }

    private String uploadFile(MultipartFile file,String CurrentProjectPath) throws Exception {

        String fileName = DateUtil.dateToString(new Date(),"yyyyMMddHHmmss") + file.getOriginalFilename();

        FileUtil.uploadFile(file.getBytes(), CurrentProjectPath, fileName);

        return CurrentProjectPath + fileName;
    }

    /**
     * 模拟数据
     * @return
     */
    private List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = Customer
                    .builder()
                    .mobile("1880000000" + i)
                    .name("测试" + i)
                    .build();
            customers.add(customer);
        }
        return customers;
    }
}
