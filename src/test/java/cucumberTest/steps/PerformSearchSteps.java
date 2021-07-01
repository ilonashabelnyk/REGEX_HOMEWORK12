package cucumberTest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchAttributesPage;

public class PerformSearchSteps {
    private SearchAttributesPage searchAttributesPage = new SearchAttributesPage();

    @When("^(?:searchable term|not searchable term) is entered into search input field$")
    public void enterSearchTerm() {
        searchAttributesPage.enterSearchTerm();
    }

    @And("^(([\\w\\s]{2,})+) button is clicked by (?:signed-in user|guest)$")
    public void clickOnSearchBtn(String button) {
        searchAttributesPage.clickOnSearchBtn();
    }

    @Then("^search is(?: not|) performed and search results are(?: not|) empty$")
    public void verifySearchResultsAreNotEmpty() {
        Assert.assertTrue("Search results are empty.", searchAttributesPage.countSearchResults() > searchAttributesPage.getEmptySearchResults());
    }
}