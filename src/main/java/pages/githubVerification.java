package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class githubVerification
{
    WebDriver driver;
    githubVerification(WebDriver driver)
    {
        this.driver=driver;
    }
    By gitbutton = By.cssSelector(("a[title='GitHub']"));

    public void verifyGitbtn()
    {
        WebElement gitB = driver.findElement(gitbutton);
        String href = gitB.getAttribute("href");
        if(href.equals("https://github.com/sanskarchandak"))
        {
            System.out.println("Github link is correct");
        }else
        {
            System.out.println("Github link is incorrect");
        }

    }


}
