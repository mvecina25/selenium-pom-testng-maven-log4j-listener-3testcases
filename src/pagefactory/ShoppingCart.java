package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.SeleniumUtilities;

public class ShoppingCart {
	
	WebDriver driver;	
	
	@FindBy(xpath = "(//a[contains(@title,'Dresses')])[5]") WebElement dressesElement;	
	@FindBy(xpath = "//span[contains(.,'Add to cart')]") WebElement addToCartElement;
	@FindBy(xpath = "//span[contains(.,'Proceed to checkout')]") WebElement proceedToCheckOutElement;
	@FindBy(xpath = "//i[contains(@class,'icon-trash')]") WebElement deleteItemElement;
	@FindBy(xpath = "//p[@class='alert alert-warning'][contains(.,'Your shopping cart is empty.')]") WebElement shoppingCartEmptyElement;
	@FindBy(xpath = "//*[@id='layer_cart']") WebElement layerCartElement;
	
	public String productListElement() {
		return null;
		
	}
	
	// Constructor
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void btnClick_Dresses() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElementToBeClickable(dressesElement, 10).click();
	}	

	public void btnClick_AddToCart() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElementToBeClickable(addToCartElement, 10).click();
	}
	
	public void btnClick_ProceedToCheckOut() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
//		util.waitForElement(layerCartElement, 10);
		util.waitForElementToBeClickable(proceedToCheckOutElement, 10).click();
	}
	
	public void btnClick_DeleteItem() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElementToBeClickable(deleteItemElement, 10).click();
	}
	
	public String messageShoppingCartEmpty() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		String strMessage = util.waitForElement(shoppingCartEmptyElement, 10).getText();
		return strMessage;
		
	}
}
