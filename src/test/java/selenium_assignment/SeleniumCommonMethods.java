package selenium_assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumCommonMethods {
		public static WebDriver Driver;
		private static WebElement element;
		
		/*ic static void WebEdit(String xpath, String val) {
			Driver.findElement(By.xpath(xpath)).click();
			Driver.findElement(By.xpath(xpath)).sendKeys(val);	
			
		}*/
		
		public static void WebEdit(String xpath, String val) {
			Driver.findElement(By.xpath(xpath)).click();
			Driver.findElement(By.xpath(xpath)).sendKeys(val);	
			
		}
		public void Radio_Select1(){
			Driver.findElement(By.xpath("//span[.='Date Picker']")).click();
			String cellXpath = "///html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]";
			//ConditionalWait1(cellXpath, Text);
			Driver.findElement(By.xpath(cellXpath)).click();

		}
		public void Radio_Select2(){
			Driver.findElement(By.xpath("//span[.='Date Picker']")).click();
			String cellXpath = "///html/body/div/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]";
			//ConditionalWait1(cellXpath, Text);
			Driver.findElement(By.xpath(cellXpath)).click();	

		}
		
	    public static void WindowHandlerWindows() {
			String MainWindow = Driver.getWindowHandle();		
    		
	        // To handle all new opened window.				
	            Set<String> s1 = Driver.getWindowHandles();		
	        Iterator<String> i1 = s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    Driver.switchTo().window(ChildWindow);	                                                                                                           
	                    Driver.close(); 
	            }      
			
		}
	        Driver.switchTo().window(MainWindow);	
			//return element;
			
		}
		

public static void getAlerts1() throws InterruptedException {
	Thread.sleep(3000);
	
	Alert simpleAlert = ((WebDriver) Driver).switchTo().alert();
    simpleAlert.accept();
 //Driver.switchTo().alert().getText();
 

}
public static void getAlerts2() throws InterruptedException, AWTException {
	Thread.sleep(5000);
	
	Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_SPACE);
    robot.keyRelease(KeyEvent.VK_SPACE);
Thread.sleep(2000);
}

public static WebElement getAlerts3(WebDriver Driver) throws InterruptedException {
	element = Driver.findElement(By.xpath("//*[@id='confirmButton']"));
	element.click();
	Thread.sleep(3000);
	
	Alert simpleAlert = ((WebDriver) Driver).switchTo().alert();
    simpleAlert.accept();
 
return element;
}
		

public static void getAlerts4() throws InterruptedException {
	Thread.sleep(3000);
	
	Alert simpleAlert = ((WebDriver) Driver).switchTo().alert();
	
	Driver.switchTo().alert().sendKeys("Vino");
    simpleAlert.accept();

}

public static WebElement Accordian(WebDriver Driver) throws InterruptedException {
	element = Driver.findElement(By.xpath("//*[@id='section1Heading']"));
	element.click();
	Thread.sleep(1000);
	//Driver.switchTo().frame(Driver.findElement(By.xpath("//*[@id='section2Heading']")));
	Driver.switchTo().defaultContent();
	Thread.sleep(1000);
	
	new Actions(Driver).click().build().perform();
	element = Driver.findElement(By.xpath("//*[@id='section2Heading']"));
	element.click();
	Thread.sleep(1000);
	Driver.switchTo().defaultContent();
	Thread.sleep(1000);
	
	new Actions(Driver).click().build().perform();
	
	Thread.sleep(1000);
	
	
	return element;
}

public static WebElement ProgressBar(WebDriver Driver) throws InterruptedException {
	element = Driver.findElement(By.xpath("//*[@id='startStopButton']"));
	element.click();
	
	 Thread.sleep(5000);
	element.click();
	return element;
	
}

public static WebElement ToolsTips(WebDriver Driver) {
	element =Driver.findElement(By.xpath("//*[@id='toolTipButton']"));
	element.click();
	return element;
}

public static void Selectmenu(String xpath, String val) {
	//element = Driver.findElement(By.name("Select"));
	//Select value = new Select (Driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[2]/div/div/div/div[1]/div[1]")));
	//value.selectByVisibleText("Group 1, option 2");
	
	Select one = new Select(Driver.findElement(By.xpath(xpath)));
			one.selectByVisibleText(val);
	
	//select[.='Select Title']"))); Mrs



}

public static WebElement DragnDrop(WebDriver Driver) {

	//Element which needs to drag.    		
	element = Driver.findElement(By.xpath("//*[@id='draggable']"));	
 
 //Element on which need to drop.		
 WebElement elements = Driver.findElement(By.xpath("//*[@id='droppable']"));					
 		
 //Using Action class for drag and drop.		
 Actions act=new Actions(Driver);					

//Dragged and dropped.		
 act.dragAndDrop(element, elements).build().perform();
 
return element;	
}


