package com.softSwiss.tasks.firstTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PackagePage {

    WebDriver driver;

    public PackagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@role='tablist']/li/a")
    private List<WebElement> tabElements;

    @FindBy(xpath = "//div[@class='DetailsHeader-infoLabel']//strong")
    private WebElement publishedDate;

    @FindBy(xpath = "//div[@class='DetailsHeader-version']")
    private WebElement versionNumber;

    @FindBy(xpath = "//div[@class='DetailsHeader-infoLabel']//span//a[@data-test-id='DetailsHeader-infoLabelModule']")
    private WebElement moduleName;

    public List<String> getTabElements(){
        return tabElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getPublishedDate(){
        return publishedDate.getText();
    }

    public String getVersion(){
        return versionNumber.getText();
    }

    public String getModuleName(){
        return moduleName.getText();

    }

}
