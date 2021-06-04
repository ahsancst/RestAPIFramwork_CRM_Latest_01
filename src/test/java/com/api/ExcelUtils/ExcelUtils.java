package com.api.ExcelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.Base.Constant;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static MissingCellPolicy xRow;

	

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheet name as Arguments to this method
	public static void setExcelFile(String path, String SheetName) throws Exception {

		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			int sheets = ExcelWBook.getNumberOfSheets();
			for (int i = 0; i < sheets; i++) {
				if (ExcelWBook.getSheetName(i).equalsIgnoreCase(SheetName)) {
					ExcelWSheet = ExcelWBook.getSheetAt(i);
				}
			}

		} catch (Exception e) {
			throw (e);
		}
	}

	public static ArrayList<String> getData(String columnData, String rowData) throws Exception {
		int k = 0;
		int column = 0;


		ArrayList<String> a = new ArrayList<String>();

		Iterator<Row> rows = ExcelWSheet.rowIterator();
		Row firstRow = rows.next();

		Iterator<Cell> firstCells = firstRow.cellIterator();
		while (firstCells.hasNext()) {
			Cell cellValue = firstCells.next();
			
			if (cellValue.getStringCellValue().trim().equalsIgnoreCase(columnData)) {
				column = k;
			}
			k++;
		}

		while (rows.hasNext()) {
			Row rowValue = rows.next();
			
			if (rowValue.getCell(column).getStringCellValue().trim().equalsIgnoreCase(rowData)) {
				Iterator<Cell> cv = rowValue.cellIterator();
				while (cv.hasNext()) {
					Cell value = cv.next();
					
					if (value.getCellType()==CellType.STRING) {
						a.add(value.getStringCellValue());		
					} else {
						String convertValue = NumberToTextConverter.toText(value.getNumericCellValue());
						a.add(convertValue);
					}
					
				}
			break;	
			}			
		}
		return a;
	}

	// This method is to read the test data from the Excel cell
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	// This method is to write in the Excel cell
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}

	}

	public static String getData(String index) throws Exception {
		try {
			String cellValue = null;
			DataFormatter dataFormatter = new DataFormatter();

			Iterator<Row> rows = ExcelWSheet.rowIterator();
			while (rows.hasNext()) {
				Row row = rows.next();

				// Now let's iterate over the columns of the current row
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					cellValue = dataFormatter.formatCellValue(cell);
					if (cellValue == index) {
						System.out.print(cellValue + "\t");
						break;
					}
				}
			}
			return cellValue;
		} catch (Exception e) {
			return "";
		}

	}

}
