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


public class TC3_AddAndRemoveItem extends TestBaseSetup{
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(ITestContext iTestContext) {
		driver = getDriver();		
		
		// Set the driver object to the ITestContext
		TestListener.setContext(iTestContext, driver);
	}
	
	@Test
	public void addAndRemoveItem(){		
		
		ShoppingCart SC = new ShoppingCart(driver);
		SeleniumUtilities util = new SeleniumUtilities(driver);

		SC.btnClick_Dresses();
		
		util.selectProductItemByCSSNameAndPrice("#center_column > ul > li > div", "Printed Summer Dress", "$30.50");
		
		SC.btnClick_AddToCart();
		
		SC.btnClick_ProceedToCheckOut();
		
		SC.btnClick_DeleteItem();
		
		Assert.assertEquals(SC.messageShoppingCartEmpty(), "Your shopping cart is empty.");
	}
}
