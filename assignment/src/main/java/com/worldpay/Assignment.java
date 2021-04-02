package com.worldpay;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment {
	static WebDriver driverChrome;
	private static String userName;
	private static String password;
	private static String product;
	private static WebDriverWait wait;
	
	@BeforeTest
	public void browser() {
		
		String path = System.getProperty("user.dir");
		path+="\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driverChrome = new ChromeDriver();
		driverChrome.manage().window().maximize();
		driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverChrome.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void screenShot(String imageName){
		
		String screenshotPath = System.getProperty("user.dir");
		screenshotPath += "\\src\\resources\\Screenshot";
		try {
			TakesScreenshot	 takeScreenshot =(TakesScreenshot)driverChrome;
			File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(screenshotPath+"\\"+imageName+".png"));
			System.out.println(screenshotPath+"\\"+imageName+".png");
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1,enabled=true)
	public void readCredentials()
    {
        try{
        	String filePath = System.getProperty("user.dir"); //"C:\\Users\\HP\\Desktop\\Automation\\CredentialsData.xlsx"
        	filePath += "\\src\\resources\\CredentialsData.xlsx";
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    userName = cell.getStringCellValue();
                    password = cellIterator.next().getStringCellValue();
                    product = cellIterator.next().getStringCellValue();
                }
            }
            fileInputStream.close();
        }
        catch (IOException ioException)
        {
        	ioException.printStackTrace();
        }
    }
	
	@Test(priority=2,enabled=true)
	public void login() {
		driverChrome.get("https://www.flipkart.com");
		
		driverChrome.findElement(By.xpath("//input[@class=\"_2zrpKA _1dBPDZ\"]")).sendKeys(userName);
		driverChrome.findElement(By.xpath("//input[@class=\"_2zrpKA _3v41xv _1dBPDZ\"]")).sendKeys(password);
		
		
		driverChrome.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")).click();
		
		//checks if logged in successfully using Assert
		Assert.assertTrue(driverChrome.findElement(By.xpath("//a[@href=\"/account/login?ret=/\"]")).isDisplayed()); 
	}
	
	@Test(priority=3,enabled=true)
	public void searchAndSelectProduct(){
		
		screenShot("login");									//screenShot after login
		try {
			Screen screen = new Screen();
			Pattern searchBox = new Pattern("C:\\Users\\HP\\Desktop\\Automation\\SearchBox.JPG");
			screen.type(searchBox, product);//"pilot pen"
			driverChrome.findElement(By.xpath("//button[@class='vh79eN']")).click();
			driverChrome.findElement(By.className("_2cLu-l")).click();
		}
		catch(SikuliException sikuliException)
		{
			sikuliException.printStackTrace();			//handles sikuliException and findfailed exception both
		}
		
	}

	@Test(priority=4,enabled=true)
	public void switchToTab() {
	
	String currentWindow = driverChrome.getWindowHandle();
	System.out.println(currentWindow);
	
	Set<String> windows = driverChrome.getWindowHandles();
	
	for(String s:windows) {
		System.out.println(s);
		driverChrome.switchTo().window(s);
	}
	
	driverChrome.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
}
	
	@Test(priority=5,enabled=true)
	public void placeOrder() {

		screenShot("product");									//screenShot selected product
		WebElement element = driverChrome.findElement(By.xpath("//button[@class=\"_2AkmmA iwYpF9 _7UHT_c\"]"));
		Actions actions = new Actions(driverChrome);
		actions.moveToElement(element).click().build().perform();
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driverChrome;			//scroll to select payment option
		jse.executeScript("scroll(0,800)");
		
		wait=new WebDriverWait(driverChrome,15);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"_2AkmmA _2Q4i61 _7UHT_c\"]")));
		ele.click();
		
		}
	
}
