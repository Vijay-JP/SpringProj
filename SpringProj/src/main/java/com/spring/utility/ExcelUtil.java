package com.spring.utility;

import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelUtil {

	public static String getCellDateValue(Cell cell) {
		String strCellValue = null;
		if (DateUtil.isCellDateFormatted(cell)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			strCellValue = dateFormat.format(cell.getDateCellValue());
		}
		return strCellValue;
	}
}
