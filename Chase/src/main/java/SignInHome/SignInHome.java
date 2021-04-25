package SignInHome;

import common.WebAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;

import static SignInHome.SignInLocators.*;


public class SignInHome extends WebAPI {

    public SignInHome() { PageFactory.initElements(driver,this);}

    public void selectSignInButton() throws Exception {
        WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_BUTTON_CHASE_IFRAMELOGINBOX));
        iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CHASE_SIGNIN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CHASE_USERNAME);
        typeOnElement(WEB_ELEMENT_BUTTON_CHASE_USERNAME,WEB_ELEMENT_BUTTON_CHASE_EMAIL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CHASE_PASSWORD);
        typeOnElement(WEB_ELEMENT_BUTTON_CHASE_PASSWORD,WEB_ELEMENT_BUTTON_CHASE_PASSWORD1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CHASE_VERIFY);
    }
    public void username() throws Exception{
        WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_BUTTON_CHASE_IFRAMELOGINBOX));
        iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CHASE_SIGN_IN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CHASE_USER_NAME);
        typeOnElement(WEB_ELEMENT_BUTTON_CHASE_USER_NAME,WEB_ELEMENT_BUTTON_USERNAME_EMAIL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_CHASEVERIFY);
    }
    public void password() throws Exception{
        WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_BUTTON_CHASE_IFRAMELOGINBOX));
        iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_BUTTON_SIGN_IN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_PASSWORD);
        typeOnElement(WEB_ELEMENT_PASSWORD,WEB_ELEMENT_PASSWORD2);
        clickByXpathUsingJavaScript(WEB_ELEMENT_PASSWORD_VERIFY);
    }

    public void RememberMe() throws Exception{
        WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_BUTTON_CHASE_IFRAMELOGINBOX));
        iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_SIGNIN);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_USERNAME);
        typeOnElement(WEB_ELEMENT_CHASEBANK_USERNAME,WEB_ELEMENT_CHASEBANK_USERNAME_EMAIL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_PASSWORD);
        typeOnElement(WEB_ELEMENT_CHASEBANK_PASSWORD,WEB_ELEMENT_CHASEBANK_PASSWORD1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_VERIFY);
    }

    public void SignUp() throws Exception{
        WebElement loginBox = driver.findElement(By.xpath(WEB_ELEMENT_BUTTON_CHASE_IFRAMELOGINBOX));
        iframeHandle(loginBox);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_SIGNUP);
        sleepFor(3);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_PERSONAL);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_ACCOUNT);
        typeOnElement(WEB_ELEMENT_CHASEBANK_ACCOUNT,WEB_ELEMENT_CHASEBANK_ACCOUNT1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_Social);
        typeOnElement(WEB_ELEMENT_CHASEBANK_Social,WEB_ELEMENT_CHASEBANK_Social1);
        clickByXpathUsingJavaScript(WEB_ELEMENT_CHASEBANK_Verify);
        typeOnElement(WEB_ELEMENT_CHASEBANK_Verify,WEB_ELEMENT_CHASEBANK_Verify1);
    }
}
