package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GouletPens extends ExcelIntegration {

	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
	
		System.setProperty("webdriver.chrome.driver", "E:\\Shabeer Works\\SHABEER\\Project\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.gouletpens.com/");
		driver.manage().window().maximize();
		TakesScreenshot tk = (TakesScreenshot) driver;
		File s = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(s);
		File d = new File ("E:\\Shabeer Works\\SHABEER\\Project\\Screenshots\\gouletpens.jpeg");
		FileUtils.copyFile(s, d);
		Actions a = new Actions (driver);
		WebElement btnShop = driver.findElement(By.xpath("(//button[text()='Shop By Brand'])[1]"));
		a.moveToElement(btnShop).perform();
		
		WebElement fountainPens = driver.findElement(By.xpath("(//img[@class='category-list__image lozad'])[1]"));
		a.contextClick(fountainPens).perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//driver.findElement(By.xpath("//img[@alt='Close form']")).click();
		Thread.sleep(3000);
		String parentWindowId = driver.getWindowHandle();
		System.out.println("parent window id" +parentWindowId);
		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println("all window id" +allWindowId);
		for (String childWindow : allWindowId) {
			if(!parentWindowId.equals(allWindowId)) {
				driver.switchTo().window(childWindow);
			}
		}
		Thread.sleep(9000);
		//driver.findElement(By.xpath("//img[@alt='Close form']")).click();
		File s1 = tk.getScreenshotAs(OutputType.FILE);
		File d1 = new File("E:\\Shabeer Works\\SHABEER\\Project\\Screenshots\\fountainpens.png");
		FileUtils.copyFile(s1, d1);
		driver.findElement(By.xpath("(//a[@href='/collections/all-fountain-pens'])[2]")).click();
		driver.navigate().to("https://www.gouletpens.com/");
		driver.navigate().to("https://www.gouletpens.com/collections/all-fountain-pens");
		driver.findElement(By.xpath("//img[@alt='Pilot Metropolitan Fountain Pen - Black Plain']")).click();
		File s2 = tk.getScreenshotAs(OutputType.FILE);
		File d2 = new File("E:\\Shabeer Works\\SHABEER\\Project\\Screenshots\\pilotpen.jpeg");
		FileUtils.copyFile(s2, d2);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[contains(@class, 'grid__item quantity--grid-container  medium--six-tenths four-fifths ')]")).click();
		
		WebElement addToCartItem = driver.findElement(By.xpath("(//h1[contains(@class, Pilot)])[1]"));
		String penName = addToCartItem.getText();
		System.out.println("pen name is" +penName);
		WebElement addToCartValue = driver.findElement(By.xpath("(//span[contains(text(), '$18.99')])[1]"));
		String penValue = addToCartValue.getText();
		System.out.println("pen value is" +penValue);
		File loc = new File("E:\\Shabeer Works\\SHABEER\\Project\\Excel\\write.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet("GouletPens");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue(penName);
		Row row1 = sheet.createRow(1);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue(penValue);
		FileOutputStream o = new FileOutputStream(loc);
		w.write(o);
		System.out.println("wrote successfully");
		
		driver.get("https://www.landsend.com/");
		driver.findElement(By.xpath("(//input[@class='search-input'])[1]")).sendKeys(getData(0, 0));
		driver.findElement(By.xpath("(//i[@class='fa fa-search'])[1]")).click();
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	private static CharSequence getData(Row row, Cell cell) {
		// TODO Auto-generated method stub
		return null;
	}
}