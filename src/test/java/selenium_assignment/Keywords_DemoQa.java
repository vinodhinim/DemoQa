package selenium_assignment;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.Scrollable;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.maveric.core.driver.Driver;

public class Keywords_DemoQa {
	
	public static WebDriver Driver;
	 SeleniumCommonMethods SCM = new SeleniumCommonMethods();
	
	public void invokeBrowser() {
	
		//String DriverExecutablePath = "C:\\Users\\vinodhinima\\eclipse-workspace\\Demomaven\\src\\test\\resources\\geckoDriver.exe";
		
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\vinodhinima\\eclipse-workspace\\Demomaven\\src\\test\\resources\\geckodriver.exe");
				 //System.setProperty("webdriver.chrome.driver", driverExecutablePath);
				 
				// Create a new instance of the FireFox Driver 
				  Driver = new FirefoxDriver(); 
				 
				 // Storing the Application Url in the String variable 
				String url = "https://demoqa.com"; 
				 //String url = "https://demoqa.com/webtables";
				 
				 //Launch the ToolsQA WebSite 
				 Driver.get(url); 
				// Driver.quit();
				 Driver.manage().window().maximize();
				 //Driver.manage().deleteAllCookies();
				 Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
	}
	public static void NavigateToBrowserwindows(){
		Driver.findElement(By.xpath("//h5[.='Widgets']")).click();
		ScrollintoView("//span[.='Browser Windows']");
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.findElement(By.xpath("//span[.='Browser Windows']")).click();

		}
	public void BrowserWindowmethods() {
		Driver.findElement(By.xpath("//button[.='New Tab']")).click();
		SCM.WindowHandlerWindows();
		Driver.findElement(By.xpath("//button[.='New Window']")).click();
		SCM.WindowHandlerWindows();
		Driver.findElement(By.xpath("//button[.='New Window Message']")).click();
		SCM.WindowHandlerWindows();
	}
	
	public static void NavigateToAlerts(){
		Driver.findElement(By.xpath("//h5[.='Widgets']")).click();
		ScrollintoView("//span[.='Alerts']");
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.findElement(By.xpath("//span[.='Alerts']")).click();

		}
	public void Alertmethods() throws InterruptedException, AWTException {
		Driver.findElement(By.xpath("//*[@id='alertButton']"));
		SCM.getAlerts1();
		Driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
		SCM.getAlerts2();
		Driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
		SCM.getAlerts1();
		Driver.findElement(By.xpath("//*[@id='promtButton']")).click();
		SCM.getAlerts4();
		
	}
	
	
	public static void NavigateToSelect(){
		Driver.findElement(By.xpath("//h5[.='Alerts, Frame & Windows']")).click();
		ScrollintoView("//span[.='Select Menu']");
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.findElement(By.xpath("//span[.='Select Menu']")).click();

		}
	public void selectmethods() {
		SCM.Selectmenu("//select[.='Select Title']", "Mrs.");
		
	}
	
	
	public void Radio_Select1(){
		Driver.findElement(By.xpath("//span[.='Date Picker']")).click();
		String cellXpath = "///html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]";
		//ConditionalWait1(cellXpath, Text);
		Driver.findElement(By.xpath(cellXpath)).click();

	}

	
	public void Widgets() {
		Driver.findElement(By.xpath("//h5[.='Widgets']")).click();
		Scroll_window(Driver.findElement(By.xpath("//span[.='Date Picker']")));
		Driver.findElement(By.xpath("//span[.='Date Picker']")).click();
	}
	
