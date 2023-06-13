package com.browserstack;

import java.util.concurrent.TimeUnit;
import com.browserstack.SeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;

public class WoltersKluwerTest extends SeleniumTest {
    @Test
    public void navigation_test() throws Exception {
        // navigate to Wolters Kluwer Homepage
        driver.get("https://www.wolterskluwer.com/en");
        // percy.snapshot("Home page");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Check the title
        Assert.assertTrue(driver.getTitle().matches("Wolters Kluwer - Combining Domain Expertise With Advanced Technology | Wolters Kluwer"));        

        // Click on cookie accept button if it comes up
        try {
            WebElement cookie_accept = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
            cookie_accept.click();
        } catch (Exception NoSuchFrameException) {
            System.out.println("\n--\nCookie banner didn't come up, moving on\n--\n");
        }        

        // Click on the Health section
        driver.findElement(By.cssSelector("li:nth-of-type(1) > .ow-nav-level-1-trigger.wk-button.wk-button-text")).click();
        // percy.snapshot("Branch finder page");

        // Click on "View all solutions"
        driver.findElement(By.cssSelector("li:nth-of-type(1) .ow-primary-nav-items > div:nth-of-type(1) > .ow-primary-nav-content > .ow-nav-level-2-view-all-link > span:nth-of-type(1)")).click();

        // Verify the title in that section
        // String telephone = (driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/div[2]/div/div/div[1]/div/h1")).getText()).toString;
        // Assert.assertEquals(telephone, "Health solutions specialized in clinical effectiveness, learning, research and safety.");
    }
}
