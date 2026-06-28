package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {

	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/commondata.json"));
		JSONObject jObj = (JSONObject) obj;
		// json file reader is used for the
		// proper file input stream
		String value = jObj.get(key).toString();
		return value;
	}

	
	
	public String getDataFromExcel(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb = WorkbookFactory.create(new FileInputStream("./src/test/resources/testScriptData.xlsx"));
		Sheet sh = wb.getSheet(sheetName);//user will this sheet name
		Row row = sh.getRow(rowIndex); //user will tell
		Cell cell = row.getCell(cellIndex);
		String cellValue = cell.getStringCellValue();
		wb.close();
		return cellValue;
	} 
	
	

}