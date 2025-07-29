package automationCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {



    @Given("I'm on the Store page")
    public void iMOnTheStorePage() {
    }

    

    @When("I add a {string}  to the cart")
    public void iAddAToTheCart(String arg0) {
    }



    @Then("I see {int} {string} in the cart")
    public void iSeeInTheCart(int arg0, String arg1) {
    }
}
