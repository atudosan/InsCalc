package reusableUtilities;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperation {
	
	String filePath;
	
	//specifing location in Constructor Method
	public ExcelOperation() throws Exception {
		filePath = System.getProperty("user.dir")+ConfigPropExtractData.getPropValueByKey("testDataLocation");
	}
	
	public HashMap<String, String> getTestDataIntoMap(int rowNumer) throws Exception {
		// creating a object of File class
		File testDataFile = new File(filePath);
		Workbook wb = WorkbookFactory.create(testDataFile);
		
		//specifing sheet name
		Sheet sh = wb.getSheet("InsurancePremium");
		
		//read data row by row in put into a map
		HashMap<String, String> hm = new HashMap<>();
		
		//get data from CELLs in our hash map
		//sh.getRow(0).getCell(i).toString;  ----> will be the KEY
		//sh.getRow(rowNumer).getCell(i).toString;  ----> will be the VALUE
		
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNumer).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNumer).getCell(i).toString());
		}
		
		return hm;		
		
	}
	
}
