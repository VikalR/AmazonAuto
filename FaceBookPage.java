package AutoSuggest;

import org.openqa.selenium.WebDriver;

public class FaceBookPage extends FaceBookPageObj {

	WebDriver driver;
	
	public FaceBookPage(WebDriver driver){
		
		super(driver);
		this.driver= driver;
		
	}
	
	
	public void enterEmail(String emailAdd){
		if(email.isDisplayed()){
			email.clear();	
		    email.sendKeys(emailAdd);
		}
	}
	
	public void enterPassword(String pass){
		if(password.isDisplayed()){
			password.clear();	
			password.sendKeys(pass);
		}
	}
	
	
}
