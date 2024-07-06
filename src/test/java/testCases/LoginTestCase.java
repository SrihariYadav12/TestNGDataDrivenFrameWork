/**
 * 
 */
package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

/**
 * @author Srihari
 *
 */
@Listeners(utilities.ListenerClass.class)
public class LoginTestCase extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashBoardPage;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br) {
		// intilizeBrowser(prop.getProperty("Browser"));
		intilizeBrowser(br);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().close();
	}

	@Test(priority = 1)
	public void loginWithValidCredentials() {
		loginPage = new LoginPage();
		loginPage.enterUsernameandPassword(prop.getProperty("Username"), prop.getProperty("Password"));
		dashBoardPage = loginPage.clickonLoginButton();
		Assert.assertTrue(dashBoardPage.verifydisplayDashBoard());
	}

	@Test(priority = 2)
	public void loginwithInvalidPassword() {
		loginPage = new LoginPage();
		loginPage.enterUsernameandPassword(prop.getProperty("Username"), "Admin");
		loginPage.clickonLoginButton();
		assertEquals(loginPage.getinvalidCredentialstext(), "Invalid credentials",
				"Actulal and Expected text not matched");

	}

}
