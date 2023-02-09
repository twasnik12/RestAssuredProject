package stepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//@RunWith(io.cucumber.junit.Cucumber.class)
public class StepDefination {
	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
	   System.out.println("user is on landing page");
	}

	@When("^User Login into application with username and passowrd$")
	public void user_Login_into_application_with_username_and_passowrd() throws Throwable {
		System.out.println("user get loged in");
	}

	@Then("^Home page is polpulated$")
	public void home_page_is_polpulated() throws Throwable {
		System.out.println("user land on homepage");
	}

	@Then("^card are displayed$")
	public void card_are_displayed() throws Throwable {
		System.out.println("cards get displayed");
	}
	
}
