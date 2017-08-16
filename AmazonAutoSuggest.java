package AutoSuggest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AmazonAutoSuggest {

	@Test
	public void Suggest() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.amazon.in");
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("moto");
	    Thread.sleep(3000);
	    
	    List<WebElement> autoSuggest = driver.findElements(By.xpath("//div[contains(@id,'issDiv')]"));
	    Actions builder = new Actions(driver);
	   
	    
	    
	for(WebElement auto: autoSuggest)
	{
		System.out.println(auto.getText());
		
		if(auto.getText().equalsIgnoreCase("moto g play 4th gen")){
			//Thread.sleep(3000);
			builder.moveToElement(auto).build().perform();
			Thread.sleep(3000);
			builder.click(auto).build().perform();
			break;
		}
		
		
	}
	driver.findElement(By.xpath("//a[@title='Moto G Play, 4th Gen (Black)']/h2")).click();
	//Thread.sleep(6000);
	
	//Switch Tabs(Window handels)
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    
	    System.out.println("Title before switch"+driver.getTitle());//Parent window title
	    driver.switchTo().window(tabs2.get(1));//New window
	    System.out.println(driver.getTitle());//New window title
	    // driver.close();
	 
	    driver.switchTo().window(tabs2.get(0));
	    System.out.println(driver.getTitle());
	    Thread.sleep(6000);
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
	    Thread.sleep(6000);
	
	driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']")).click();
	
	
	// Action class methods right click and others
	//Actions builder= new Actions(driver);
	//builder.dragAndDropBy(source, xOffset, yOffset)
    //builder.dragAndDrop(source, target)
	/*Actions action = new Actions(driver);
	actions.contextClick(link).moveByOffset(x,y).click().build().perform();
	
	To select the item from the contextual menu, you have to just move your mouse positions with the use of Key down event like this:-

	Actions action= new Actions(driver);
	action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	hope this will works for you. Have a great day :)
	*/
	//driver.quit();
	
	}
	
	
	
}
