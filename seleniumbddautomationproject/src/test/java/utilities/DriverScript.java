package utilities;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DriverScript {
	KeywordActions keyworkActions;
	public static void main(String args[]) throws IOException, InterruptedException {
		DriverScript driverScript=new DriverScript();
		driverScript.runTest("testdata/KeywordDrivenDataDummy.xlsx", "Module1", "TC3");
	}


	public DriverScript() {
		keyworkActions=new KeywordActions();
	}
	public void runTest(String excelSheetPath,String sheetName,String testCaseIdValue) throws IOException, InterruptedException {
		XSSFWorkbook workbook=new XSSFWorkbook(excelSheetPath);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()+1;

		for(int i=1;i<rowCount;i++) {
			XSSFRow row=sheet.getRow(i);
			String testCaseId=getCellValue(row, 0);
			if(!testCaseId.equalsIgnoreCase(testCaseIdValue)) {
				continue;
			}
			String stepDescription=getCellValue(row, 1);
			String locatorType=getCellValue(row, 2);
			String locatorValue=getCellValue(row, 3);
			String testData=getCellValue(row, 4);
			String action=getCellValue(row, 5);
			System.out.println(testCaseId+" - "+stepDescription+"-"+locatorType+"-"+locatorValue+"-"+testData+"-"+action);
			keyworkActions.performAction(locatorType, locatorValue, testData, action);
			
		}
		workbook.close();
	}

	public String getCellValue(XSSFRow row,int columnIndex) {
		String value="";
		if(row==null || row.getCell(columnIndex)==null) {
			return "";
		}
		else {
			value=row.getCell(columnIndex).getStringCellValue();
		}
		return value;
	}
}
