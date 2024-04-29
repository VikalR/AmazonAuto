package AutoSuggest;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class GoogleAuto {

	
	
	@Test
	public void Suggest() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.google.com");
	    driver.manage().window().maximize();
	    
	    String cssValue= driver.findElement(By.xpath(".//*[@id='_eEe']/a[1]")).getCssValue("text-decoration");
	    
	    System.out.println("value"+cssValue);
	    
	    Actions act = new Actions(driver);
	    
	    act.moveToElement(driver.findElement(By.xpath(".//*[@id='_eEe']/a[1]"))).perform();
	    Thread.sleep(3000);
	    
	    String cssValue1= driver.findElement(By.xpath(".//*[@id='_eEe']/a[1]")).getCssValue("text-decoration");
	    
	    System.out.println("value over"+cssValue1);
	    
	    EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
	    
	    File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
	     
	    FileUtils.copyFile(srcFile, new File("./ScreenShots/TestAutoFiring.png"));
	    
	  
	    driver.findElement(By.name("q")).sendKeys("mahatama gandh");
	  //code to get entered textbox value
	    String searchValue =   driver.findElement(By.name("q")).getAttribute("value");
	  System.out.println("Value::"+searchValue);
	    Actions builder=new Actions(driver);

	    List<WebElement> autoSuggest = driver.findElements(By
	            .xpath("//div[@class='sbqs_c']"));
	    // verify the size of the list
	    System.out
	            .println("Size of the AutoSuggets is = " + autoSuggest.size());
	    // print the auto suggest
	    for (WebElement a : autoSuggest)
	        System.out.println("Values are = " + a.getText());
	    // suppose now you want to click on 3rd auto suggest then simply do like
	    // this
	  
	    
	    
	    
	    builder.moveToElement(autoSuggest.get(3)).build().perform();

	 // Give wait for 2 seconds 
	 Thread.sleep(12000);

	 // finally click on that element
	 builder.click(autoSuggest.get(3)).build().perform();
	 
	 autoSuggest.get(2).click();
		
		
	}
	
}
