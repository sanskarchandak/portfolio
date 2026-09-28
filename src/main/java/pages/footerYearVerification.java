package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class footerYearVerification
{
    WebDriver driver;
    public footerYearVerification(WebDriver driver)
    {
        this.driver=driver;
    }
    By footYear = By.id("year");

    public void verifyFooterYear()
    {
        WebElement year = driver.findElement(footYear);
        String Year = year.getText();
        Assert.assertTrue(Year.equals("2026"),"Correct year is present" );
    }
}
