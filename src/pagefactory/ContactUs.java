package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helper.SeleniumUtilities;

public class ContactUs {
	
	WebDriver driver;	
	
	@FindBy(xpath = "//a[contains(@title,'Contact Us')]") WebElement contactUsElement;
	@FindBy(xpath = "//select[contains(@id,'contact')][@class='form-control']") WebElement subjectHeadingElement;
	@FindBy(xpath = "//input[contains(@id,'email')]") WebElement emailAddElement;
	@FindBy(xpath = "//textarea[contains(@id,'message')]") WebElement messageBoxElement;
	@FindBy(xpath = "//span[contains(.,'Send')]") WebElement sendElement;
	@FindBy(xpath = "//p[@class='alert alert-success'][contains(.,'Your message has been successfully sent to our team.')]") WebElement messageSuccessfulElement;
	
	// Constructor
	public ContactUs(WebDriver driver) {
		this.driver = driver;
		
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void btnClick_ContactUs() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElementToBeClickable(contactUsElement, 10).click();
	}
	
	public void select_Subject(String strSubject) {		
		Select dropDown = new Select(subjectHeadingElement);
		dropDown.selectByVisibleText(strSubject);
	}
	
	public void input_EmailAdd(String strEmail) {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(emailAddElement, 10).sendKeys(strEmail);
	}
	
	public void btnClick_Send() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElementToBeClickable(sendElement, 10).click();
	}
	
	public void input_MessageBox(String strMessage) {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		util.waitForElement(messageBoxElement, 10).sendKeys(strMessage);
	}
	
	public String messageSuccessful() {
		SeleniumUtilities util = new SeleniumUtilities(driver);
		String strMessage = util.waitForElement(messageSuccessfulElement, 10).getText();
		return strMessage;
		
	}
}
