package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final String MENU_ITEMS_XPATH = "//li[@class='Header-menuItem ']/a";

    @FindBy(xpath = MENU_ITEMS_XPATH)
    private List<WebElement> navigationBarElements;

    @FindBy(name = "q")
    private WebElement searchInput;

    public List<String> getNavigationBarElements() {
        return navigationBarElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public SearchResultPage searchInfo(String value) {
        searchInput.clear();
        searchInput.sendKeys(value + Keys.ENTER);

        return new SearchResultPage(driver);
    }

}
