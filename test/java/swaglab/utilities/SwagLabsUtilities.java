package swaglab.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class SwagLabsUtilities {

	public static WebDriver driver;
	
	@BeforeClass
	public static void launchBrowser() throws IOException {
		
		driver = new ChromeDriver();
		driver.get(getData("Sheet1",1,0));
		driver.manage().window().maximize();
		takeScreenShot();
	}
	
	@AfterClass
	public static void logoutAndCloseBrowser() throws InterruptedException {				
		quitdriver();	
	}
	
	public static String getData(String sheetName,int rowNmum,int colunmNum) {

		String data = null;
		try {
		File file = new File("C:\\Users\\meena\\eclipse-workspace\\SwagLabsApplication\\target\\SwagLabsData.xlsx");		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		Workbook book = new XSSFWorkbook(fileInputStream);		
		Cell cell = book.getSheet(sheetName).getRow(rowNmum).getCell(colunmNum);	
		CellType cellType = cell.getCellType();
				
		switch(cellType) {
		
		case STRING:
			
			data = cell.getStringCellValue();
			
		case NUMERIC:
			
			if(DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				data = simpleDateFormat.format(cell.getDateCellValue());				
			}
			else
			{
			    double numericCellValue = cell.getNumericCellValue();	
			    long value = (long)numericCellValue;
				data = BigDecimal.valueOf(value).toString();
			}
		default:
			break;
					}
	
		}catch(Exception e) {}
		
		return data;		
	}
	

	public static void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("C:\\Users\\meena\\eclipse-workspace\\AdactinHotelApp\\ErrorImage\\" + System.currentTimeMillis() + ".png"));
	}

	public static String pagetext(WebElement element) {
		return element.getText();
	}

	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static void clickButton(WebElement element) {
		element.click();
	}

	public static void selectFromDropDown(WebElement element, String text) {

		Select select = new Select(element);
		element.click();
		select.selectByValue(text);
	}
	
	public static void HandleAlertMessage(String response) {
		if(response.equalsIgnoreCase("ok"))
		driver.switchTo().alert().accept();
		else if(response.equalsIgnoreCase("cancel"))
			driver.switchTo().alert().dismiss();
	}

	
	
	public static String getValueFor(String key) throws IOException {
		File file = new File("C:\\Users\\meena\\eclipse-workspace\\AdactinHotelApp\\Data\\Data.properties");
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader);
		return properties.getProperty(key);
	}
	
	public static void quitdriver(){
		driver.quit();
	}

	
		
		

}
