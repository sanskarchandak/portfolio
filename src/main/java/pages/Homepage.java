package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage
{
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://sanskarchandak.com/?i=1");
        String wurl = driver.getCurrentUrl();
        if (wurl.contains("sanskar")) {
            System.out.println("Correct page open");
        } else {
            System.out.println("not correct page open");
        }

        Navbar nav = new Navbar(driver);
        nav.aboutverification();

        driver.quit();

    }
}
//reate initial automation framework for portfolio test cases and add homepage and navbar tests
