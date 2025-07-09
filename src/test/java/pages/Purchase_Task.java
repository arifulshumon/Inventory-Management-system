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

public class Purchase_Task extends CommonMethod {
	
ExtentTest test;
	
	public Purchase_Task(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test =test;		
	}

	@FindBy(xpath = "//span[normalize-space()='Purchases']")
	WebElement Purchases;
	
	@FindBy(xpath = "//span[normalize-space()='Make Purchase Order']")
	WebElement  Purchase_Order;
	
	@FindBy(xpath = "//input[@placeholder='Scan/Search Product by Code Or Name']")
	WebElement Code_Or_Name;
	
	@FindBy(xpath = "//li[@class='active autocomplete-result cursor-pointer']")
	WebElement cursor_pointer;
	
	@FindBy(xpath = "//span[normalize-space()='+']")
	WebElement add;
	
	@FindBy(xpath = "//input[@placeholder='Choose Supplier']")
	WebElement suppiler;
	
	@FindBy(xpath = "//ul[@id='vs1__listbox']")
	WebElement Add_list;
	
	@FindBy(xpath = "//button[normalize-space()='Make Order']")
	WebElement Make_over;
	
	
	
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
	    
	    public void Task_Manu() throws IOException {
			try {
				test.info("Go to the Task menubar");
				if (Purchases.isDisplayed()) {
					Purchases.click();
					Thread.sleep(3000);
					passCase("Successfully clicked Task Manu");
					
					try {
						test.info("Click on the client info menu");
						if (Purchase_Order.isDisplayed()) {
							Purchase_Order.click();
							Thread.sleep(2000);
							passCase("Client info button located");
							
							try {
								test.info("Want to New client Add");
								if (Code_Or_Name.isDisplayed()) {
									Code_Or_Name.sendKeys("100");
									Thread.sleep(2000);
									
									passCase("Product is Selected successfully");
								
									try {
										
										test.info("product is added");
										if(cursor_pointer.isDisplayed()) {
											cursor_pointer.click();
											Thread.sleep(3000);
											passCase("Product added successfully");
									try {
										test.info("product search");
										if(add.isDisplayed()) {
											add.click();
											add.click();
											Thread.sleep(3000);
											passCase("Supplier ");
													try {
														test.info("Supplier search is clicked");
														if(suppiler.isDisplayed()) {
															suppiler.sendKeys("Arif");
															Thread.sleep(3000);
															passCase("Product added successfully");
															
															try {
																test.info("Supplier is added");
																if(Add_list.isDisplayed()) {
																	Add_list.click();
																	Thread.sleep(3000);
																	passCase("Supplier name is selected");
																	
																	try {
																		test.info("Click the Make Purchase button");
																		if(Make_over.isDisplayed()) {
																			Make_over.click();
																			Thread.sleep(3000);
																			passCase("Click the Make Purchase button successfully");
																		}
																	} catch (Exception e) {
																		// TODO: handle exception
																	}
																}
															} catch (Exception e) {
																// TODO: handle exception
															}
														}
													} catch (Exception e) {
														// TODO: handle exception
													}
												}
										
										
									} catch (Exception e) {
										// TODO: handle exception
									}
							
										}
									}
										
								
							 catch (Exception e) {
								// TODO: handle exception
							}
								}
							}
							catch (Exception e) {
								failCase("User does not located the new info button", "new_client_add_fail");
							}
						}
					} catch (Exception e) {
						failCase("Client info text button does not located", "Client_info_fail");
					}		
				}
				
			} catch (Exception e) {
				failCase("Task Submenu didnot located", "task_menu_fail");
			}
		}
			
	
}
