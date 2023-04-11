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

public class LloydsBankTest extends SeleniumTest {
    @Test
    public void branchFinder() throws Exception {
        // navigate to Lloyds bank homepage
        driver.get("https://www.lloydsbank.com/");
        percy.snapshot("Home page");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Check the title
        Assert.assertTrue(driver.getTitle().matches("Lloyds Bank - Personal Banking, Personal Finances & Bank Accounts"));

        // Click on the Branch finder
        driver.findElement(By.xpath("//*[@id=\"nav-header\"]/div/div/div[2]/ul/li[3]/a/span")).click();
        percy.snapshot("Branch finder page");

        // Click on cookie accept button if it comes up
        try {
            WebElement cookie_accept = driver.findElement(By.xpath("//*[@id=\"accept\"]"));
            cookie_accept.click();
        } catch (Exception NoSuchFrameException) {
            System.out.println("\n--\nCookie banner didn't come up, moving on\n--\n");
        }

        // Get the search bar and search for a place
        WebElement search_bar = driver.findElement(By.xpath("//*[@id=\"q\"]"));
        search_bar.sendKeys("London, UK");
        search_bar.sendKeys(Keys.ENTER);

        // Click on the third entry in the branch list
        driver.findElement(By.xpath("//*[@id=\"js-yl-309871\"]/article/div[1]/h3/a")).click();
        percy.snapshot("Branch details page");

        // Verify the phone number of the branch
        String telephone = driver.findElement(By.xpath("//*[@id=\"phone-main\"]")).getAttribute("innerText");
        Assert.assertEquals(telephone, "0345 602 1997");
    }
}
