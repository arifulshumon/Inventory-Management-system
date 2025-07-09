package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.PageDriver;
import Utilities.CommonMethod;
import Utilities.ScreenShoots;



public class Purchase_order extends CommonMethod {
ExtentTest test;
	
	public Purchase_order(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test =test;		
	}
	
	@FindBy (xpath = "//span[normalize-space()='Purchases List']")
	WebElement purchase_list;
	
	@FindBy(xpath = "//span[normalize-space()='Purchase Orders']")
	WebElement Purchase_order;
	
	@FindBy(xpath = "//table[@id='vgt-table']/tbody/tr[1]/td[@class='vgt-left-align text-right']/span/div/a[2]/i[@class='nav-icon i-Pen-2 font-weight-bold mr-2']")
	WebElement Change_order;
	
	@FindBy(xpath = "//div[@id='vs4__combobox']")
	WebElement Payment_status;
	
	@FindBy(xpath = "//input[@placeholder='Please Select']")
	WebElement payment_method;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement Submit_button;
	
	@FindBy(xpath = "//input[@id='__BVID__130']")
	WebElement ttax;
	
	
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
	    
	    public void Purchase_module() throws IOException {
			try {
				test.info("Click on the Water Billing and Collection");
				if (Purchase_order.isDisplayed()) {
					Purchase_order.click();
					Thread.sleep(3000);
					passCase("You are successfully click on the water billing module");
				}
			} catch (Exception e) {
				failCase("Unable to click on the water Billing and Collection", "Water_module_failed");
			}
		}
	    
	    
	    public void Purchase_edit() throws IOException {
			try {
				test.info("Click on the Water Billing and Collection");
				if (Change_order.isDisplayed()) {
					Change_order.click();
					Thread.sleep(3000);
					passCase("You are successfully click on the water billing module");
				}
			} catch (Exception e) {
				failCase("Unable to click on the water Billing and Collection", "Water_module_failed");
			}
		}
	    

	    
	    public void Payment_Status() throws IOException {
			try {
				test.info("Click on the Water Billing and Collection");
				if (Payment_status.isDisplayed()) {
					Payment_status.click();
					Thread.sleep(3000);
					Payment_status.sendKeys("paid");
					Payment_status.click();
					Thread.sleep(3000);
					passCase("You are successfully click on the water billing module");
				}
			} catch (Exception e) {
				failCase("Unable to click on the water Billing and Collection", "Water_module_failed");
			}
		}
	    
	    public void Payment_Choice() throws IOException {
			try {
				test.info("Click on the Water Billing and Collection");
				if (payment_method.isDisplayed()) {
					payment_method.click();
					Thread.sleep(3000);
					payment_method.sendKeys("Cash");
					Thread.sleep(3000);
					passCase("You are successfully click on the water billing module");
				}
			} catch (Exception e) {
				failCase("Unable to click on the water Billing and Collection", "Water_module_failed");
			}
		}
	    
	    public void Payment_Submit() throws IOException {
			try {
				test.info("Click on the Water Billing and Collection");
				if (Submit_button.isDisplayed()) {
					Submit_button.click();
					Thread.sleep(3000);
				
					passCase("You are successfully click on the water billing module");
				}
			} catch (Exception e) {
				failCase("Unable to click on the water Billing and Collection", "Water_module_failed");
			}
		}
	    
	    public void Purchase_List() throws IOException {
			try {
				test.info("Click on the Water Billing and Collection");
				if (purchase_list.isDisplayed()) {
					purchase_list.click();
					Thread.sleep(3000);
					passCase("You are successfully click on the water billing module");
				}
			} catch (Exception e) {
				failCase("Unable to click on the water Billing and Collection", "Water_module_failed");
			}
		}
	    
	    public void Purchase_tax() throws IOException {
			try {
				test.info("Click on the Water Billing and Collection");
				if (ttax.isDisplayed()) {
					ttax.click();
					Thread.sleep(3000);
					passCase("You are successfully click on the water billing module");
				}
			} catch (Exception e) {
				failCase("Unable to click on the water Billing and Collection", "Water_module_failed");
			}
		}
	    
	   
	    
	    
	   
	   
	    
	    
}
