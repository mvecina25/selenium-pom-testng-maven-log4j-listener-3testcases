package testsuites;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseSetup;
import base.TestListener;
import helper.SeleniumUtilities;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;
import pagefactory.ContactUs;
import pagefactory.ShoppingCart;
import pagefactory.SignIn;


import org.testng.annotations.Parameters;


public class TC1_SendMessageToCustomerService extends TestBaseSetup{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver = getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
	}
	
	@Test
	public void sendMessageToCustomerService(){		
		
		ContactUs CU = new ContactUs(driver);

		CU.btnClick_ContactUs();
		CU.select_Subject("Customer service");
		CU.input_EmailAdd("test@test.com");
		CU.input_MessageBox("This is automation scripts built using Selenium and Eclipse");
		CU.btnClick_Send();
		
		Assert.assertEquals(CU.messageSuccessful(), "Your message has been successfully sent to our team.");
	}
}
