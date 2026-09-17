package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class instagramVerification
{
    WebDriver driver;
    instagramVerification(WebDriver driver)
    {
        this.driver=driver;
    }
    By instaBtn = By.cssSelector("a[title = 'Instagram']");

    public void instaVerify()
    {
        WebElement instabtn = driver.findElement(instaBtn);
        String href = instabtn.getAttribute("href");

        if(href.equals("https://www.instagram.com/chandaksanskar/"))
        {
            System.out.println("Instagram link is correct");
        }else
        {
            System.out.println("Instagram link is incorrect");

        }

    }


}
