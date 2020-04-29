package stepDefinition;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import pages.MainPage;

import static pages.BasePage.getDriver;

public class MainPageDef {

    @Then("Check Navigation bar should have element {string}")
    public void checkNavigationBarShouldHaveElement(String expectedElements) {
        Assert.assertEquals(new MainPage(getDriver()).getNavigationBarElements().get(0), expectedElements);
    }

}
