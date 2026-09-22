package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Navbar {
    WebDriver driver;
    WebDriverWait wait;
    String turl;
    public Navbar(WebDriver driver)
    {
        this.driver= driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //"a[href='https://example.com']"
    By about = By.name("about");
    By skills = By.name("skills");
    By contact = By.name("contact");
    public void aboutverification()
    {
        driver.findElement(about).click();
        turl = driver.getCurrentUrl();

        Assert.assertTrue(turl.contains("about"), "About section working as expected");
    skillverification();
    contactverification();

    }
    public void skillverification()
    {
            driver.findElement(skills).click();
            turl = driver.getCurrentUrl();
            Assert.assertTrue(turl.contains("skills"), "Skills section working as expected");
    }
    public void contactverification()
    {
        driver.findElement(contact).click();
        turl = driver.getCurrentUrl();
        Assert.assertTrue(turl.contains("contact"), "Contact section working as expected");
    }

}
