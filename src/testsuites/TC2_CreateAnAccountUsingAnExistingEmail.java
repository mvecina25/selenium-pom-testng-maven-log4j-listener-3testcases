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


public class TC2_CreateAnAccountUsingAnExistingEmail extends TestBaseSetup{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver = getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
	}
	
	@Test
	public void createAnAccountUsingAnExistingEmail(){		
		
		SignIn SI = new SignIn(driver);

		SI.btnClick_SignIn();
		SI.input_EmailCreate("test@test.com");
		SI.btnClick_CreateAccount();
		
		Assert.assertEquals(SI.emailExist(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
	}
}
