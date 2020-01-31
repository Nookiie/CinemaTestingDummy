package uni.fmi.tests;

import static 	org.junit.Assert.*;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import uni.fmi.cinemacity.common.GlobalConstants;
import uni.fmi.ui.Homepage;
import uni.fmi.ui.LoginForm;
import uni.fmi.ui.RegisterForm;

@CucumberOptions(features = "Features/Register.feature")
public class RegisterSteps {
	private RegisterForm registerForm;
	private Homepage homePage;
	
	@Given("^Потребителят отваря началната страница с готовност за създаване на акаунт$")
	public void startHomePage() throws Throwable {
	    homePage = new Homepage();
	}
	
	@Given("^натиска върху бутона за създаване на акаунт$")
	public void clickOnCreateAccount() throws Throwable {
	    registerForm = homePage.clickCreateAccountButton();
	}

	@Given("^визуализира се форма за създаване на акаунт$")
	public void showRegisterForm() throws Throwable {
		assertNotNull(registerForm);
	}

	@When("^натисне бутона за регистрация$")
	public void isRegisterFormNotNull() throws Throwable {
	    registerForm.clickRegisterButton();
	}

	@Then("^вижда съобщение с текст \"([^\"]*)\"$")
	public void getsExpectedMessage(String expectedMessage) throws Throwable {
	    assertEquals(expectedMessage, registerForm.getMessage());
	}

	@When("^въведе празно потребителско име на акаунт$")
	public void fillsEmptyUsername() throws Throwable {
	    registerForm.addUsername("");
	}

	@When("^въведе празна парола на акаунт$")
	public void fillsEmptyPassword() throws Throwable {
	    registerForm.addPassword("");
	}

	@When("^въведе потребителско име с повече от (\\d+) символа на акаунт$")
	public void fillsUsernameMax(int usernameLength) throws Throwable {
	    registerForm.addUsername("sdadsadsadsadsafasdasdawqdadasfasdfasasdadsafsadsadasgdsafdssadsadasdsa");
	}

	@When("^въведе валидно потребителско име на акаунт$")
	public void fillsUsername() throws Throwable {
	    registerForm.addUsername("Peter12");
	}

	@When("^въведе парола по-голяма от (\\d+) символа на акаунт$")
	public void fillsMaxPassword(int arg1) throws Throwable {
	    registerForm.addPassword("dsadadadagasfdsalgraekhgrfjklbflkjdsfhdsakjhdasgfhdajs,khjaiodhasjdasjdk");
	}

	@When("^въведе потребителско име с по-малко от (\\d+) символа на акаунт$")
	public void fillsMinUsername(int arg1) throws Throwable {
	    registerForm.addUsername("ad");
	}

	@When("^въведе парола по-малка от (\\d+) символа на акаунт$")
	public void въведе_парола_по_малка_от_символа(int arg1) throws Throwable {
	    registerForm.addPassword("12gad");
	}
	
	@When("^въведе валидна парола на акаунт$")
	public void fillsInPassword() throws Throwable {
	    registerForm.addPassword("12gadsd13asdf");
	}
}
