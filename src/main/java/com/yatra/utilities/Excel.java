package com.yatra.utilities;


import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.yatra.baseClass.PageBaseClass;


public class Excel extends PageBaseClass {

	public void writeCabInfo(String[][] info) throws IOException {

		// opening workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream("Cab Details.xlsx");
		XSSFSheet sheet = workbook.createSheet("List of Cabs");
		XSSFSheet sheet1 = workbook.createSheet("Lowest price");

		Row[] row = new Row[info.length + 1];
		Cell[][] cell = new Cell[row.length][];

		try {
			setInfo(sheet, info, row, cell);
		}

		catch (Exception e) {
			// TODO: handle exception
		}

		int r = findLowPrice(info);

		try {
			setInfo(sheet1, info, row, cell, r);
		}

		catch (Exception e) {
			// TODO: handle exception
		}
		workbook.write(fos);
		fos.close();
		workbook.close();
		System.out.println("File exported successfully");

	}

	public void setInfo(XSSFSheet sheet, String info[][], Row[] row, Cell[][] cell) {

		setHeader(sheet, row, cell);
		for (int i = 1; i < row.length; i++) {

			row[i] = sheet.createRow(i);
			cell[i] = new Cell[info[i - 1].length];

			for (int j = 0; j < cell[i].length; j++) {
				cell[i][j] = row[i].createCell(j);
				if (j == 1) {
					cell[i][j].setCellValue(info[i - 1][j].substring(1, info[i - 1][j].length() - 1));
				} else
					cell[i][j].setCellValue(info[i - 1][j]);

			}
		}

	}

	public void setInfo(XSSFSheet sheet, String info[][], Row[] row, Cell[][] cell, int r) {

		setHeader(sheet, row, cell);
		row[1] = sheet.createRow(1);
		cell[1] = new Cell[info[r].length];

		for (int j = 0; j < cell[1].length; j++) {
			cell[1][j] = row[1].createCell(j);
			if (j == 1) {
				cell[1][j].setCellValue(info[r][j].substring(1, info[r][j].length() - 1));
			} else
				cell[1][j].setCellValue(info[r][j]);

		}
	}

	public void setHeader(XSSFSheet sheet, Row[] row, Cell[][] cell) {
		row[0] = sheet.createRow(0);
		cell[0] = new Cell[3];

		cell[0][0] = row[0].createCell(0);
		cell[0][0].setCellValue("Vendor Name");

		cell[0][1] = row[0].createCell(1);
		cell[0][1].setCellValue("Car Name");

		cell[0][2] = row[0].createCell(2);
		cell[0][2].setCellValue("Price");
	}

	public int findLowPrice(String info[][]) {
		int lp = 0, r = 0;

		for (int i = 0; i < info.length; i++) {
			String str = info[i][2].substring(1);
			String str1[] = str.split(",");
			String strPrice = str1[0] + str1[1];

			if (i == 0) {
				lp = Integer.parseInt(strPrice);

				r = i;
				continue;
			}

			if (lp > Integer.parseInt(strPrice)) {
				lp = Integer.parseInt(strPrice);
				r = i;
			}

		}
		return r;
	}
}