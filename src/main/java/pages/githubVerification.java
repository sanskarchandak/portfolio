package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class githubVerification
{
    WebDriver driver;
   public githubVerification(WebDriver driver)
    {
        this.driver=driver;
    }
    By gitbutton = By.cssSelector(("a[title='GitHub']"));

    public void verifyGitbtn()
    {
        WebElement gitB = driver.findElement(gitbutton);
        String href = gitB.getAttribute("href");
        Assert.assertTrue(href.equals("https://github.com/sanskarchandak"), "Github link is correct");
    }
}
