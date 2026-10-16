package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Homepage
{
        WebDriver driver;
        public Homepage(WebDriver driver)
        {
            this.driver =driver;
        }
        public void homepageverifly()
        {
            String title = driver.getTitle();
            System.out.println(title);
            Assert.assertTrue(title.contains("Sanskar"), "Correct page open");
        }
}

