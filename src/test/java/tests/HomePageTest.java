package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserManagementPage;
import utility.base;

public class HomePageTest extends base{

	public WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	UserManagementPage userMgmtPage;
	
	@BeforeMethod
	public void initializeThings() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage();

	}
	
	@Test
	public void verifyAdminModuleisClickedProperly() {
		homePage = loginPage.login();
		homePage.adminButtonClick();
	}
	
	@AfterMethod
	public void teadDown() {
		driver.quit();
	}
	
	
}
