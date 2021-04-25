package Signintestpage;

import SignInHome.SignInHome;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

import static SignInHome.SignInLocators.*;

public class SignInTestPage extends WebAPI{

    SignInHome Sign = new SignInHome();

    @Test(enabled = false)
    public void testExample() throws Exception {
        Sign.selectSignInButton();
        assertEqualsGetTitle("Error: Sign in - chase.com");
    }

    @Test(enabled = false)
    public void username() throws Exception{
        Sign.username();
        assertEqualsGetTitle("Sign in - chase.com");
    }

    @Test(enabled = false)
    public void password() throws Exception{
        Sign.password();
        assertEqualsGetTitle("Sign in - chase.com");
    }

    @Test(enabled = false)
    public void RememberMe() throws Exception{
        Sign.RememberMe();
        assertEqualsGetTitle("Sign in - chase.com");
    }

    @Test
    public void SignUp() throws Exception{
        Sign.SignUp();
        assertEqualsGetTitle("Getting started - Online Enrollment - chase.com");
    }

}

