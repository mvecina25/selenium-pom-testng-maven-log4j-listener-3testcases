package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.SeleniumUtilities;

public class SignIn {
	
	WebDriver driver;	
	
	@FindBy(xpath = "//a[@class='login'][contains(.,'Sign in')]") WebElement signInElement;
	@FindBy(xpath = "//input[contains(@id,'email_create')]") WebElement emailCreateElement;
	@FindBy(xpath = "//span[contains(.,'Create an account')]") WebElement createAccountElement;
	@FindBy(xpath = "//li[contains(.,'An account using this email address has already been registered. Please enter a valid password or request a new one.')]") WebElement emailExistElement;
	
	// Constructor
	public SignIn(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void btnClick_SignIn() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElementToBeClickable(signInElement, 10).click();
	}
	
	public void input_EmailCreate(String strEmail) {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(emailCreateElement, 10).sendKeys(strEmail);
	}
	
	public void btnClick_CreateAccount() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElementToBeClickable(createAccountElement, 10).click();
	}

	public String emailExist() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		String strMessage =  util.waitForElement(emailExistElement, 10).getText();
		return strMessage;
	}
}
