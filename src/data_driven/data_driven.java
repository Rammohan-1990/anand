package data_driven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import XL_utility.XLUtils;

public class data_driven {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Venky\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe.");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		driver.manage().window().maximize();
		
		String path="E:\\sample.xlsx";
		XLUtils.setExcelFile(path, "sheet1");
		int rowcount = XLUtils.getRowCount(path, "sheet1");
		System.out.println(rowcount);
		
		for( int i=1;i<=rowcount;i++) {
			
		String firstname  = XLUtils.getCellData(path, "sheet1", i, 0);
		String lastname  = XLUtils.getCellData(path, "sheet1", i, 1);
		int phone   = Integer.parseInt(XLUtils.getCellData(path, "sheet1", i, 2));
	     String email  = XLUtils.getCellData(path, "sheet1", i, 3);
	     String address  = XLUtils.getCellData(path, "sheet1", i, 4);
	     String city  = XLUtils.getCellData(path, "sheet1", i, 5);
	     String state  = XLUtils.getCellData(path, "sheet1", i, 6);
	     int postal  =  Integer.parseInt(XLUtils.getCellData(path, "sheet1", i, 7));
	     String country  = XLUtils.getCellData(path, "sheet1", i, 8);
	     String username  = XLUtils.getCellData(path, "sheet1", i, 9);
	     String password  = XLUtils.getCellData(path, "sheet1", i, 10);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys( lastname );
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")).sendKeys(String.valueOf(phone ));
		driver.findElement(By.id("userName")).sendKeys( email);
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys( city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state );
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(String.valueOf(postal ));
		Select drp=new Select(driver.findElement(By.xpath("//select[@name='country']")));
		drp.selectByVisibleText( country);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username );
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@name='register']")).click();
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		}
		
		
	}

}
