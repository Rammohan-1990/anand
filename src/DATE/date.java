package DATE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class date {

	public static void main(String[] args) throws InterruptedException {
     String month ="September 2019";
     String day  = "20";
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venky\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
     WebDriver driver=new ChromeDriver();
     driver.get("https://www.phptravels.net/m-flights");
     driver.findElement(By.xpath("//*[@id=\"flights\"]/form/div[3]/div/input")).click();   
   Thread.sleep(3000);
  
   while(true) {
	   
  String text = driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/thead/tr[1]/th[2]")).getText();
  
  if(text.equals(month)) {
	break;
  }
   
   
   else {
	   driver.findElement(By.xpath("/html/body/div[15]/div[1]/table/thead/tr[1]/th[3]")).click();
  }
   
   }
 driver.findElement(By.xpath("/html[1]/body[1]/div[15]/div[1]/table[1]/tbody[1]/tr/td[contains(text(),"+day+")]")).click();
   
   
   
     
	
	}
}