	public void Scroll_window(WebElement Ele) {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		WebElement Element = Driver.findElement(By.xpath("//span[.='Date Picker']"));
		//WebElement Element = Driver.findElement(By.linkText("Date Picker"));
		 js.executeScript("arguments[0].scrollIntoView();", Element);
		 //js.executeScript("window.scrollBy(0,1000)");
		 Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
		 
		 
		/* public void Selection() {
			 Select oSelect =new Select(Driver.findElement(By.id("search-box")));
			 oSelect.selectByVisibleText("Blog");
		 } */
		
	public static void ScrollintoView(String EleXpath) {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		WebElement Element = Driver.findElement(By.xpath(EleXpath));
		//WebElement Element = Driver.findElement(By.linkText("Date Picker"));
		 js.executeScript("arguments[0].scrollIntoView();", Element);
		 //js.executeScript("window.scrollBy(0,1000)");
		 Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public static void takeSnapShot(WebDriver webDriver,String fileWithPath) throws Exception{
		//Convert web Driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webDriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
	
	
	public  void FormsPracticeautomated() throws Exception {
		takeSnapShot(Driver, "C:\\Users\\vinodhinima\\eclipse-workspace\\NewTAFUpdated\\reports\\HomePage.png");
		Driver.findElement(By.xpath("//h5[.='Forms']")).click();
		takeSnapShot(Driver, "C:\\Users\\vinodhinima\\eclipse-workspace\\NewTAFUpdated\\reports\\PracticeHomePage.png") ; 
		Driver.findElement(By.xpath("//span[.='Practice Form']")).click();
		SCM.enterfromfirstname(Driver).sendKeys("Vinu");
		SCM.WebEdit("//input[@id='lastName']", "mm");
		SCM.WebEdit("//input[@id='userEmail']", "vkd@gksd.com");
		Driver.findElement(By.xpath("//html/body/div/div/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div[1]/label")).click();
		SCM.WebEdit("//input[@id='userNumber']", "9865676789");
		Driver.findElement(By.xpath("//*[@id='dateOfBirthInput']")).click();
		Driver.findElement(By.xpath("//div[.='20']")).click();
		//ObjectRepo.DatePicker(Driver).click();
		SCM.WebEdit("//*[@id='subjectsInput']", "Chemistry");
		Driver.findElement(By.xpath("//*[@id='subjectsInput']")).sendKeys(Keys.ENTER);
		
		
		//Driver.findElement(By.xpath("///html/body/div/div/div/div[2]/div[2]/div[1]/form/div[6]/div[2]/div/div/div[1]")).sendKeys("Chemistry");
		Driver.findElement(By.xpath("//html/body/div/div/div/div[2]/div[2]/div[1]/form/div[7]/div[2]/div[2]/label")).click();
		//Driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']")).click();
		//Driver.findElement(By.xpath("//input[@id='uploadPicture']")).click();
		//Driver.findElement(By.xpath("//*[@id='uploadPicture']")).click();
		
		WebElement upload =Driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		upload.sendKeys("D:\\Aaa.bmp");
		SCM.WebEdit("//textarea[@id='currentAddress']", "90,Northen street, Town park");
		Thread.sleep(1000);
		ScrollintoView("//button[.='Submit']");
		
		//input[@id='react-select-3-input']
		Actions act =  new Actions(Driver);
		act.moveToElement(Driver.findElement(By.xpath("//input[@id='react-select-3-input']"))).click().perform();
		Driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys("Uttar Pradesh");
		Driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys(Keys.ENTER);
		
		Driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("Lucknow");
		Driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys(Keys.ENTER);
		takeSnapShot(Driver, "C:\\Users\\vinodhinima\\eclipse-workspace\\NewTAFUpdated\\reports\\BeforeFormsubmission.png") ; 
		
	/*	Select oSelect =new Select(Driver.findElement(By.xpath("//input[@id='react-select-3-input']")));
		 oSelect.selectByVisibleText("Uttar Pradesh");*/
		Driver.findElement(By.xpath("//button[.='Submit']")).click();
		Thread.sleep(3000);
		takeSnapShot(Driver, "C:\\Users\\vinodhinima\\eclipse-workspace\\NewTAFUpdated\\reports\\Formsubmission.png") ; 
		Driver.findElement(By.xpath("//button[.='Close']")).click();
		
	}
	
	public void methodsWindows() throws InterruptedException, AWTException {
		NavigateToSelect();
		selectmethods();
		
		/*Driver.findElement(By.xpath("//h5[.='Alerts, Frame & Windows']")).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//span[.='Browser Windows']")).click();
	ObjectRepo.WindowHandlerTabs(Driver).click();
	Thread.sleep(3000);
	Driver.findElement(By.xpath("//button[.='New Tab']")).click();
	ObjectRepo.WindowHandlerWindows();
	Driver.findElement(By.xpath("//button[.='New Window']")).click();
	ObjectRepo.WindowHandlerWindows();
	Driver.findElement(By.xpath("//button[.='New Window Message']")).click();
	ObjectRepo.WindowHandlerWindows();*/
	
	/*Thread.sleep(3000);
		Driver.findElement(By.xpath("//span[.='Frames']")).click();
		Driver.findElement(By.xpath("//span[.='Alerts']")).click();
		ObjectRepo.getAlerts1(Driver);
		Thread.sleep(3000);
		ObjectRepo.getAlerts2(Driver);
		Thread.sleep(3000);
		ObjectRepo.getAlerts3(Driver);
		Thread.sleep(3000);
		ObjectRepo.getAlerts4(Driver);
		Thread.sleep(3000);
		//interactions
		ScrollintoView("/html/body/div/div/div/div[2]/div[1]/div/div/div[5]/span/div/div[1]");
		
		//widgets
		Driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[4]/span/div/div[1]")).click();
		Driver.findElement(By.xpath("//span[.='Accordian']")).click();
		ObjectRepo.Accordian(Driver);
		ScrollintoView("//span[.='Progress Bar']");
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Driver.findElement(By.xpath("//span[.='Progress Bar']")).click();
		ObjectRepo.ProgressBar(Driver);
		ScrollintoView("//span[.='Tool Tips']");
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.findElement(By.xpath("//span[.='Tool Tips']")).click();
		ObjectRepo.ToolsTips(Driver);*/
		ScrollintoView("//span[.='Select Menu']");
		//Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.findElement(By.xpath("//span[.='Select Menu']")).click();
		SCM.Selectmenu("//select[.='Select Title']", "Mrs.");
		Driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[5]/span/div/div[1]")).click();
		Driver.findElement(By.xpath("//span[.='Droppable']")).click();
		ScrollintoView("//span[.='Forms']");
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SCM.DragnDrop(Driver);
		
		
	}
	
	
	public void loginbookstore() throws IOException, EncryptedDocumentException, InvalidFormatException {
		ScrollintoView("//span[.='login']");
		SCM.clickbookstore(Driver).click();
		SCM.clickloginbutton(Driver).click();
		SCM.enterusrname(Driver).sendKeys("Aravindsp");
		SCM.enterpass(Driver).sendKeys("Tweety95@");
		SCM.clickloginbookstore(Driver).click();
	}

public void profilebookstore() throws IOException, EncryptedDocumentException, InvalidFormatException{
	ScrollintoView("//h5[.='Book Store Application']");
	Driver.findElement(By.xpath("//h5[.='Book Store Application']")).click();
	ScrollintoView("//span[.='Login']");
	SCM.clickloginbookstore(Driver).click();
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	SCM.enterusrname(Driver).sendKeys("Vinodhini");
	SCM.enterpass(Driver).sendKeys("Vino@12345");
	SCM.clickloginbutton(Driver).click();
	Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	ScrollintoView("//span[.='Profile']");
	//ObjectRepo.clickprofile(Driver).click();
	SCM.clicklogoutbookstore(Driver).click();
}
	
}
 