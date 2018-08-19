package stepDefenition;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Data;
import junit.framework.Assert;

public class LoginSteps {
	
	//Use cucumber to bind the Feature file to Java code
	//Glue code 
	WebDriver driver = Hooks.driver;

	
	//Given the user is on  the login page
	@Given("the user is on  the login page")
	public void userOnLoginPage() {
		System.out.println("Step 1: user is on login page");

		//Navigate to login page
		driver.get("https://github.com/");
	}
	
	@When("the user enters valid credentials")
	public void userEnterValidCredentials() {
		System.out.println("Step 2: user enters valid credentials");
		driver.findElement(By.linkText("Sign in")).click();
		
	}
	
	
	@Then("the user should be able to view their balance")
	public void userViewBalance() {
		System.out.println("Step 3: user views balance");
		WebElement forgotPswLink = driver.findElement(By.linkText("Forgot password?"));
		Assert.assertTrue(forgotPswLink.isDisplayed());		
	}
	
	@When("the user enters not valid credentials")
	public void userEntersNotValidCredentials() {
		System.out.println("Step 2: user enters not valid credentials");
		driver.findElement(By.linkText("Sign in")).click();
	}
	
	@Then("the user should not be able to sign in")
	public void userViewAccountInfo() {
		System.out.println("Step 3: user views account info");
		WebElement forgotPswLink = driver.findElement(By.linkText("Forgot password?"));
		Assert.assertTrue(forgotPswLink.isDisplayed());	
	}
	
	@When("^user enters username as \"(.*)\"$")
    public void userEnterUsername(String email) {
		String userNameFieldSelector = "#user\\5b login\\5d";
		By userNameField = By.cssSelector(userNameFieldSelector);
		driver.findElement(userNameField).clear();
		driver.findElement(userNameField).sendKeys(email);
	}	
	
	@And("^user enters password as \"(.*)\"$")
	public void userEnterPassword(String psw) {
		String userPasswordFieldSelector = "#user\\5b password\\5d";
		By userPasswordField = By.cssSelector(userPasswordFieldSelector);
		driver.findElement(userPasswordField).clear();
		driver.findElement(userPasswordField).sendKeys(psw);
	}
	
	@And("user clicks on signUp")
	public void clickOnSignUpBtn() {
		String signUpBtnSelector = "body > div.application-main > div.py-6.py-sm-8.jumbotron-codelines > div > div > div.mx-auto.col-sm-8.col-md-5.hide-sm > div > form > button";
		By signUpBtn = By.cssSelector(signUpBtnSelector);
		driver.findElement(signUpBtn).click();
	}
	
	@Then("^the user should see error message like \"(.*)\"$")
	public void userSeeErrorMessage(String text) {
		String errorMessageSelector = "#signup-form > div";
		By errorMessage = By.cssSelector(errorMessageSelector);
		//String errorMessageOnScreen = driver.findElement(errorMessage).getText();
		//Assert.assertTrue(errorMessageOnScreen.contains(text));
	}
	
	@When("^user enters \"(.*)\" and \"(.*)\"$")
	public void userEntersNameAndPassword(String email, String psw) {
		userEnterUsername(email);
		userEnterPassword(psw);
		clickOnSignUpBtn();
	}
	
	@When("user enteres credentials username and password")
	public void userEntersNotValidCredentialsTwice(DataTable credentials) {
		//Extract data into a Map and iterate over Map
		for (Map<String, String> data: credentials.asMaps(String.class, String.class)) {
			//Parse map into local variable
			String userName = data.get("username");
			String password = data.get("password");
			
			//Perform action
			userEnterUsername(userName);
			userEnterPassword(password);
			//clickOnSignUpBtn();
			System.out.println("completed iteration in a for loop");
			
		}
	
	}
	
}
