package smoke;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class PortfolioTest extends BaseTest
{
    @Test(groups = {"smoke" ,  "regression"})
    public void verifyhomepage()
    {
        Homepage hp = new Homepage(driver);
        hp.homepageverifly();
    }

   @Test(groups = {"smoke" ,  "regression"})
    public void verifynavbar()
   {
        Navbar nav = new Navbar(driver);
        nav.aboutverification();
   }

   @Test(groups = {"smoke" ,  "regression"})
    public void verifyemail()
   {
        emailbutton eBtn = new emailbutton(driver);
        eBtn.verifyemail();
   }

    @Test(groups = {"smoke" ,  "regression"})
    public void verifyresumebtn()
    {
        resumebutton revBtn =  new resumebutton(driver);
        revBtn.resumeVerification();
    }

    @Test(groups = {"regression"})
    public void verifygithub()
    {
        githubVerification gitV =  new githubVerification(driver);
        gitV.verifyGitbtn();

    }

    @Test(groups = {"regression"})
    public void verifylinkedin()
    {
        linkedinVerification lVerify = new linkedinVerification(driver);
        lVerify.verifyLinkedinBtn();
    }

    @Test(groups = {"regression"})
    public void verifyinstagram()
    {
        instagramVerification instaVerify = new instagramVerification(driver);
        instaVerify.instaVerify();
    }

    @Test(groups = {"regression"})
    public void verifytwitter()
    {
        twitterVerification tVerify = new twitterVerification(driver);
        tVerify.verifyTwitter();
    }

    @Test(groups = {"smoke" ,  "regression"})
    public void verifyfootyear()
    {
        footerYearVerification fYearVerify =  new footerYearVerification(driver);
        fYearVerify.verifyFooterYear();
    }




}
