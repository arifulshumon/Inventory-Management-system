package Tests;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import BaseDrivers.PageDriver;
import Utilities.CommonMethod;
import Utilities.ExtentFactory;
import pages.Purchase_order;

public class Purchaser_order_edit_test extends CommonMethod {
	ExtentReports extent;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void water() throws InterruptedException {
		//PageDriver.getCurrentDriver().get(url);
		//sleep();
		extent =ExtentFactory.getInstance();
		parentTest = extent.createTest("<p style=\"color:orange; font-size:13px\"><b>Purchase order changes by paying </b></p>").assignAuthor("S. M. Ariful Islam").assignDevice("Windows");
	}
	
	@Test (priority = 0)
	public void List() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Go to Payment Order</b></p>");
		Purchase_order setup = new Purchase_order(childTest);
		setup.Purchase_List();
	}
	@Test (priority = 1)
	public void Order() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Go to Payment Order</b></p>");
		Purchase_order setup = new Purchase_order(childTest);
		setup.Purchase_module();
	}
	
	@Test (priority = 2)
	public void Edit() throws IOException, TimeoutException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Click Edit Button</b></p>");
		Purchase_order wat_setup = new Purchase_order(childTest);
		wat_setup.Purchase_tax();
		
	}
	
	
	@Test (priority = 3)
	public void Tax() throws IOException, TimeoutException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Click Edit Button</b></p>");
		Purchase_order wat_setup = new Purchase_order(childTest);
		wat_setup.Purchase_edit();
		
	}
	
	@Test (priority = 3)
	public void Dia_type_check() throws IOException, TimeoutException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Add New Dia Type</b></p>");
		Purchase_order Dia_Type_add = new Purchase_order(childTest);
		Dia_Type_add.Payment_Status();
		
		
	}
	
	
	
	@Test (priority = 4)
	public void Dia_rate_check() throws IOException, TimeoutException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Add New Dia Rate</b></p>");
		Purchase_order Dia_rate_add = new Purchase_order(childTest);
		Dia_rate_add.Payment_Choice();
		
		
	}
	
	
	@Test (priority = 5)
	public void meter_rate_check() throws IOException, TimeoutException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Add New Meter Rate</b></p>");
		Purchase_order meter_rate_add = new Purchase_order(childTest);
		meter_rate_add.Payment_Submit();
		
		
		
	}
	
	
	
	@AfterClass
	public void report() {
		if (PageDriver.getCurrentDriver() != null) {
	        PageDriver.getCurrentDriver().quit();
	    }
		extent.flush();
	}
	
}
