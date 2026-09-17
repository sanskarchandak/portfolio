package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class linkedinVerification
{
    WebDriver driver;

    linkedinVerification(WebDriver driver)
    {
        this.driver = driver;
    }

    By linkedinbtn = By.cssSelector(("a[title='LinkedIn']"));

    public void verifyLinkedinBtn() {
        WebElement linkedin = driver.findElement(linkedinbtn);
        String href = linkedin.getAttribute("href");
        if (href.equals("https://www.linkedin.com/in/sanskarchandak/")) {
            System.out.println("Linkedin link is correct");
        } else {
            System.out.println("Linkedin link is incorrect");
        }

    }}


