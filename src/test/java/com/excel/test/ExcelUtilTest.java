package com.excel.test;

import com.excel.lib.util.Xls_Reader;

public class ExcelUtilTest {
	
	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Selenium_Workspace\\ExcelDataReadWriteApachePOI\\src\\main\\java\\com\\excel\\lib\\util\\SampleExcel.xlsx");
		String sheetname = "login";
		
		String data = reader.getCellData(sheetname, 0, 2);
		System.out.println(data);
		
		int rowcount = reader.getRowCount(sheetname);
		System.out.println("Total number of rows = "+rowcount);
		
		//reader.addColumn(sheetname, "status");
		
		if(! reader.isSheetExist("Time")) {
			reader.addSheet("Time");
		}
		
		//reader.setCellData(sheetname, "status", 2, "PASS");
		String d = reader.getCellData(sheetname, "password", 5);
		System.out.println(d);
		
		int columncount = reader.getColumnCount(sheetname);
		System.out.println("Total number of column = "+columncount);
		
		//reader.removeColumn("Time", 0);
		
		//For saving numeric value as a string use ' before value
		System.out.println(reader.getCellData("Regsitration", "phonenumber", 2));
		System.out.println(reader.getCellData("Regsitration", "age", 2));
		
		//To read formula based data - for example: =SUM(10+30)
		System.out.println(reader.getCellData("Regsitration", "phonenumber", 3));
		System.out.println(reader.getCellData("Regsitration", "age", 3));
		
		//For saving boolean value as a string use ' before value
		System.out.println(reader.getCellData("Regsitration", "phonenumber", 4));
	}
}
	
