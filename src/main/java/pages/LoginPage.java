package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.base;

public class LoginPage extends base{
public WebDriver driver;

	@FindBy(xpath="//div[@class='orangehrm-login-branding']")
	WebElement logo;
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement forgotPasswordLink;
	
	public LoginPage() {
	try {
		PageFactory.initElements(base.driver, this);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public boolean valiateLogo() {
		logo.isDisplayed();
		return true;
	}
	
	public HomePage login() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginBtn.click();
		return new HomePage();
	}
	
	public ForgotPassword frgtAction() {
		forgotPasswordLink.click();
		return new ForgotPassword();
	}
	
}
