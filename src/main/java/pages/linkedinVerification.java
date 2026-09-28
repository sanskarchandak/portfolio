package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class linkedinVerification
{
    WebDriver driver;

    public linkedinVerification(WebDriver driver)
    {
        this.driver = driver;
    }

    By linkedinbtn = By.cssSelector(("a[title='LinkedIn']"));

    public void verifyLinkedinBtn() {
        WebElement linkedin = driver.findElement(linkedinbtn);
        String href = linkedin.getAttribute("href");
        Assert.assertTrue(href.equals("https://www.linkedin.com/in/sanskarchandak/"), "Linkedin link is correct");
    }
}


