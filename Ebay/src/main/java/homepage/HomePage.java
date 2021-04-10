package homepage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static homepage.HomePageWebElement.*;

public class HomePage  extends WebAPI {

    @FindBy(className = WEB_ELEMENT_INPUT_SEARCH_ANYTHING)
    WebElement inputSearchAnything;

    @FindBy(className = WEB_BUTTON_ELEMENT_ALL_CATEGORY)
    WebElement buttonAllCategory;

//@FindBy turns the String to a web element
    @FindBy(xpath = WEB_ELEMENT_BUTTON_SEARCH_ALL_CATEGORY)
    WebElement buttonSearchAllCategory;

    //initializing all the we element on this page, using PageFactory
    public HomePage() {
        PageFactory.initElements(driver1, this);//it initializes the web elements

    }

    public void sendKeysToSearchBar(String searchKeys1){
       sendKeysToElement(inputSearchAnything, searchKeys1);



    }

        public void clickSearchButton(){
            clickElement(buttonAllCategory);

        }



        public void doSearching(String searchKeys2){
        sendKeysToSearchBar(searchKeys2);
        clickSearchButton();

        }
    /////////////////////////////////////////////////////////////////////////////////////////

//    //Robot Available for All Below Methods
//    Robot robot;
//
//    {
//        try {
//            robot = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    // Find By Annotation: First Approach <- Used to Convert String into WebElements
////    @FindBy(how = How.XPATH, using = exampleLocator)
////    public WebElement ExampleName;
//
//    @FindBy(xpath = SEARCH_BY_CATEGORY)
//    public WebElement searchElement;
//
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//
//    // Action Method class
//    public void exampleActionMethod() throws InterruptedException {
//       clickOnElement1(SEARCH_BY_CATEGORY );
//
//
//    }
//    public void clickShopByCategory(){
//
//       WebWaitUntilClickByXpath(10, SEARCH_BY_CATEGORY);
//    }

}




















