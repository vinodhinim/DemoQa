package selenium_assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class MainDriver {
	private static final TimeUnit Seconds = null;
	public static WebDriver Driver;
	public static String flag;
public static void main(String[] args) throws InterruptedException, Throwable, Exception, IOException{

	Keywords_DemoQa obj=new Keywords_DemoQa();
	
	obj.invokeBrowser();
	//obj.NavigateToBrowserwindows();
	//obj.BrowserWindowmethods();
	//SCM.Selectmenu("", "MRS.");
	//obj.selectmethods();
	obj.FormsPracticeautomated();
	//obj.methodsWindows();
	
	//obj.profilebookstore();
	
	
		/*String ExpectedResult = obj1.getAlltabledata();
		if(ExpectedResult.contains("Vega")) {
			System.err.println("Case Matched");
		}
		*/

	
	}

}
