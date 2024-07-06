package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static FileOutputStream fos;
	public static XSSFCellStyle style;

	public static int getRowCount(String xlfile, String xlsheet) throws Throwable {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getPhysicalNumberOfRows();
		wb.close();
		fis.close();
		return rowCount;

	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws Throwable {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		int cellCount = ws.getRow(rownum).getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;

	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		XSSFRow row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		// cell = ws.getRow(rownum).getCell(cellnum);

		String data;
		try {
			// cell.toString();
			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(cell);
		} catch (Exception e) {
			data = " ";
		}

		wb.close();
		fis.close();
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String Data)
			throws IOException {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(Data);
		fos = new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}

	public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws Exception {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fos = new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}

	public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws Exception {
		fis = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fos = new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();

	}
}
