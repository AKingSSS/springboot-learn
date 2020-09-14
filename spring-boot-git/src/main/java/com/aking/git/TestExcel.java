package com.aking.git;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 种路路
 **/
public class TestExcel {
    public static void main(String[] args) throws IOException {
        String filePath = "a.xlsx";
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        List<User> list = ExcelImportUtil.importExcel(new File(filePath), User.class, params);
        Map<String, ExportUser> map = new HashMap<>(1024);
        for (User user : list) {
            String id = user.getId();
            if (map.get(id) == null) {
                ExportUser exportUser = new ExportUser();
                exportUser.setId(id);
                exportUser.setName(user.getName());
                exportUser.setSubordinate("");
                exportUser.setEqual("");
                exportUser.setSuperior("");
                if ("上级".equals(user.getRelation())) {
                    exportUser.setSuperior(user.getRelationName());
                }
                if ("同级".equals(user.getRelation())) {
                    exportUser.setEqual(user.getRelationName());
                }
                if ("下级".equals(user.getRelation())) {
                    exportUser.setSubordinate(user.getRelationName());
                }
                map.put(user.getId(), exportUser);
            } else {
                ExportUser mapUser = map.get(id);
                if ("上级".equals(user.getRelation())) {
                    if("".equals(mapUser.getSuperior())){
                        mapUser.setSuperior(user.getRelationName());
                    }else{
                        mapUser.setSuperior(mapUser.getSuperior() + "," + user.getRelationName());
                    }
                }
                if ("同级".equals(user.getRelation())) {
                    if("".equals(mapUser.getEqual())){
                        mapUser.setEqual(user.getRelationName());
                    }else{
                        mapUser.setEqual(mapUser.getEqual() + "," + user.getRelationName());
                    }
                }
                if ("下级".equals(user.getRelation())) {
                    if("".equals(mapUser.getSubordinate())){
                        mapUser.setSubordinate(user.getRelationName());
                    }else{
                        mapUser.setSubordinate(mapUser.getSubordinate() + "," + user.getRelationName());
                    }
                }
            }
        }

        //参数配置
        ExportParams exportParams = new ExportParams();
        //此处设置ExcelType HSSF为excel2003版本，XSSF为excel2007版本
        exportParams.setType(ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, ExportUser.class, map.values());
        String excelName = "b.xlsx";
        FileOutputStream out = new FileOutputStream(excelName);
        workbook.write(out);
        out.flush();
        out.close();
    }


}
