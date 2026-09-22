package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class twitterVerification
{
    WebDriver driver;
    public twitterVerification(WebDriver driver)
    {
        this.driver= driver;
    }
    By twitterBtn = By.cssSelector("a[title = 'Twitter']");
    public void verifyTwitter()
    {
        WebElement twitter = driver.findElement(twitterBtn);
        String href = twitter.getAttribute("href");
        Assert.assertTrue(href.equals("https://x.com/sanskarYchandak"),"Twitter link is correct");
    }
}
