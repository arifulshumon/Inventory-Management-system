package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.CommonMethod;
import Utilities.ExtentFactory;
import pages.Purchase_Task;

public class Purchase_Task_test extends CommonMethod {
	
	ExtentReports extent;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void Task_submenu() {
		extent = ExtentFactory.getInstance();
		parentTest =extent.createTest("<p style=\"color:orange; font-size:13px\"><b>Login Page</b></p>").assignAuthor("S. M. Ariful Islam").assignDevice("Windows");
	}
	
	@Test
	public void Task_run() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Task Menu Click</b></p>");
		Purchase_Task Wm_task = new Purchase_Task(childTest);
		Wm_task.Task_Manu();
	}
	
	@AfterClass
	public void report() {
		extent.flush();
	}

}
