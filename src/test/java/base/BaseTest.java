package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://sanskarchandak.com/?i=1");
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }


}
