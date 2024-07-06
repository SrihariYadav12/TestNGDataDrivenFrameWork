/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

/**
 * @author Srihari
 *
 */
public class DashboardPage extends BaseClass {

	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement displayDashBoard;

	@FindBy(xpath = "//span[text()='Recruitment']")
	private WebElement RecruitmentTab;

	public boolean verifydisplayDashBoard() {
		return displayDashBoard.isDisplayed();
	}

	public RecruitmentviewCandidatesPage clickOnRecruitmentTab() {
		RecruitmentTab.click();

		return new RecruitmentviewCandidatesPage();

	}

}
