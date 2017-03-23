package com.testone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateSheet {

	public  void create() throws IOException
	{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("One");
		XSSFRow row;
		HashMap<String,Object[]> empinfo=new HashMap<String,Object[]>();
		empinfo.put("1", new Object[]{"tara","cts","100"});
		empinfo.put("2", new Object[]{"prasad","cts","101"});
		Set<String> keys=empinfo.keySet();
		int rowid=0;
		for(String key:keys)
		{
			row=sheet.createRow(rowid++);
			Object[] objarr=empinfo.get(key);
			int cellid=0;
			for(Object obj:objarr)
			{
				Cell cell=row.createCell(cellid++);
				cell.setCellValue((String)obj);
				
			}
			
			
		}
		FileOutputStream fos=new FileOutputStream(new File("one.xlsx"));
		workbook.write(fos);
		fos.close();
		System.out.println("file created successfully");
		
	}
	public void read() throws IOException
	{
		FileInputStream fis=new FileInputStream("one.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFRow row;
		Iterator<Row> itr=sheet.iterator();
		while(itr.hasNext())
		{
			row=(XSSFRow)itr.next();
			Iterator<Cell> citr=row.cellIterator();
			while(citr.hasNext())
			{
				Cell cell=(Cell)citr.next();
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				{if(cell.getColumnIndex()==1)
				{
					System.out.println(cell.getStringCellValue());
				}
				}
			}
		}
		fis.close();
		System.out.println("File read succesfully");
	}
	public static void main(String args[]) throws IOException
	{
		CreateSheet cs=new CreateSheet();
		cs.create();
		System.out.println("end of create method");
		cs.read();
	}
	
}
