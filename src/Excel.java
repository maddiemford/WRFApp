import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static void main(String[] args) throws IOException, InvalidFormatException {
		
		// Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = null;
        try {
        	workbook =  WorkbookFactory.create(new File("C:\\Users\\0wner\\Desktop\\ClientFollowUpLedger1.xlsx"));
        } catch (FileNotFoundException e) {
        	System.out.println("Please close the FollowUpLedger to use this tool.");
        	System.exit(0);
        }
              
        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
        
        Sheet ledger = null;
        
        // 1. You can obtain a sheetIterator and iterate over it
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
            if (sheet.getSheetName().equals("Sheet1")) {
            	ledger = sheet;
            }
        }
        
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
       
        // 2. Or you can use a for-each loop to iterate over the rows and columns
        System.out.println("Getting the Date column");
        Row row = ledger.getRow(0);
        Cell dates = row.getCell(10);
        System.out.println(dataFormatter.formatCellValue(dates));
        
        System.out.println("Tasks for 8/1/19");
        for (Row r : ledger) {
        	Cell date = r.getCell(10);
        	if (dataFormatter.formatCellValue(date).equals("8/1/19")) {
        		System.out.println(r.getRowNum());
        		System.out.println("Work to be done: " + dataFormatter.formatCellValue(r.getCell(9)));
        	}
        }

	}

}
