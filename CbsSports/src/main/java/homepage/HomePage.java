package homepage;

import common.WebAPI;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class HomePage  extends WebAPI {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    /////////////////////////////////////////////////////////////////////////////////////////

    // Action Method class

//    // Find By Annotation: First Approach
//    @FindBy (how = How.XPATH, using =searchBoxLocator ) public WebElement searchBox;
//    @FindBy (how = How.XPATH, using =searchButtonLocator ) public WebElement searchButton;
//    @FindBy (how = How.XPATH, using =searchTextLocator ) public WebElement searchText;

    // Action Method

}


























