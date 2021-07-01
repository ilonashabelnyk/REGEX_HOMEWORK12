package cucumberTest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class OpenWebPageSteps {
    private HomePage homePage = new HomePage();

    @Given("^Bookdepository website is(?: not|) opened on the ([\\w\\s]+) page$")
    public void openBookdepositoryWebsite(String pageName) {
        homePage.openBookdepository();
    }

    @Then("^user is redirected into proper ([\\w\\s]+) page$")
    public void verifyHomePage(String pageName) {
        Assert.assertTrue("Home page is not opened!", homePage.isHomePageContentIsDisplayed());
    }
}