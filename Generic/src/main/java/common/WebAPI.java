package common;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utilities.DataReader;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static common.WebApiWebElements.*;
import static org.slf4j.helpers.Util.report;

public class WebAPI<robot> {
    // Config class :

    //Robot available for all helper methods -> will not throw exceptions anymore
    public static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public DataReader dataReader;
    public Properties properties;

    String propertiesFilePath = "src/main/resources/secret.properties";

    public WebAPI() {

//        try {
//            properties = new Properties();
//            FileInputStream fis = new FileInputStream(propertiesFilePath);
//            properties.load(fis);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            dataReader = new DataReader();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //ExtentReport
    public static ExtentReports extent;


    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }
        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        //driver.close();
    }

    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(yyMMddHHmmssZ)");
        //DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,
                    new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }

    // Browser Setup
//    public static WebDriver driver = null;
    public static String browserStack_userName = "demo579";
    public static String browserStack_accessKey = "s8gx9NYyS3zW9kLcbmcH";
    public static String sauceLabs_userName = "";
    public static String sauceLabs_accessKey = "";


    @Parameters({"useCloudEnv", "cloudEnvName", "OS", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("sauceLabs") String cloudEnvName, @Optional("windows") String OS, @Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("86") String browserVersion, @Optional("https://www.google.com/") String url) throws IOException {
        // Platform: Local Machine/ Cloud Machine
        if (useCloudEnv == true) {
            if (cloudEnvName.equalsIgnoreCase("browserStack")) {
                getCloudDriver(cloudEnvName, browserStack_userName, browserStack_accessKey, OS, os_version, browserName, browserVersion);
            } else if (cloudEnvName.equalsIgnoreCase("sauceLabs")) {
                getCloudDriver(cloudEnvName, sauceLabs_userName, sauceLabs_accessKey, OS, os_version, browserName, browserVersion);
            }
        } else {
            getLocalDriver(OS, browserName);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(String OS, String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/mac/chromedriver");
            } else if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("chrome-options")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/mac/chromedriver");
            } else if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/BrowserDriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/BrowserDriver/mac/geckodriver");
            } else if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/BrowserDriver/windows/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            if (OS.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.ie.driver", "../Generic/BrowserDriver/windows/IEDriverServer.exe");
            }
            driver = new InternetExplorerDriver();
        }

        return driver;
    }

    public WebDriver getCloudDriver(String envName, String envUsername, String envAccessKey, String os, String os_version, String browserName,
                                    String browserVersion) throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);

        if (envName.equalsIgnoreCase("Saucelabs")) {
            //resolution for Saucelabs
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        //driver.close();
        driver.quit();
    }


