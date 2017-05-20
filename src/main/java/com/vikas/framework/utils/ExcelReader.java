package com.vikas.framework.utils;



import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.io.Resources;

/** Read excel data files */
public class ExcelReader implements IDataProvider{

	String fileName;
	String sheetName;

	public ExcelReader(String filename) {
		this.fileName = filename;
		sheetName = null;
	}

	public ExcelReader(String filename, String sheetName) {
		this.fileName = filename;
		this.sheetName = sheetName;
	}
	public Object[][] getData() {
		Object[][] data = null;
		XSSFWorkbook w = null;
		try {
			System.out.println("Input file Path:" + Resources.getResource(fileName).getPath());
			w = new XSSFWorkbook(Resources.getResource(fileName).openStream());
			XSSFSheet sheet = null;
			if (sheetName == null) {
				sheet = w.getSheetAt(0);
			} else {
				sheet = w.getSheet(sheetName);
			}
			data = new Object[sheet.getLastRowNum()][];

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				// Row by row
				XSSFRow r = sheet.getRow(i);
				data[i - 1] = new Object[r.getLastCellNum()];
				for (int j = 0; j < r.getLastCellNum(); j++) {
					Cell c = r.getCell(j);
					data[i - 1][j] = getObjectValue(c);
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {

				}
			}
		}
		return data;
	}

	private Object getObjectValue(Cell c) {
		Object value = null;
		if (c == null) {
			return null;
		}
		switch (c.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = c.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_ERROR:
			value = "";
			break;
		case Cell.CELL_TYPE_FORMULA:
			value = c.getCellFormula();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			value = c.getNumericCellValue();
			if (HSSFDateUtil.isCellDateFormatted(c)) {
				value = c.getDateCellValue();
			}
			break;
		case Cell.CELL_TYPE_STRING:
			value = c.getStringCellValue();
			break;
		default:
			System.err.println("Error Cell Data type:" + c.getCellType() + " is not defined");
			break;
		}
		return value;
	}

}
