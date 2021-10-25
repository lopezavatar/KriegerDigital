package Krieger.stepDefinitions;

import Krieger.TestImplementation;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStepDef {
    TestImplementation myTest = new TestImplementation();

    @Given("{string} browser is opened")
    public void browserIsOpened(String browserType) {
        myTest.initializeBrowser(browserType);
    }

    @And("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        myTest.navigateToPage("https://www.hoeffner.de/login");
    }

    @Given("I can see a newsletter subscription input")
    public void iCanSeeANewsletterSubscriptionInput() {
        myTest.findNewsletterSection();
    }

    @When("I enter my email in the input field")
    public void iEnterMyEmailInTheInputField() {
        myTest.inputEmail("fake@fake.com");
    }

    @And("I press the {string} button")
    public void iPressTheButton(String buttonText) {
        myTest.clickOnButton(buttonText);
    }

    @Then("I can see a confirmation message")
    public void iCanSeeAConfirmationMessage() {
        myTest.visibilityOfConfirmation();
    }

    @And("Cookies are accepted")
    public void cookiesAreAccepted() {
        myTest.acceptCookies();
    }

    @After
    public void teardown() {
        myTest.closeBrowser();
    }
}
