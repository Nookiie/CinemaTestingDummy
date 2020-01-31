package uni.fmi.tests;

import org.junit.runner.RunWith;

import static 	org.junit.Assert.*;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import uni.fmi.ui.Homepage;
import uni.fmi.ui.LoginForm;

public class LoginSteps {	
	private Homepage homePage;
	private LoginForm loginForm;
	
@Given("^Потребителят отваря началната страница$")
public void navigateToHomepage() throws Throwable {
    homePage = new Homepage();
}

@Given("^натиска върху бутона за вход в системата$")
public void clickHomePageLoginButton() throws Throwable {
    loginForm = homePage.clickLoginButton();
}

@Given("^появява се форма за вход в системата$")
public void isLoginFormPresent() throws Throwable {
    assertNotNull(loginForm);
}

@When("^въведе валидно потребителско име$")
public void addUserName() throws Throwable {
    loginForm.addUsername("Ivan");
}

@When("^въведе валидна парола$")
public void addPassword() throws Throwable {
    loginForm.addPassword("vankata69");
}

@When("^натисне бутона за Логин$")
public void clickLoginButton() throws Throwable {
	loginForm.clickLoginButton();
	homePage.setGetLoggedInStatus(loginForm.isLoggedIn());
}

@Then("^вижда съобщение \"([^\"]*)\"$")
public void checkLoginMessage(String expectedMessage) throws Throwable {
	assertEquals(expectedMessage, loginForm.getMessage());
}

@Then("^има логнат статус$")
public void isLoggedIn() throws Throwable {
    assertEquals(true, homePage.isGetLoggedInStatus());
}

@When("^въведе невалидно потребителско име$")
public void въведе_невалидно_потребителско_име() throws Throwable {
    loginForm.addUsername("asdsafafdd");
}

@When("^въведе невалидна парола$")
public void въведе_невалидна_парола() throws Throwable {
    loginForm.addPassword("sdadsadfa");
}

@When("^не въвежда потребителско име$")
public void не_въвежда_потребителско_име() throws Throwable {
    loginForm.addUsername("");
}

@When("^не въвежда парола$")
public void не_въвежда_парола() throws Throwable {
    loginForm.addPassword("");
}

@Given("^Потребителят не е регистриран$")
public void потребителят_не_е_регистриран() throws Throwable {
    assertEquals(false, homePage.isGetLoggedInStatus());
}	
}
