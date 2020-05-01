package com.softSwiss.tasks.firstTask;

import com.softSwiss.tasks.firstTask.pages.MainPage;
import com.softSwiss.tasks.firstTask.pages.PackagePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Tests {

    private WebDriver driver;
    private List<String> expectedNavigationBarElements = Arrays.asList("Why Go", "Getting Started", "Discover Packages", "About");
    private List<String> expectedRepositoryTabElements = Arrays.asList("Doc", "Overview", "Subdirectories", "Versions", "Imports", "Imported By", "Licenses");
    private final String moduleName = "github.com/mikekonan/protoc-gen-setter";
    private final String publishedDate = "Apr 13, 2020";
    private final String versionNumber = "v1.3.2";
    private String searchText = "setter";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openMainPage() {
        driver.get("https://go.dev/");
    }


    @Test
    public void navigationBarHasExpectedElements() {
        Assert.assertEquals(new MainPage(driver).getNavigationBarElements(), expectedNavigationBarElements);
    }

    @Test
    public void packagePageHasTabs() {
        PackagePage packagePage = new MainPage(driver).searchInfo(searchText).findResult(moduleName);
        Assert.assertEquals(packagePage.getTabElements(), expectedRepositoryTabElements);
    }

     @Test
    public void packagePageHasModuleName() {
        PackagePage packagePage = new MainPage(driver).searchInfo(searchText).findResult(moduleName);
        Assert.assertEquals(packagePage.getModuleName(), moduleName);
    }

     @Test
    public void packagePageHasPublishedDate() {
        PackagePage packagePage = new MainPage(driver).searchInfo(searchText).findResult(moduleName);
        Assert.assertEquals(packagePage.getPublishedDate(), publishedDate);
    }

     @Test
    public void packagePageHasVersion() {
        PackagePage packagePage = new MainPage(driver).searchInfo(searchText).findResult(moduleName);
        Assert.assertEquals(packagePage.getVersion(), versionNumber);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File source = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("./Screenshots/"+ "failed_test.png"));
                Reporter.log("Screenshot has been taken.");
            } catch (Exception ex) {
                Reporter.log("Throwing exception while taking screenshot" + ex.getMessage());
            }
        }
    }

}
