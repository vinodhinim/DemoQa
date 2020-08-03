package selenium_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
	
public static WebDriver Driver;
	
	public void invokeBrowser() {
	
		//String DriverExecutablePath = "C:\\Users\\vinodhinima\\eclipse-workspace\\Demomaven\\src\\test\\resources\\geckoDriver.exe";
		
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinodhinima\\eclipse-workspace\\Demomaven\\src\\test\\resources\\geckodriver.exe");
				 //System.setProperty("webdriver.chrome.driver", driverExecutablePath);
				 
				// Create a new instance of the FireFox Driver 
				  Driver = new FirefoxDriver(); 
				 
				 // Storing the Application Url in the String variable 
				 String url = "https://demoqa.com/dragabble"; 
				 
				 //Launch the ToolsQA WebSite 
				 Driver.get(url); 
				// Driver.quit();
				 Driver.manage().window().maximize();
				 //Driver.manage().deleteAllCookies();
				 Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
	}
	
	public static void main() {
		
		System.out.println("hh");
		//Driver.findElement(By.xpath("//*[@id=\"dragBox\"]"));
	}

}
