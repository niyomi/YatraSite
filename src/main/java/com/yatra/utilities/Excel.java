package com.yatra.utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	File file;
	FileOutputStream fos=null;

	public Excel(String path) throws FileNotFoundException
	{
		file=new File(path);					//assigning path to file
		fos= new FileOutputStream(file);		//creating fileoutputstream object to write the file at given path
	}
	
	public void readData(String sheetName,String data[][]) throws IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook();					//creating object of workbook(excel file)
		XSSFSheet sheet = wb.createSheet(sheetName);			//creating sheet in that workbook with given sheet name
		
		Map<String,Object[]> dataSet = new TreeMap<String, Object[]>();
		dataSet.put("1", new Object[] {"Vendor Name","Car Name", "Price"});					//inputting data to write in excel
		dataSet.put("2", new Object[] {data[0][0],data[0][1],data[0][2]});
		dataSet.put("3", new Object[] {data[1][0],data[1][1],data[1][2]});
		dataSet.put("4", new Object[] {data[2][0],data[2][1],data[2][2]});
		dataSet.put("5", new Object[] {data[3][0],data[3][1],data[3][2]});
		//dataSet.put("6", new Object[] {data[4][0],data[4][1]});
		
		//Iterate over data
		Set<String> set=dataSet.keySet();
		int rowNum=0;
		for(String key:set)
		{
			//Creating Row
			Row row=sheet.createRow(rowNum++);
			Object[] dataset = dataSet.get(key);
			
			int colNum=0;
			for(Object value:dataset)
			{
				
				//Creating Column
				Cell cell=row.createCell(colNum++);
				if(value instanceof String)
				{
					cell.setCellValue((String)value);		//entering value into cell
				}
				else if(value instanceof Integer)
				{
					cell.setCellValue((Integer)value);		//entering value into cell
				}
			}
		}
		
		//Write file on given path
		try {
			wb.write(fos);						//write into excel file
			System.out.println("Excel File Created");
			wb.close();
			fos.close();			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		

	}

}