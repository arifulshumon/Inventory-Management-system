package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseDrivers.PageDriver;
import Utilities.CommonMethod;
import Utilities.ExtentFactory;
import pages.Loginpage;

public class LoginPage_test extends CommonMethod {
	
	ExtentReports extent;
	ExtentTest parentTest;
	ExtentTest childtest;
	
	@BeforeClass
	public void open_url() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		sleep();
		extent = ExtentFactory.getInstance();
		parentTest = extent.createTest("<p style=\"color:orange; font-size:13px\"><b>Login Page</b></p>").assignAuthor("S. M. Ariful Islam").assignDevice("Windows");
	}
	
	@Test
	public void MSUS_Login() throws IOException {
		childtest =parentTest.createNode("<p style=\\\"color:orange; font-size:13px\\\"><b>Login Page Click</b></p>");
		Loginpage Login_Page = new Loginpage(childtest);
		Login_Page.login();
	}
	
	@AfterClass
	public void report() {
		extent.flush();
	}

}
