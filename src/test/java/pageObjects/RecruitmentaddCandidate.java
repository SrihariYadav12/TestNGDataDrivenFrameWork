/**
 * 
 */
package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

/**
 * @author Srihari
 *
 */
public class RecruitmentaddCandidate extends BaseClass {

	public RecruitmentaddCandidate() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(name = "firstName")
	private WebElement fname;

	@FindBy(name = "lastName")
	private WebElement lname;

	@FindBy(xpath = "//i[contains(@class,'oxd-select-text--arrow')]")
	private WebElement vacanyDropdown;

	@FindBy(xpath = "//div[@role ='listbox']/div")
	List<WebElement> vacancytable;

	@FindBy(xpath = "//label[text()='Email']//parent::div//following-sibling::div//input")
	private WebElement email;

	@FindBy(xpath = "//i[contains(@class,'oxd-icon bi-upload')]")
	private WebElement fileuploadbutton;

	@FindBy(xpath = "//button[@type ='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath ="//p[contains(@class,'oxd-text--subtitle-2')]")
	private WebElement statusofApplication;
	
	public void enterFirstName() {
		fname.sendKeys("firsthrm");
	}

	public void enterLastName() {
		lname.sendKeys("Lasthrm");
	}

	public void selectVacany() throws Throwable {
		vacanyDropdown.click();
		
		Thread.sleep(1000);

		for (WebElement particularole : vacancytable) {
			System.out.println(particularole.getText());
			System.out.println(prop.getProperty("role"));
			if (particularole.getText().equalsIgnoreCase(prop.getProperty("role"))) {
				System.out.println("Inside loop");
				particularole.click();

				break;

			}

		}
	}

	public void enterEmail() {
		email.sendKeys("testtest@gmail.com");
	}

	public void clickonfileuploadbutton() {
		fileuploadbutton.click();
	}

	public void clickonsaveButton() {
		saveButton.click();
	}
	public String getstatusofApplication() {
		return statusofApplication.getText();
	}
}
