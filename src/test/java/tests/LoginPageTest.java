package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.ForgotPassword;
import pages.HomePage;
import pages.LoginPage;
import utility.base;

public class LoginPageTest extends base {

	public WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ForgotPassword forgetPassword;

	@BeforeMethod
	public void initializeThings() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage();

	}

	@Test
	public void verifyTheLoginLogoIsDisplayed() {
		boolean flag = loginPage.valiateLogo();
		Assert.assertTrue(flag);
	}

	@Test
	public void verifyTheUserIsAbleToLoginProperly() {
		homePage = loginPage.login();
		String actualURL = driver.getCurrentUrl();
		String exceptedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		Assert.assertEquals(actualURL, exceptedURL);

	}

	@Test
	public void verifyTheForgotPasswordLinkWorkingProperly() {
		forgetPassword = loginPage.frgtAction();

	}

	@AfterMethod
	public void teadDown() {
		driver.quit();

	}

}
