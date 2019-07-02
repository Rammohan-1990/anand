package broken_links;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bridj.cpp.std.list;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handling_broken_chinlinks {


	public static void main(String[] args) throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Venky\\Downloads\\DRIVERS\\chromedriver_win32\\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	     driver.get("https://developer.here.com/documentation");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	     
	List <WebElement> attr= driver.findElements(By.tagName("a"));
	System.out.println(attr.size());
	
	for (int i=0;i<attr.size();i++) {
		//BY USING href attribute we can get url of requarid link
	WebElement element=	attr.get(i);
	
	 String url=element.getAttribute("href");
	 verifylinkActive(url);
	 }
	}

	 
	 @SuppressWarnings("static-access")
	public static void verifylinkActive (String linkurl) {
	 
	 try{
	 
	 URL url= new URL(linkurl);
	 //create a connection using urlobject 'link'
	 HttpURLConnection http =(HttpURLConnection)url.openConnection();
	 Thread.sleep(2000);
	 
	http.connect();
	
	if (http.getResponseCode()==200)
	{
		System.out.println(linkurl +"  - "+http.getResponseMessage());
	}
	
    if (http.getResponseCode()==http.HTTP_NOT_FOUND)
    {
    	System.out.println(linkurl +"   -   "+ http.HTTP_NOT_FOUND);
    }
    
	 }catch(Exception e) {
    	
    }
	 }
}
	 
		
	 


