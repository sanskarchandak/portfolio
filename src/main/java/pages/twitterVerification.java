package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitterVerification
{
    WebDriver driver;
    twitterVerification(WebDriver driver)
    {
        this.driver= driver;
    }
    By twitterBtn = By.cssSelector("a[title = 'Twitter']");
    public void verifyTwitter()
    {
        WebElement twitter = driver.findElement(twitterBtn);
        String href = twitter.getAttribute("href");
        if(href.equals("https://x.com/sanskarYchandak"))
        {
            System.out.println("Twitter link is correct");
        }else
        {
            System.out.println("Twitter link is incorrect");
        }
    }
}
