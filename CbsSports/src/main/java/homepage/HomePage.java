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
        public void enterPassword() throws IOException {
            //Creating an object of ChromeDriver
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.cbssports.com/login?xurl=https%3A%2F%2Fwww.cbssports.com%2F");
            driver.manage().window().maximize();
            //Create an object of File class to open xls file
            File file =    new File("C:\\Users\\prita\\IdeaProjects\\BootcampSelenium_Team4\\Ebay\\src\\test\\resources\\test_data\\test_data.xlsx");

            //Create an object of FileInputStream class to read excel file
            FileInputStream inputStream = new FileInputStream(file);

            //creating workbook instance that refers to .xls file
            XSSFWorkbook wb=new XSSFWorkbook(inputStream);

            //creating a Sheet object
            XSSFSheet sheet=wb.getSheet("STUDENT_DATA");

            //get all rows in the sheet
            int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

            //Identify the WebElements for the student registration form
            clickByXNCssUsingJavaScript("//input[@id='userid']");////input[@id='userid']
            WebElement username=driver.findElement(By.xpath("//input[@id='userid']"));
            clickByXNCssUsingJavaScript("//label[contains(text(),'Password')]");
            WebElement password=driver.findElement(By.xpath("//label[contains(text(),'Password')]"));


            //iterate over all the rows in Excel and put data in the form.
            for(int i=1;i<=rowCount;i++) {
                //Enter the values read from Excel in firstname,lastname,mobile,email,address
                username.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
                password.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());

                //Click on submit button
                clickOnElement("//input[@name='_submit']",driver);
//            submitBtn.click();

                //Verify the confirmation message
                WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='formErrorSummary']"));

                //create a new cell in the row at index 6
                XSSFCell cell = sheet.getRow(i).createCell(6);

                //check if confirmation message is displayed
                if (confirmationMessage.isDisplayed()) {
                    // if the message is displayed , write PASS in the excel sheet
                    cell.setCellValue("PASS");

                } else {
                    //if the message is not displayed , write FAIL in the excel sheet
                    cell.setCellValue("FAIL");
                }

                // Write the data back in the Excel file
                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\prita\\IdeaProjects\\BootcampSelenium_Team4\\Ebay\\src\\test\\resources\\test_data\\test_data.xlsx");
                wb.write(outputStream);

                //wait for page to come back to registration page after close button is clicked
                driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            }
            //Close the workbook
            wb.close();
            driver.close();
        }

        }


