public static String getCellData(String TableXpath, int rownum, int columnnum) throws Exception {
            try {       
            	
            	
                String cellXpath = TableXpath + "//div[@class='rt-tr-group'][" + rownum + "]" + "//div[@class='rt-td'][" + columnnum + "]";
             
               // Xpath for Webtable
                		//div[@class='rt-table']//div[@class='rt-tr-group'][3]//div[@class='rt-td'][2]
                
                Thread.sleep(100);
                String celldata = Driver.findElement(By.xpath(cellXpath)).getText();
               
                return celldata;
            } catch (Exception e) {
               
                throw new Exception();
            }


        }

		public static int getColCount(String TableXpath) throws Exception {
            try {
                
                String cellXpath = TableXpath + "//div[@class='rt-tr-group'][1]//div[@class='rt-td']";
                List<org.openqa.selenium.WebElement> cols = Driver.findElements(By.xpath(cellXpath));
                int colcount = cols.size();
               
                return colcount;
            } catch (Exception e) {
               
                throw new Exception();
            }
        }
		
public static int getRowCount(String TableXpath) throws Exception {
            try {
               
                String cellXpath = TableXpath + "//div[@class='rt-tr-group']";
                List<org.openqa.selenium.WebElement> rows = Driver.findElements(By.xpath(cellXpath));
                int rowcount = rows.size();
                
                return rowcount;
            } catch (Exception e) {
                
                throw new Exception();
            }
}

 public static String getAlltabledata() throws Exception 
  
 {
	 String celltext = "" ;
            int Rows = getRowCount("//div[@class='rt-table']");
            int columns = getColCount("//div[@class='rt-table']");
                                   System.out.println("Number of Rows in the Table :"+Rows);
            					   System.out.println("Number of Columnse Table :"+columns);
                                   for(int k=1; k<=Rows; k++)
                                   {
            					    for(int l=1; l<=columns; l++){
            						celltext= getCellData("//div[@class='rt-table']",k,l);
            						  System.out.println(celltext);
            						}
  
                                   }
								return celltext;
 }

        
	public static WebElement Checkbox(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]"));
	    
		return element;
	}

	//*[@id="tree-node"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[3]
	public static WebElement clickelement(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
	    
		return element;
	}

	public static WebElement selectcheckbox(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"item-1\"]"));
	    
		return element;
	}
	//Book Store application..............................

	public static WebElement clickbookstore(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[6]/span/div/div[1]"));
	    
		return element;
	}
	////*[@id="item-0"]

	public static WebElement clickloginbookstore(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//span[.='Login']"));
	    
		return element;
	}

	public static WebElement enterusrname(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id='userName']"));
	    
		return element;
	}

	public static WebElement enterpass(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id='password']"));
	    
		return element;
	}

	public static WebElement clickloginbutton(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id='login']"));
	    
		return element;
	}


	public static WebElement clickprofile(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//span[.='Profile']"));
	    
		return element;
	}
	////*[@id="item-3"]

	public static WebElement clicklogoutbookstore(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id='submit']"));
	    
		return element;
	}
	//webtable...........................................................................

	public static WebElement webtable(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div/div[1]"));
	    
		return element;
	}

	//*[@id="app"]/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div/div[1]

	public static WebElement links(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"simpleLink\"]"));
	    
		return element;
	}

	//*[@id="simpleLink"]

	public static WebElement dynamic(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
	    
		return element;
	}


	//*[@id="alertButton"]


	public static WebElement widgets_autocomplete(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"autoCompleteMultipleContainer\"]/div/div[1]"));
	    
		return element;
	}

	//*[@id="autoCompleteMultipleContainer"]/div/div[1]

	public static WebElement widgets_slider(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
	    
		return element;
	}


	//*[@id="sliderContainer"]/div[1]/span/input


	public static WebElement widgets_tabs(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"demo-tab-origin\"]"));
	    
		return element;
	}

	//*[@id="demo-tab-origin"]

	public static WebElement widgets_menu(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"nav\"]/li[1]/a"));
	    
		return element;
	}

	//*[@id="nav"]/li[1]/a



	public static WebElement sortable(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div[4]"));
	    
		return element;
	}


	//*[@id="demo-tabpane-list"]/div/div[4]

	public static WebElement resizable(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/div"));
	    
		return element;
	}

	//*[@id="resizableBoxWithRestriction"]/div


	public static WebElement draggable(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"dragBox\"]"));
	    
		return element;
	}



	//*[@id="dragBox"]

	// *********************************FORMS*********************************************

	public static WebElement clickform(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
	    
		return element;
	}
	public static WebElement clickpractiseform(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
	    
		return element;
	}
	public static WebElement enterfromfirstname(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
	    
		return element;
	}
	public static WebElement enterfromlastname(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
	    
		return element;
	}
	public static WebElement enterfromemail(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
	    
		return element;
	}
	public static WebElement enterfromgender(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]"));
	    
		return element;
	}
	public static WebElement enterfrommobilenum(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"userNumber\"]"));
	    
		return element;
	}
	public static WebElement enterfromDOB(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
	    
		return element;
	}
	public static WebElement enterfromSubject(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));
	    
		return element;
	}
	public static WebElement enterfromHobbies(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
	    
		return element;
	}
	public static WebElement enterfromsubmit(WebDriver Driver){
		
		element= Driver.findElement(By.xpath("//*[@id=\"submit\"]"));
	    
		return element;
	}
		
	public static WebElement DatePicker(WebDriver Driver) {
		
		element= Driver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
		element= Driver.findElement(By.xpath("//div[.='20']"));
		
		return element;
	}
	

	}

