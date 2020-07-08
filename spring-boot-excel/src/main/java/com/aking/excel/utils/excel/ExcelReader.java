package com.aking.excel.utils.excel;


import com.aking.excel.utils.DateUtil;
import com.aking.excel.utils.StringUtil;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author Y10003453
 */
public class ExcelReader {

	private String filePath;

	private InputStream inStream;

	private Workbook workbook;

	public static ExcelReader getExcelReader(String filePath) {
		ExcelReader excelReader = new ExcelReader();
		excelReader.filePath = filePath;
		return excelReader;
	}

	public static String getStringCellValue(Row row, int columnIndex) throws Exception {
		if (null == row) {
			throw new Exception("excel.ExcelReader.getStringCellValue:row is null.");
		}
		Cell cell = row.getCell(columnIndex);
		if (null == cell) {
			throw new Exception(
					"excel.ExcelReader.getStringCellValue:cell(index=" + columnIndex + ") is null.");
		}
		try {
			return cell.getStringCellValue();
		} catch (Exception e) {
			throw new Exception("cell(index=" + columnIndex + ")", e);
		}
	}

	public static Long getLongCellValue(Row row, int columnIndex) throws Exception {
		if (null == row) {
			throw new Exception("excel.ExcelReader.getLongCellValue:row is null.");
		}
		Cell cell = row.getCell(columnIndex);
		if (null == cell) {
			throw new Exception(
					"excel.ExcelReader.getLongCellValue:cell(index=" + columnIndex + ") is null.");
		}
		try {
			double cellValue = cell.getNumericCellValue();
			return (long) cellValue;
		} catch (Exception e) {
			throw new Exception("cell(index=" + columnIndex + ")", e);
		}

	}

	public static Long getLongCellValueFromString(Row row, int columnIndex) throws Exception {
		if (null == row) {
			throw new Exception("excel.ExcelReader.getLongCellValue:row is null.");
		}
		Cell cell = row.getCell(columnIndex);
		if (null == cell) {
			throw new Exception(
					"excel.ExcelReader.getLongCellValue:cell(index=" + columnIndex + ") is null.");
		}
		try {
			String cellValue = cell.getStringCellValue();
			return Long.parseLong(cellValue);
		} catch (Exception e) {
			throw new Exception("cell(index=" + columnIndex + ")", e);
		}
	}

	public static Integer getIntegerCellValue(Row row, int columnIndex) throws Exception {
		if (null == row) {
			throw new Exception(".excel.ExcelReader.getLongCellValue:row is null.");
		}
		Cell cell = row.getCell(columnIndex);
		if (null == cell) {
			throw new Exception(
					"excel.ExcelReader.getLongCellValue:cell(index=" + columnIndex + ") is null.");
		}
		try {
			double cellValue = cell.getNumericCellValue();
			return (int) cellValue;
		} catch (Exception e) {
			throw new Exception("cell(index=" + columnIndex + ")", e);
		}
	}

	public static Float getFloatCellValue(Row row, int columnIndex) throws Exception {
		if (null == row) {
			throw new Exception("excel.ExcelReader.getFloatCellValue:row is null.");
		}
		Cell cell = row.getCell(columnIndex);
		if (null == cell) {
			throw new Exception(
					"excel.ExcelReader.getFloatCellValue:cell(index=" + columnIndex + ") is null.");
		}
		String cellValueStr = cell.getStringCellValue();
		if (StringUtil.isEmpty(cellValueStr)) {
			return null;
		}
		try {
			return Float.parseFloat(cellValueStr);
		} catch (Exception e) {
			throw new Exception("cell(index=" + columnIndex + ")", e);
		}
	}

	public static Double getDoubleCellValue(Row row, int columnIndex) throws Exception {
		if (null == row) {
			throw new Exception("excel.ExcelReader.getDoubleCellValue:row is null.");
		}
		Cell cell = row.getCell(columnIndex);
		if (null == cell) {
			throw new Exception(
					"excel.ExcelReader.getDoubleCellValue:cell(index=" + columnIndex + ") is null.");
		}
		String cellValueStr = cell.getStringCellValue();
		if (StringUtil.isEmpty(cellValueStr)) {
			return null;
		}
		try {
			return Double.parseDouble(cellValueStr);
		} catch (Exception e) {
			throw new Exception("cell(index=" + columnIndex + ")", e);
		}
	}

	public static Date getDateCellValue(Row row, int columnIndex, String format) throws Exception {
		if (null == row) {
			throw new Exception("excel.ExcelReader.getDateCellValue:row is null.");
		}
		Cell cell = row.getCell(columnIndex);
		if (null == cell) {
			throw new Exception(
					"excel.ExcelReader.getDateCellValue:cell(index=" + columnIndex + ") is null.");
		}
		String cellValueStr = cell.getStringCellValue();
		if (StringUtil.isEmpty(cellValueStr)) {
			return null;
		}
		return com.aking.excel.utils.DateUtil.stringToDate(cellValueStr, null == format ? DateUtil.Format_1 : format);
	}

	public Workbook getWorkbook() throws Exception {
		if (null != inStream) {
			inStream.close();
		}
		inStream = new FileInputStream(filePath);
		workbook = WorkbookFactory.create(inStream);
		return workbook;
	}

	public Sheet getSheet(String sheetName) throws Exception {
		if (null == workbook) {
			getWorkbook();
		}
		if (null == workbook) {
			throw new Exception("workbook is null.");
		}

		Sheet sheet = workbook.getSheet(sheetName);
		return sheet;
	}

	public void close() {
		if (null != workbook) {
			try {
				workbook.close();
			} catch (IOException e) {
			}
		}
		if (null != inStream) {
			try {
				inStream.close();
			} catch (IOException e) {
			}
		}
	}

}