// Helper Method
    // Our code should be dynamic and reusable

    public static void sleepFor(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    public void clickOnElement(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.className(locator)).click();
            } catch (Exception ex2) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex3) {
                    driver.findElement(By.xpath(locator)).click();
                }
            }
        }
    }

    public void typeOnElement(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            driver.findElement(By.xpath(locator)).sendKeys(value);
        }
    }

    // Useful for @FindBy Approach
    public void typeOnElement1(WebElement locator, String value) {
        try {
            locator.sendKeys(value);
        } catch (Exception ex) {
            locator.sendKeys(value);
        }
    }

    public static void typeOnElementNEnter(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    public static void typeOnElementNEnter(String locator, String value, WebDriver driver1) {
        try {
            driver1.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First Attempt was not successful");
                driver1.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second Attempt was not successful");
                    driver1.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third Attempt was not successful");
                    driver1.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }
    }

    public void clearField(String locator) {
        driver.findElement(By.id(locator)).clear();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public static void clickOnElement(String locator, WebDriver driver1) {
        try {
            driver1.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex1) {
            try {
                driver1.findElement(By.xpath(locator)).click();
            } catch (Exception ex2) {
                driver1.findElement(By.id(locator)).click();
            }
        }
    }

    public void typeOnInputField(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            driver.findElement(By.id(locator)).sendKeys(value);
        }

    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }

    public static List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }

    public static List<String> getTextFromWebElements(String locator, WebDriver driver1) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver1.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }

    public static List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }

    public static List<WebElement> getListOfWebElementsByCss(String locator, WebDriver driver1) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver1.findElements(By.cssSelector(locator));
        return list;
    }

    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }


    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }


    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    //Taking Screen shots
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenShots.png"));
    }

    //Synchronization
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }

    public void clearInput(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }

    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    //Handling New Tabs
    public static WebDriver handleNewTab(WebDriver driver1) {
        String oldTab = driver1.getWindowHandle();
        List<String> newTabs = new ArrayList<String>(driver1.getWindowHandles());
        newTabs.remove(oldTab);
        driver1.switchTo().window(newTabs.get(0));
        return driver1;
    }

    public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator) {
        boolean value = driver1.findElement(By.cssSelector(locator)).isDisplayed();
        return value;
    }

    public void typeOnInputBox(String locator, String value) {
        try {
            driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }


    // Customer Made Helper Methods for Amex.com
    public void brokenLink() throws IOException {
        //Step:1-->Get the list of all the links and images
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Total number of links and images--------->>> " + linksList.size());

        //Step:2-->Iterate linksList: exclude all links/images which does not have any href attribute
        List<WebElement> activeLinks = new ArrayList<WebElement>();
        for (int i = 0; i < linksList.size(); i++) {
            // System.out.println(linksList.get(i).getAttribute("href"));
            if (linksList.get(i).getAttribute("href") != null && (!linksList.get(i).getAttribute("href").contains("javascript") && (!linksList.get(i).getAttribute("href").contains("mailto")))) {
                activeLinks.add(linksList.get(i));
            }
        }
        System.out.println("Total number of active links and images-------->>> " + activeLinks.size());

        //Step:3--> Check the href url, with http connection api
        for (int j = 0; j < activeLinks.size(); j++) {
            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "--------->>> " + response);
        }
    }

    public void inputValueInTextBoxByWebElement(WebElement webElement, String value) {
        webElement.sendKeys(value + Keys.ENTER);
    }

    public void clearInputBox(WebElement webElement) {
        webElement.clear();
    }

    public String getTextByWebElement(WebElement webElement) {
        String text = webElement.getText();
        return text;
    }

    public void getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        System.out.println(" my test suite started at this time --> " + formatter.format(date));
    }

    // --------------------- EDIT BOX / TYPE -----------------------
    public void typeByXpath1(String loc, String val) {
        driver.findElement(By.xpath(loc)).clear();
        driver.findElement(By.xpath(loc)).sendKeys(val);
    }

    public void typeByCss1(String loc, String val) {
        driver.findElement(By.cssSelector(loc)).clear();
        driver.findElement(By.cssSelector(loc)).sendKeys(val);
    }

    public void typeById(String loc, String val) {
        driver.findElement(By.id(loc)).sendKeys(val);
    }

    public void typeByName(String loc, String val) {
        driver.findElement(By.name(loc)).sendKeys(val);
    }

    // ------------------- CLICK -----------------
    public void clickByXpath1(String loc) {
        driver.findElement(By.xpath(loc)).click();
    }

    public void clickByCss(String loc) {
        driver.findElement(By.cssSelector(loc)).click();
    }

    public void clickById(String loc) {
        driver.findElement(By.id(loc)).click();
    }

    public void clickByName(String loc) {
        driver.findElement(By.name(loc)).click();
    }

    public void clickByLinkText(String loc) {
        driver.findElement(By.linkText(loc)).click();
    }

    // ---------------- RADIO BUTTON
    public static void assertEqualsGetText(String exp,String loc) {
        try {
            String act = driver.findElement(By.xpath(loc)).getText();
            Assert.assertEquals(act, exp);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                String act = driver.findElement(By.cssSelector(loc)).getText();
                Assert.assertEquals(act, exp);
            } catch (Exception e1) {
                e1.printStackTrace();
                try {
                    String act = driver.findElement(By.id(loc)).getText();
                    Assert.assertEquals(act, exp);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        String act = driver.findElement(By.className(loc)).getText();
                        Assert.assertEquals(act, exp);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Slider Handling
      */

    // https://stackoverflow.com/questions/15171745/how-to-slidemove-slider-in-selenium-webdriver

    public void waitTimeExplicit(String locator) {
        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitTimeUsingFluent() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 30 seconds")
                .ignoring(NoSuchElementException.class);
    }


    public void clickOnElement1(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).click();
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).click();
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).click();
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).click();
                        }
                    }
                }
            }
        }
    }


    public void typeOnElement1(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).sendKeys(value);
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).sendKeys(value);
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).sendKeys(value);
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).sendKeys(value);
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).sendKeys(value);
                        }
                    }
                }
            }
        }
    }


    public void clickOnLink(String locator) {
        try {
            driver.findElement(By.linkText(locator)).click();
        } catch (Exception ex) {
            driver.findElement(By.partialLinkText(locator)).click();
        }
    }

    public void getTitle() {
        driver.getTitle();
    }

    public void clearField1(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).clear();
        } catch (Exception ex) {
            try {
                driver.findElement(By.xpath(locator)).clear();
            } catch (Exception ex1) {
                try {
                    driver.findElement(By.id(locator)).clear();
                } catch (Exception ex2) {
                    try {
                        driver.findElement(By.name(locator)).clear();
                    } catch (Exception ex3) {
                        try {
                            driver.findElement(By.className(locator)).clear();
                        } catch (Exception ex4) {
                            driver.findElement(By.tagName(locator)).clear();
                        }
                    }
                }
            }
        }
    }


    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void refresh() throws AWTException, InterruptedException {
        robot.keyPress(KeyEvent.VK_F5);
        waitTimeUsingFluent();


    }//use if click interception pops up as error

    public static void clickByXNCssUsingJavaScript(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", element);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n*** First Attempt Failed ***");
            try {
                WebElement element = driver.findElement(By.cssSelector(locator));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", element);
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("\n** Final Attempt Failed ***");
            }
        }

    }//use cssSelector

    public void clickByCssUsingJavaScript(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = driver.findElement(By.cssSelector(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);


    }

    /**
     * Helper Methods
     */

    public void sendKeysToElement(WebElement element, String keysToSend) {

        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(keysToSend);

        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");

        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO SEND KEYS TO WEB ELEMENT");
        }
    }

    public void clickElement(WebElement elementToClick) {

        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(elementToClick));
            elementToClick.click();
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");

        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO CLICK ON WEB ELEMENT");
        }
    }

    public String getTextFromElement(WebElement element) {
        String elementText = "";

        driverWait.until(ExpectedConditions.visibilityOf(element));

        try {
            elementText = element.getText();
            return elementText;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");
        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO GET TEXT FROM WEB ELEMENT");
        }

        return elementText;
    }

    public String getAttributeFromElement(WebElement element, String attribute) {
        String elementText = "";

        driverWait.until(ExpectedConditions.visibilityOf(element));

        try {
            elementText = element.getAttribute(attribute);
            return elementText;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENT IS STALE");
        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENT IS NOT VISIBLE IN THE DOM");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO GET ATTRIBUTE FROM WEB ELEMENT");
        }

        return elementText;
    }

    public List<WebElement> getListOfWebElements(By by) {
        List<WebElement> elementList = new ArrayList<>();

        driverWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(by)));

        try {
            elementList = driver.findElements(by);
            return elementList;
        } catch (StaleElementReferenceException staleElementReferenceException) {
            staleElementReferenceException.printStackTrace();
            System.out.println("ELEMENTS ARE STALE");
        } catch (ElementNotVisibleException elementNotVisibleException) {
            elementNotVisibleException.printStackTrace();
            System.out.println("ELEMENTS ARE NOT VISIBLE IN THE DOM");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UNABLE TO LOCATE WEB ELEMENTS");
        }

        return elementList;
    }

    /**
     * Assertion Helper Methods
     */

    public boolean compareStrings(String str1, String str2) {
        boolean flag = false;

        if (str1.toLowerCase().equals(str2)) {
            flag = true;
            return flag;
        }

        return flag;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public void readNSend(String pathName, int index) throws IOException {

        FileInputStream fis = new FileInputStream(new File(pathName));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(index); //Fetch Data From Index 0
        Iterator<Row> ite = sheet.rowIterator(); //Fetches rows with data in our worksheet
        while (ite.hasNext()) {
            Row row = (Row) ite.next();
            Iterator<Cell> cite = row.cellIterator();
            while (cite.hasNext()) {
                Cell c = cite.next();
                System.out.print(c.toString() + "  ");
            }
            System.out.println();
        }
        fis.close();
    }

    public void robotScrollDown(int i) throws InterruptedException {

        if (i <= 4) {
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            System.out.println("\n*** Scrolled Down Page x3 ***");
        } else if (i <= 6) {
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            System.out.println("\n*** Scrolled Down Page x6 ***");
        } else if (i <= 10) {
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            sleepFor(1);
            robot.keyPress(KeyEvent.VK_DOWN);
            System.out.println("\n*** Scrolled Down Page x10 ***");
        } else {
            System.out.println("\n*** Scrolled Down Limit is x10 ***");
        }
    }

    {
    }

    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void enterKey() {
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public void scrollToElementUsingJavaScript(String loc) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.xpath(loc));
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void scrollToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the web page till end.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void WebDriverWait0(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);

    }

    public void WebWaitUntilClickByXpath(int seconds, String loc) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc)));
        driver.findElement(By.xpath(loc)).click();

    }

    public void assertEqualsGetTitle(String expected) {
        String actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "\n*** Test Failed - Try Again ***");
    }

    public void assertTrueIsDisplayed(String loc) {
        try {
            boolean act = driver.findElement(By.xpath(loc)).isDisplayed();
            Assert.assertTrue(act);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                boolean act = driver.findElement(By.cssSelector(loc)).isDisplayed();
                Assert.assertTrue(act);
            } catch (Exception e1) {
                e1.printStackTrace();
                try {
                    boolean act = driver.findElement(By.id(loc)).isDisplayed();
                    Assert.assertTrue(act);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        boolean act = driver.findElement(By.className(loc)).isDisplayed();
                        Assert.assertTrue(act);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public void enterExcelDataInSearchNRefresh() throws IOException, AWTException, StaleElementReferenceException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prita\\IdeaProjects\\BootcampSelenium_Team4\\Generic\\BrowserDriver\\windows\\chromedriver.exe");
        File file = new File("../Ebay/DataTest/Ebay.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Products");
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        WebElement username = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_BAR_LOCATOR));
        for (int i = 1; i <= rowCount; i++) {
            if (i > rowCount) {
                wb.close();
            } else {
                wb.close();
                try {
                    typeOnElementNEnter(WEB_ELEMENT_SEARCH_BAR_LOCATOR, sheet.getRow(i).getCell(0).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            clickByXNCssUsingJavaScript(WEB_ELEMENT_SUBMIT_BUTTON_LOCATOR);
        }
        //Close
        wb.close();
    }

    public void WebWaitUntilClickableNClick(int seconds, String loc) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc))).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n First Attempt Failed ***");
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loc))).click();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("\n Second Attempt Failed ***");
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(loc))).click();
                } catch (Exception ex1) {
                    ex.printStackTrace();
                    System.out.println("\n Third Attempt Failed ***");
                    try {
                        wait.until(ExpectedConditions.elementToBeClickable(By.className(loc))).click();
                    } catch (Exception ex2) {
                        ex.printStackTrace();
                        System.out.println("\n Fourth Attempt Failed ***");
                        try {
                            wait.until(ExpectedConditions.elementToBeClickable(By.tagName(loc))).click();
                        } catch (Exception ex3) {
                            ex.printStackTrace();
                            System.out.println("\n Fifth Attempt Failed ***");
                            try {
                                wait.until(ExpectedConditions.elementToBeClickable(By.linkText(loc))).click();

                            } catch (Exception ex4) {
                                ex.printStackTrace();
                                System.out.println("\n Fifth Attempt Failed ***");
                                try {
                                    wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(loc))).click();
                                } catch (Exception ex5) {
                                    ex.printStackTrace();
                                    System.out.println("\n Final Attempt Failed ***");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void basicHoverUsingXpath(String loc) {
        //Hover over Like-New Cams link using Actions
        WebElement ele = driver.findElement(By.xpath(loc));
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        //Performing the mouse hover action on the target element.
        action.moveToElement(ele).perform();
    }

    public void assertEqualsGetAttribute(String expected, String locator, String attribute) throws InterruptedException {
        try {
            String icon = driver.findElement(By.xpath(locator)).getAttribute(attribute);
            Assert.assertEquals(icon, expected, "\n*** Error Icon Not Displayed ***");
        } catch (Exception e) {
            System.out.println("\n*** First Attempt Unsuccessful ***");
            try {
                String icon = driver.findElement(By.cssSelector(locator)).getAttribute(attribute);
                Assert.assertEquals(icon, expected, "\n*** Error Icon Not Displayed ***");
            } catch (Exception ex) {
                System.out.println("\n*** Second Attempt Unsuccessful ***");
                try {
                    String icon = driver.findElement(By.className(locator)).getAttribute(attribute);
                    Assert.assertEquals(icon, expected, "\n*** Error Icon Not Displayed ***");
                } catch (Exception ex1) {
                    System.out.println("\n*** Third Attempt Unsuccessful ***");
                    try {
                        String icon = driver.findElement(By.id(locator)).getAttribute(attribute);
                        Assert.assertEquals(icon, expected, "\n*** Error Icon Not Displayed ***");
                    } catch (Exception ex2) {
                        System.out.println("\n*** Fourth Attempt Unsuccessful ***");
                        try {
                            String icon = driver.findElement(By.tagName(locator)).getAttribute(attribute);
                            Assert.assertEquals(icon, expected, "\n*** Error Icon Not Displayed ***");
                        } catch (Exception ex3) {
                            System.out.println("\n*** Last Attempt Unsuccessful ***");
                        }
                    }
                }
            }
        }

    }

    public void hoverOverDropdownNClickUsingXpath(String main, String sub) {
        WebElement mainMenu = driver.findElement(By.xpath(main));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu);
        WebElement subMenu = driver.findElement(By.xpath(sub));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    public void dragAndDropUsingActions(String drag, String drop) {
        //Element which to drag.
        WebElement From = driver.findElement(By.xpath(drag));
        //Element on where to drop.
        WebElement To = driver.findElement(By.xpath(drop));
        //Using Action class for drag and drop.
        Actions act = new Actions(driver);
        //Dragged and Dropped.
        act.dragAndDrop(From, To).build().perform();
    }

    public void fluentWait() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .withMessage("\nFluent Wait Successful")
                .ignoring(NoSuchElementException.class);
    }

    public void doubleClickUsingXAndCSS(String locator) {
        try {
            Actions actions = new Actions(driver);
            WebElement elementLocator = driver.findElement(By.xpath(locator));
            actions.doubleClick(elementLocator).perform();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Actions actions = new Actions(driver);
                WebElement elementLocator = driver.findElement(By.cssSelector(locator));
                actions.doubleClick(elementLocator).perform();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void assertFalseIsSelected(String locator) {
        try {
            boolean act = driver.findElement(By.xpath(locator)).isSelected();
            Assert.assertFalse(act, "\n*** Test Failed - Try Again ***");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n*** First Attempt Failed ***");
            try {
                boolean act = driver.findElement(By.cssSelector(locator)).isSelected();
                Assert.assertFalse(act, "\n*** Test Failed - Try Again ***");
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("\n*** Second Attempt Failed ***");
                try {
                    boolean act = driver.findElement(By.id(locator)).isSelected();
                    Assert.assertFalse(act, "\n*** Test Failed - Try Again ***");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    System.out.println("\n*** Third Attempt Failed ***");
                    try {
                        boolean act = driver.findElement(By.tagName(locator)).isSelected();
                        Assert.assertFalse(act, "\n*** Test Failed - Try Again ***");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        System.out.println("\n*** Last Attempt Failed ***");
                    }
                }
            }
        }
    }

    public void assertTrueIsSelected(String locator) {
        try {
            boolean act = driver.findElement(By.xpath(locator)).isSelected();
            Assert.assertTrue(act, "\n*** Test Passed ***");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n*** First Attempt Failed ***");
            try {
                boolean act = driver.findElement(By.cssSelector(locator)).isSelected();
                Assert.assertTrue(act, "\n*** Test Passed ***");
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("\n*** Second Attempt Failed ***");
                try {
                    boolean act = driver.findElement(By.id(locator)).isSelected();
                    Assert.assertTrue(act, "\n*** Test Passed ***");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    System.out.println("\n*** Third Attempt Failed ***");
                    try {
                        boolean act = driver.findElement(By.tagName(locator)).isSelected();
                        Assert.assertTrue(act, "\n*** Test Passed ***");
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        System.out.println("\n*** Last Attempt Failed ***");
                    }
                }
            }
        }
    }

    public void rightClick(String locator) {
        try {
            Actions actions = new Actions(driver);
            WebElement elementLocator = driver.findElement(By.xpath(locator));
            actions.contextClick(elementLocator).perform();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("First Attempt Failed");
            try {
                Actions actions = new Actions(driver);
                WebElement elementLocator = driver.findElement(By.cssSelector(locator));
                actions.contextClick(elementLocator).perform();
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("Second Attempt Failed");
                try {
                    Actions actions = new Actions(driver);
                    WebElement elementLocator = driver.findElement(By.id(locator));
                    actions.contextClick(elementLocator).perform();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    System.out.println("Third Attempt Failed");
                    try {
                        Actions actions = new Actions(driver);
                        WebElement elementLocator = driver.findElement(By.className(locator));
                        actions.contextClick(elementLocator).perform();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        System.out.println("Final Attempt Failed");
                    }

                }
            }
        }
    }

    public void enterExcelDataInSearchNRefreshBOA() throws IOException, AWTException, StaleElementReferenceException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prita\\IdeaProjects\\BootcampSelenium_Team4\\Generic\\BrowserDriver\\windows\\chromedriver.exe");
        File file = new File("../BankOfAmerica/DataTest/BankOfAmerica.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Products");
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        WebElement username = driver.findElement(By.xpath(WEB_ELEMENT_SEARCH_BANK));
        implicitWait(15);
        for (int i = 1; i <= rowCount; i++) {
            if (i > rowCount) {
                wb.close();
            } else {
                wb.close();
                try {
                    implicitWait(15);
                    typeOnElementNEnter(WEB_ELEMENT_SEARCH_BANK, sheet.getRow(i).getCell(0).getStringCellValue());
                    clickByXNCssUsingJavaScript(WEB_ELEMENT_SUBMIT_BUTTON);
                    WebDriverWait0(15);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            clickByXNCssUsingJavaScript(WEB_ELEMENT_LOGO_BANK);
        }
        //Close
        wb.close();
    }

    public void acceptAlerts() {
        // Switching to Alert
        Alert alert = driver.switchTo().alert();
        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();
        // Displaying alert message
        System.out.println(alertMessage);
        implicitWait(20);
        // Accepting alert
        alert.accept();
    }

    public void robotTab6() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public void IncognitoMode(String Url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(Url);
        driver.manage().window().maximize();
        driver.quit();
    }

    public void switchWindows() {
        try {
            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandle = driver.getWindowHandles();
            for (String handle : windowHandle) {
                if (!(handle.equals(parentWindow))) {
                    driver.switchTo().window(parentWindow);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n*** Window Switch Failed ***");
        } finally {
            System.out.println(driver.getTitle());
        }
    }

    public void switchHandlesExample() {
        // Get Parent window handle
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            // Switch to child window
            driver.switchTo().window(winHandle);
        }
        // Do some operation on child window and get child window handle.
        String winHandleAfter = driver.getWindowHandle();
//switch to child window of 1st child window.
        for (String winChildHandle : driver.getWindowHandles()) {
            // Switch to child window of the 1st child window.
            if (!winChildHandle.equals(winHandleBefore)
                    && !winChildHandle.equals(winHandleAfter)) {
                driver.switchTo().window(winChildHandle);
            }
        }
// to switch to parent window.
        driver.switchTo().window(winHandleBefore);
    }

    public void openNewWindow(String Url) {
        ChromeDriver driver = new ChromeDriver();
        driver.get(Url);
    }

    public void assertEqualsGetCurrentUrl(String exp) {
        String act = driver.getCurrentUrl();
        Assert.assertEquals(act, exp, "\n*** Test Failed - Try Again ***");
    }

    public void assertTrueIsEnabled(String loc) {
        boolean act = driver.findElement(By.xpath(loc)).isEnabled();
        Assert.assertTrue(act, "\n*** Test Failed - Try Again ***");
    }

    public static void find(String locator) {
        try {
            driver.findElement(By.xpath(locator));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n*** First Attempt Failed ***");
            try {
                driver.findElement(By.cssSelector(locator));
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("\n*** Second Attempt Failed ***");
                try {
                    driver.findElement(By.id(locator));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    System.out.println("\n*** Third Attempt Failed ***");
                    try {
                        driver.findElement(By.className(locator));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        System.out.println("\n*** Final Attempt Failed ***");
                    }
                }
            }
        }
    }

    /**
     * Switch Tab To Default
     */

    public void switchTabToDefault() {
        List<String> tabs = List.copyOf(driver.getWindowHandles());
        try {
            driver.switchTo().window(tabs.get(0));
            waitTimeUsingFluent();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n*** TAB SWITCH FAILED ***");
            try {
                driver.switchTo().defaultContent();
                waitTimeUsingFluent();
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("\n*** DEFAULT TAB NOT FOUND ***");
            }
        }
    }
        public void click(String loc) {
            try {
                driver.findElement(By.xpath(loc)).click();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    driver.findElement(By.cssSelector(loc)).click();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
            public void sliderBarAction(WebElement slider){
                Actions actions = new Actions(driver);
                actions.clickAndHold(slider);
                actions.moveByOffset(40,0).build().perform();
}
            public void dragAndDrop(WebElement source, WebElement destination){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();

            }

}