package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class instagramVerification
{
    WebDriver driver;
    public instagramVerification(WebDriver driver)
    {
        this.driver=driver;
    }
    By instaBtn = By.cssSelector("a[title = 'Instagram']");

    public void instaVerify()
    {
        WebElement instabtn = driver.findElement(instaBtn);
        String href = instabtn.getAttribute("href");
        Assert.assertTrue(href.equals("https://www.instagram.com/chandaksanskar/"),"Instagram link is correct" );
    }
}
