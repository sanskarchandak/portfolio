package smoke;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class PortfolioTest extends BaseTest
{
    @Test
    public void verifyhomepage()
    {
        Homepage hp = new Homepage(driver);
        hp.homepageverifly();
    }

   @Test
    public void verifynavbar()
   {
        Navbar nav = new Navbar(driver);
        nav.aboutverification();
   }

   @Test
    public void verifyemail()
   {
        emailbutton eBtn = new emailbutton(driver);
        eBtn.verifyemail();
   }

    @Test
    public void verifyresumebtn()
    {
        resumebutton revBtn =  new resumebutton(driver);
        revBtn.resumeVerification();
    }

    @Test
    public void verifygithub()
    {
        githubVerification gitV =  new githubVerification(driver);
        gitV.verifyGitbtn();

    }

    @Test
    public void verifylinkedin()
    {
        linkedinVerification lVerify = new linkedinVerification(driver);
        lVerify.verifyLinkedinBtn();
    }

    @Test
    public void verifyinstagram()
    {
        instagramVerification instaVerify = new instagramVerification(driver);
        instaVerify.instaVerify();
    }

    @Test
    public void verifytwitter()
    {
        twitterVerification tVerify = new twitterVerification(driver);
        tVerify.verifyTwitter();
    }

    @Test
    public void verifyfootyear()
    {
        footerYearVerification fYearVerify =  new footerYearVerification(driver);
        fYearVerify.verifyFooterYear();
    }




}
