package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.PageDriver;
import Utilities.CommonMethod;
import Utilities.ScreenShoots;

public class Loginpage extends CommonMethod {
	ExtentTest test;
	
	public Loginpage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test =test;		
	}
	
	@FindBys({
	@FindBy(xpath = "//input[@id='__BVID__12']")
	})
	WebElement UserName;
	
	@FindBy(xpath = "//input[@id='__BVID__15']")
	WebElement password;
	
	@FindBy(xpath  = "//button[normalize-space()='Sign In']")
	WebElement logButton;
	
	
	
	  public void passCase(String message) {
	        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	    }

	  //Pass
	    @SuppressWarnings("unused")
	    public void passCaseWithSC(String message, String scName) throws IOException {
	        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	        String screenShotPath = ScreenShoots.capture(PageDriver.getCurrentDriver(), "" + scName + "");
	        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
	        test.info(dest);
	        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	    }
	
	  //Fail
	    
	    @SuppressWarnings("unused")
	    public void failCase(String message, String scName) throws IOException {
	        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
	        Throwable t = new InterruptedException("Exception");
	        test.fail(t);
	        String screenShotPath = ScreenShoots.capture(PageDriver.getCurrentDriver(), "" + scName + "");
	        String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
	        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	        PageDriver.getCurrentDriver().quit();
	    }
	    
	    public void login() throws IOException {
			try {
				test.info("Please enter your UserName");
				if (UserName.isDisplayed()) {
					UserName.sendKeys("admin@example.com");
					passCase("you have Successfully entered you username");
					Thread.sleep(3000);
					
					try {
						test.info("Please enter your password");
						if (password.isDisplayed()) {
							password.sendKeys("123456");
							passCase("You have successfully entered your password");
							Thread.sleep(3000);
							
							try {
								test.info("Successfully loggoed in with username and password");
								if (logButton.isDisplayed()) {
									logButton.click();
									Thread.sleep(3000);
									passCaseWithSC("You successfully logged in MSUS LGED", "login_button_success");
									
				
								}
							} catch (Exception e) {
								failCase("Log button is not locatable, please check the log button", "log_button_fail");
							}
						}
					} catch (Exception e) {
						failCase("provide password is not correct", "password_fail");
					}
					
				}
			} catch (Exception e) {
				failCase("UserName is not correct", "User_name_fail");
			
		}
	    

	    }  
	    
}


