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
        emailbutton eBtn = new emailbutton(driver);
        eBtn.verifyemail();
        resumebutton revBtn =  new resumebutton(driver);
        revBtn.resumeVerification();
        githubVerification gitV =  new githubVerification(driver);
        gitV.verifyGitbtn();
        linkedinVerification lVerify = new linkedinVerification(driver);
        lVerify.verifyLinkedinBtn();
        instagramVerification instaVerify = new instagramVerification(driver);
        instaVerify.instaVerify();
        twitterVerification tVerify = new twitterVerification(driver);
        tVerify.verifyTwitter();
        footerYearVerification fYearVerify =  new footerYearVerification(driver);
        fYearVerify.verifyFooterYear();

        driver.quit();

    }
}
