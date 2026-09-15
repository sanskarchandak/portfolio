package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
public class DriverFactory
{
    public static WebDriver createDriver(String browserName)
    {
        String bname = browserName.toLowerCase();
        if(bname.equals("chrome"))
        {
            return new ChromeDriver();
        } else if (bname.equals("edge"))
        {
            return new EdgeDriver();
        }else if(bname.equals("firefox"))
        {
            return new FirefoxDriver();
        }else
        {
            throw  new IllegalArgumentException();
        }
    }
}




