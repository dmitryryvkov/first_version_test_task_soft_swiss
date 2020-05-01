package com.softSwiss.tasks.firstTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchResultPage {

    private final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='SearchSnippet-header']")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//a[@class='Pagination-next']")
    private List<WebElement> nextButton;

    public PackagePage findResult(String result) {
        if (!searchResultElements.isEmpty()) {
            if (!nextButton.isEmpty()) {
                while (nextButton.get(0).isEnabled()) {
                    Map<String, WebElement> searchResults = searchResultElements.
                            stream().
                            collect(Collectors.toMap(WebElement::getText, we -> we.findElement(By.xpath(".//a"))));

                    if (searchResults.containsKey(result)) {
                        searchResults.get(result).click();
                        break;
                    } else {
                        nextButton.get(0).click();
                    }
                }
            } else {
                Map<String, WebElement> searchResults = searchResultElements.
                        stream().
                        collect(Collectors.toMap(WebElement::getText, we -> we.findElement(By.xpath(".//a"))));

                if (searchResults.containsKey(result)) {
                    searchResults.get(result).click();
                } else {
                    System.out.println("Searched element " + result + " isn't displayed");
                }
            }
        } else {
            System.out.println("Searched element " + result + " isn't displayed");
        }
        return new PackagePage(driver);
    }
}
