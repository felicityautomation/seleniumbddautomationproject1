package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static void main(String[] args) throws IOException {
		Object[][] myData=ExcelUtility.readFromExcelSheet("testdata/mytestdata.xlsx","LoginData");
		
	}
	
	
	
	public static Object[][] readFromExcelSheet(String excelSheetFilePath,String sheetName) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook(excelSheetFilePath);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int rowsCount=sheet.getPhysicalNumberOfRows();
		System.out.println("Rows count:="+rowsCount);

		XSSFRow row=sheet.getRow(0);
		int columnCount=row.getPhysicalNumberOfCells();
		
		Object[][] data=new Object[rowsCount-1][columnCount];

		System.out.println("Columns count:="+columnCount);
		for(int i=1;i<rowsCount;i++) {
			XSSFRow myRow=sheet.getRow(i);
			for(int j=0;j<columnCount;j++) {
				String value=myRow.getCell(j).getStringCellValue();
				//System.out.println(value);
				data[i-1][j]=value;
			}
		}
		
		workbook.close();
		return data;
	}

}
