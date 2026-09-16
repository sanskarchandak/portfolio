package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class resumebutton
{
    WebDriver driver;
    WebDriverWait wait;
    By resumeBtn = By.name("download");
    resumebutton(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void resumeVerification()
    {
        WebElement resume = driver.findElement(resumeBtn);
        String href = resume.getAttribute("href");
        System.out.println(href);
        if(href.equals("https://sanskarchandak.com/assets/docs/Sanskar_chandak_resume.pdf"))
        {
            System.out.println("Correct resume link");
        }else
        {
            System.out.println("Incorrect resume link");
        }
    }



}
