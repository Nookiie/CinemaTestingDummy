package uni.fmi.tests;

import static 	org.junit.Assert.*;

import java.util.ArrayList;

import org.joda.time.DateTime;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import uni.fmi.cinemacity.common.GlobalConstants;
import uni.fmi.cinemacity.model.Movie;
import uni.fmi.cinemacity.model.Projection;
import uni.fmi.ui.Homepage;
import uni.fmi.ui.LoginForm;
import uni.fmi.ui.ProjectionForm;
import uni.fmi.ui.ReservationCheckoutForm;
import uni.fmi.ui.ReservationForm;
import static 	org.junit.Assert.*;

@CucumberOptions(features = "Features/Reservation.feature")
public class ReservationSteps {
	private Homepage homePage;
	private ProjectionForm projectionForm;;
	private ReservationForm reservationForm;
	private ReservationCheckoutForm reservationCheckoutForm;
	private Projection projection;
	private ArrayList<Integer> exampleSeats = new ArrayList<Integer>();
	private ArrayList<Integer> filledSeats = new ArrayList<Integer>();
	private String message = GlobalConstants.getReservationSuccessString();
	
	@Given("^Потребителят отваря началната стравица$")
	public void потребителят_отваря_началната_стравица() throws Throwable {
	    homePage = new Homepage();
	}

	@Given("^натиска върху бутона за създаване на резервация$")
	public void натиска_върху_бутона_за_създаване_на_резервация() throws Throwable {
	    reservationForm = homePage.clickCreateReservationButton();
	}

	@Given("^появява се форма за избор на прожекции$")
	public void появява_се_форма_за_избор_на_прожекции() throws Throwable {
	    assertNotNull(projectionForm);
	}

	@Given("^избира си прожекция от графика$")
	public void избира_си_прожекция_от_графика() throws Throwable {
	    projection = new Projection("FirstProjection", new Movie("Bad Guys 2"), DateTime.parse("2020-02-25"), DateTime.parse("2020-02-25"));
	    projectionForm.selectProjection(projection);
	}

	@Given("^се проверява дали е възможно да се направи резервация$")
	public void се_проверява_дали_е_възможно_да_се_направи_резервация() throws Throwable {
	    assertNotNull(projection);
	    assertEquals(true, projectionForm.isReservePossible(projection));
	}

	@Given("^визуализира се форма за резервация на дадени места за прожекцията$")
	public void визуализира_се_форма_за_резервация_на_дадени_места_за_прожекцията() throws Throwable {
	    assertNotNull(reservationForm);
	}

	@When("^кликне на местата, които ще резервира$")
	public void кликне_на_местата_които_ще_резервира() throws Throwable {
		// First Number => row,  second number => seat
		exampleSeats.add(12); 
		exampleSeats.add(13);
		
		reservationForm.chooseProjectionForReservation(projection);
	    reservationForm.chooseSeatsForProjection(exampleSeats);
	}

	@When("^кликне на бутона за плащане на резервацията$")
	public void кликне_на_бутона_за_плащане_на_резервацията() throws Throwable {
	    reservationCheckoutForm = reservationForm.clickToCheckoutButton();
	}

	@Then("^се появява форма за плащане на резервацията$")
	public void се_появява_форма_за_плащане_на_резервацията() throws Throwable {
	    assertNotNull(reservationCheckoutForm);
	}

	@Then("^си въведе името$")
	public void си_въведе_името() throws Throwable {
	    reservationCheckoutForm.addName("Viktor");
	}

	@Then("^си въведе детайлите на кредитната карта$")
	public void си_въведе_детайлите_на_кредитната_карта() throws Throwable {
	    reservationCheckoutForm.addCCNumber("121212");
	    reservationCheckoutForm.addCCDate("1212121");
	    reservationCheckoutForm.addCCSecret("213");
	}

	@Then("^натисне бутона за създаване на резервация$")
	public void натисне_бутона_за_създаване_на_резервация() throws Throwable {
	    reservationCheckoutForm.clickCompleteTransactionButton();
	}

	@Then("^се проверява кредитната карта$")
	public void се_проверява_кредитната_карта() throws Throwable {
	    reservationCheckoutForm.checkCC();
	}

	@Then("^се осъществява банков превод по кредитната карта$")
	public void се_осъществява_банков_превод_по_кредитната_карта() throws Throwable {
	    assertEquals(true, reservationCheckoutForm.makeTransaction());
	}

	@Given("^натиска върху бутона за избор на прожекция$")
	public void натиска_върху_бутона_за_избор_на_прожекция() throws Throwable {
	     projectionForm = homePage.clickChooseProjectionButton();
	}
	
	@Given("^се проверява дали е възможно да се направи неправилна резервация$")
	public void се_проверява_дали_е_възможно_да_се_направи_неправилна_резервация() throws Throwable {
		 assertNotNull(projection);
		 assertEquals(false, projectionForm.isReservePossible(projection));
		 message = projectionForm.getErrorMessage();
	}
	
	@Then("^вижда съобщение за резервацията \"([^\"]*)\"$")
	public void вижда_съобщение_за_резервацията(String message) throws Throwable {
	    assertEquals(message, this.message);
	}
	
	@When("^кликне на бутона за създаване на резервация$")
	public void кликне_на_бутона_за_създаване_на_резервация() throws Throwable {
	    reservationForm = projectionForm.clickCreateReservationButton();
	}

	@Given("^избира си прожекция от графика, която започва до един час$")
	public void избира_си_прожекция_от_графика_която_започва_до_един_час() throws Throwable {
		projection = new Projection("FirstProjection", new Movie("Bad Guys 2"), DateTime.parse("2019-10-13"), DateTime.parse("2019-10-13"));
		projectionForm.selectProjection(projection);
	}

	@Given("^избира си прожекция от графика, която няма свободни места$")
	public void избира_си_прожекция_от_графика_която_няма_свободни_места() throws Throwable {
		 projection = new Projection("FirstProjection", new Movie("Bad Guys 2"), DateTime.now(), DateTime.parse("2019-10-13"));
		 
		 // Dummy filledSeats array added to the Projection class to simulate a filled seats projection
		 for(int i = 0; i<92;i++) {
			 filledSeats.add(i);
		 }
		 
		 projection.setBlockedSeats(filledSeats);
		 projectionForm.selectProjection(projection);
	}
	
	@When("^кликне на местата, които ще резервира, които вече са заети$")
	public void кликне_на_местата_които_ще_резервира_които_вече_са_заети() throws Throwable {
		// First Number => row,  second number => seat
		exampleSeats.add(25); 
		exampleSeats.add(26);
		
		reservationForm.chooseProjectionForReservation(projection);		
		reservationForm.chooseSeatsForProjection(exampleSeats);
		
		message = reservationForm.getErrorMessage();
	}
	
	@When("^не избира място за резервация$")
	public void не_избира_място_за_резервация() throws Throwable {
	    reservationForm.chooseProjectionForReservation(projection);
	    reservationForm.chooseSeatsForProjection(exampleSeats);
	    
	    message = reservationForm.getErrorMessage();
	}

}
