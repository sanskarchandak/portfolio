package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class footerYearVerification
{
    WebDriver driver;
    footerYearVerification(WebDriver driver)
    {
        this.driver=driver;
    }
    By footYear = By.id("year");

    public void verifyFooterYear()
    {
        WebElement year = driver.findElement(footYear);
        String Year = year.getText();
        if(Year.equals("2026"))
        {
            System.out.println("Correct year is present");
        }else
        {
            System.out.println("Incorrect Year is present");
        }
    }
}
