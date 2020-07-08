package com.aking.excel.utils.excel;

import com.aking.excel.utils.CollectionUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author Y10003453
 */
public class ExcelUtil {

    /**
     * 获取excel中的数据
     *
     * @param path
     * @param sheetName
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public static List<ArrayList<String>> getExcelList(String path, String sheetName) throws Exception {
        ExcelReader excelReader = ExcelReader.getExcelReader(path);
        Sheet sheet = excelReader.getSheet(sheetName);
        int size = sheet.getLastRowNum() + 1;
        List<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>(size);
        Row row = null;
        for (int i = 0; i < size; i++) {
            row = sheet.getRow(i);
            int cellSize = row.getLastCellNum();
            ArrayList<String> rowList = new ArrayList<String>(cellSize);
            for (int j = 0; j < cellSize; j++) {
                Cell cell = row.getCell(j);
                if (null == cell)
                    continue;
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String cellValue = ExcelReader.getStringCellValue(row, j);
                rowList.add(cellValue.trim());
            }
            resultList.add(rowList);
        }
        return resultList;
    }

    /**
     * 获取excel中的数据,第一行为map中的key
     *
     * @param path
     * @param sheetName
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getExcelListMap(String path, String sheetName) throws Exception {
        List<ArrayList<String>> list = getExcelList(path, sheetName);
        if (CollectionUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        List<String> title = list.get(0);
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>(list.size());
        for (int i = 1; i < list.size(); i++) {
            Map<String, String> item = new HashMap<String, String>();
            for (int j = 0; j < title.size(); j++) {
                if (list.get(i).size() > j)
                    item.put(title.get(j), list.get(i).get(j));
                else
                    item.put(title.get(j), "");
            }
            mapList.add(item);
        }
        return mapList;
    }

    /**
     * 获取excel中的数据,第一行为map中的key
     *
     * @param excelReader
     * @param sheetName
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public static List<Map<String, String>> getExcelListMap(ExcelReader excelReader, String sheetName) throws Exception {
        Sheet sheet = excelReader.getSheet(sheetName);

        int size = sheet.getLastRowNum() + 1;
        List<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>(size);
        Row row = null;
        for (int i = 0; i < size; i++) {
            row = sheet.getRow(i);
            int cellSize = row.getLastCellNum();
            ArrayList<String> rowList = new ArrayList<String>(cellSize);
            for (int j = 0; j < cellSize; j++) {
                Cell cell = row.getCell(j);
                if (null == cell)
                    continue;
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String cellValue = ExcelReader.getStringCellValue(row, j);
                rowList.add(cellValue.trim());
            }
            resultList.add(rowList);
        }

        if (CollectionUtil.isEmpty(resultList)) {
            return Collections.emptyList();
        }
        List<String> title = resultList.get(0);
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>(resultList.size());
        for (int i = 1; i < resultList.size(); i++) {
            Map<String, String> item = new HashMap<String, String>();
            for (int j = 0; j < title.size(); j++) {
                if (resultList.get(i).size() > j)
                    item.put(title.get(j), resultList.get(i).get(j));
                else
                    item.put(title.get(j), "");
            }
            mapList.add(item);
        }
        return mapList;
    }


    // 导出

    public static void exportExcel(HttpServletResponse response, String fileName, ExcelData data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        exportExcel(data, response.getOutputStream());
    }

    public static void exportExcelList(HttpServletResponse response, String fileName, List<ExcelData> data) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        exportExcelList(data, response.getOutputStream());
    }

    private static void exportExcelList(List<ExcelData> datas, ServletOutputStream out) throws Exception{
        XSSFWorkbook wb = new XSSFWorkbook();
       try {
           for(int i=0;i<datas.size();i++){
               String sheetName = datas.get(i).getName();
               if (null == sheetName)sheetName = "Sheet"+i;
               XSSFSheet sheet = wb.createSheet();
               writeExcel(wb, sheet, datas.get(i));
               wb.setSheetName(i, sheetName);
           }
           wb.write(out);
       }finally {
           wb.close();
       }
    }

    public static void exportExcel(ExcelData data, OutputStream out) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        try {
            String sheetName = data.getName();
            if (null == sheetName) {
                sheetName = "Sheet1";
            }
            XSSFSheet sheet = wb.createSheet(sheetName);
            writeExcel(wb, sheet, data);

            wb.write(out);
        } finally {
            wb.close();
        }
    }

    private static void writeExcel(XSSFWorkbook wb, Sheet sheet, ExcelData data) {

        int rowIndex = 0;

        rowIndex = writeTitlesToExcel(wb, sheet, data.getTitles());
        writeRowsToExcel(wb, sheet, data.getRows(), rowIndex);
        autoSizeColumns(sheet, data.getTitles().size() + 1);

    }

    private static int writeTitlesToExcel(XSSFWorkbook wb, Sheet sheet, List<String> titles) {
        int rowIndex = 0;
        int colIndex = 0;

        Font titleFont = wb.createFont();
        titleFont.setFontName("simsun");
        titleFont.setBold(true);
        titleFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFont(titleFont);

        Row titleRow = sheet.createRow(rowIndex);
        colIndex = 0;

        for (String field : titles) {
            Cell cell = titleRow.createCell(colIndex);
            cell.setCellValue(field);
            cell.setCellStyle(titleStyle);
            colIndex++;
        }

        rowIndex++;
        return rowIndex;
    }

    private static int writeRowsToExcel(XSSFWorkbook wb, Sheet sheet, List<List<Object>> rows, int rowIndex) {
        int colIndex = 0;

        Font dataFont = wb.createFont();
        dataFont.setFontName("simsun");
        dataFont.setColor(IndexedColors.BLACK.index);

        XSSFCellStyle dataStyle = wb.createCellStyle();
        dataStyle.setFont(dataFont);

        for (List<Object> rowData : rows) {
            Row dataRow = sheet.createRow(rowIndex);
            colIndex = 0;

            for (Object cellData : rowData) {
                Cell cell = dataRow.createCell(colIndex);
                if (cellData != null) {
                    cell.setCellValue(cellData.toString());
                } else {
                    cell.setCellValue("");
                }

                cell.setCellStyle(dataStyle);
                colIndex++;
            }
            rowIndex++;
        }
        return rowIndex;
    }

    private static void autoSizeColumns(Sheet sheet, int columnNumber) {

        for (int i = 0; i < columnNumber; i++) {
            int orgWidth = sheet.getColumnWidth(i);
            sheet.autoSizeColumn(i, true);
            int newWidth = (int) (sheet.getColumnWidth(i) + 100);
            if (newWidth > orgWidth) {
                sheet.setColumnWidth(i, newWidth);
            } else {
                sheet.setColumnWidth(i, orgWidth);
            }
        }
    }
}
