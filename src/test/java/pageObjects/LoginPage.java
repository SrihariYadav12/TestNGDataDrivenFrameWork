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
public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(name = "username")
	private WebElement UserName;

	@FindBy(name = "password")
	private WebElement Password;

	@FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
	private WebElement LoginButton;

	@FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
	private WebElement invalidCredentials;

	// Actions
	public void enterUsernameandPassword(String Username, String password) {
		UserName.sendKeys(Username);
		Password.sendKeys(password);
	}

	public DashboardPage clickonLoginButton() {
		LoginButton.click();
		return new DashboardPage();
	}

	public String getinvalidCredentialstext() {
		return invalidCredentials.getText();
	}

}
