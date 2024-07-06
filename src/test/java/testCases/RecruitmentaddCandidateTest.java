/**
 * 
 */
package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.RecruitmentaddCandidate;
import pageObjects.RecruitmentviewCandidatesPage;
import utilities.Utilities;

/**
 * @author Srihari
 *
 */
public class RecruitmentaddCandidateTest extends BaseClass {
	LoginPage loginPage;
	DashboardPage dashBoardPage;
	RecruitmentviewCandidatesPage RecruitmentPage;
	RecruitmentaddCandidate addcandidatePage;

	@BeforeMethod
	public void setUp() {
		intilizeBrowser(prop.getProperty("Browser"));
	}

	@AfterMethod
	public void tearDown() {
		// driver.close();
	}

	@Test
	public void addCandidate() throws Throwable {
		loginPage = new LoginPage();
		loginPage.enterUsernameandPassword(prop.getProperty("Username"), prop.getProperty("Password"));
		dashBoardPage = loginPage.clickonLoginButton();
		RecruitmentPage = dashBoardPage.clickOnRecruitmentTab();
		addcandidatePage = RecruitmentPage.clickonAddButton();
		addcandidatePage.enterFirstName();
		addcandidatePage.enterLastName();
		addcandidatePage.selectVacany();
		addcandidatePage.enterEmail();
		addcandidatePage.clickonfileuploadbutton();
		Utilities.robotClass(prop.getProperty("imgPath"));
		addcandidatePage.clickonsaveButton();
		Assert.assertEquals(addcandidatePage.getstatusofApplication(), "Status: Application Initiated",
				"Status not matched");

	}

}
