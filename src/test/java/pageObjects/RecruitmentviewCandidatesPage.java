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
public class RecruitmentviewCandidatesPage extends BaseClass {

	public RecruitmentviewCandidatesPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='orangehrm-header-container']//button")
	private WebElement addButton;

	public RecruitmentaddCandidate clickonAddButton() {
		addButton.click();

		return new RecruitmentaddCandidate();
	}

}
