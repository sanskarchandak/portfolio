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
        String baseUrl = System.getProperty("baseUrl", "https://sanskarchandak.com/?i=1");
        driver.get(baseUrl);
        System.out.println("==================Base setup Executed==================");
        System.out.println("Test Environment: " +baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }


}
