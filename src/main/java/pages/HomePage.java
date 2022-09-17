package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.base;

public class HomePage extends base{
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[normalize-space()=\"Admin\"]")
	WebElement adminButton;
	
	public HomePage() {
		PageFactory.initElements(base.driver, this);
	}
	
	public UserManagementPage adminButtonClick() {
		adminButton.click();
		return new UserManagementPage();
	}

}
