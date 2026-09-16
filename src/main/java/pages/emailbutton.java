package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class emailbutton
{
    WebDriver driver;

    emailbutton(WebDriver driver)
    {
        this.driver = driver;
    }
    //By emaillocator = By.name("contact");

    public void verifyemail()
    {

        WebElement email = driver.findElement(By.xpath("//*[@id=\"contact\"]/div/div/a"));

        String href = email.getAttribute("href");
        System.out.println(href);
        if (href.equals("mailto:connectwithsanskar@gmail.com")) {
            System.out.println("Email link is correct");
        } else {
            System.out.println("Email link is incorrect");
        }

    }
}
