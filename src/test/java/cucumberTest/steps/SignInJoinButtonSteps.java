package cucumberTest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

public class SignInJoinButtonSteps {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @When("^(([\\w\\s]{2,})+) button is clicked$")
    public void clickOnButton(String button) {
        homePage.clickOnSignInJoinBtn();
    }

    @Then("^([\\w\\s]+) page is opened$")
    public void verifyCurrentURL(String pageName) {
        Assert.assertEquals("Incorrect redirection clicking on SignInJoin button.", loginPage.getExpectedRedirectURLSignInJoin(), loginPage.getLoginPage());
    }
}