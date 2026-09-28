package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class emailbutton
{
    WebDriver driver;

    public emailbutton(WebDriver driver)
    {
        this.driver = driver;
    }

    public void verifyemail()
    {

        WebElement email = driver.findElement(By.xpath("//*[@id=\"contact\"]/div/div/a"));

        String href = email.getAttribute("href");
        Assert.assertTrue(href.equals("mailto:connectwithsanskar@gmail.com"), "Email link is correct");

    }
}
