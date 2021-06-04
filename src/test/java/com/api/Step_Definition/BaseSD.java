package com.api.Step_Definition;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.api.Base.Constant;
import com.api.Base.SingleTonClass;
import com.api.ExcelUtils.ExcelUtils;
import com.mongodb.util.Util;

public class BaseSD extends Util {

	SingleTonClass singletonClass = SingleTonClass.getInstance();
	private String value = null;

	// Date format
	public String getCurrentDateDBFormat() {
		SimpleDateFormat formDate = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		String strDate = formDate.format(new Date());
		strDate = strDate + ".000";
		return strDate;
	}

	// This method is a common method for Get Property
	public String getProperty(String text) {
		value = null;
		try {
			value = singletonClass.getProp(text);
		} catch (Exception e) {
			System.out.println("Unable to  get Text :" + e.toString());
		}
		return value;
	}

	// This method is a common method for Set Property
	public String setProperty(String property, String text) {
		value = null;
		try {
			singletonClass.getProp().setProperty(property, text);
		} catch (Exception e) {
			System.out.println("Unable to  get Text :" + e.toString());
		}
		return value;
	}

	// This method is a common method for update Property
	public String updateProperty(String property, String text) {
		value = null;
		try {
			singletonClass.updateProp(property, text);
		} catch (Exception e) {
			System.out.println("Unable to  get Text :" + e.toString());
		}
		return value;
	}

	// Initiate excel sheet
	public void initExcelSheet(String sheetName) {
		try {
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, sheetName);
		} catch (Exception e) {
			System.out.println("Unable to  initiate the excelsheet" + e.toString());
		}
	}

	// Get excel value
	public String getExcelValue(String columnData, String rowData, int columnIndex) throws Exception {
		value = null;
		try {
			ArrayList<String> data = ExcelUtils.getData(columnData, rowData);
			value = data.get(columnIndex);
		} catch (Exception e) {
			System.out.println("Unable to  get Text :" + e.toString());
		}
		return value;

	}

}
