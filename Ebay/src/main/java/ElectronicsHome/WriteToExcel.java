package ElectronicsHome;

import common.WebAPI;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WriteToExcel extends WebAPI {
    public static void main(String[] args) throws IOException{

        //set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prita\\IdeaProjects\\BootcampSelenium_Team4\\Generic\\BrowserDriver\\windows\\chromedriver.exe");

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

        //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();

        //Navigate to the URL
        driver.get("https://home.modernhealthcare.com/clickshare/forceLogin.do?CSAuthReq=1&CSTargetURL=https%3A//www.modernhealthcare.com/topic/bold-moves&adobe_mc=MCMID%3D67645620837495927003890767416651796956%7CMCORGID%3D138FFF2554E6E7220A4C98C6%2540AdobeOrg%7CTS%3D1617815577");


        //Identify the WebElements for the student registration form
        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));




        //iterate over all the rows in Excel and put data in the form.
        for(int i=1;i<=rowCount;i++) {
            //Enter the values read from Excel in firstname,lastname,mobile,email,address
            username.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
            password.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
//            email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
//            mobile.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
//            address.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());

//            //Click on the gender radio button using javascript
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", genderMale);

            //Click on submit button
            clickOnElement("//button[@id='login-submit']",driver);
//            submitBtn.click();

            //Verify the confirmation message
            WebElement confirmationMessage = driver.findElement(By.xpath("//li[@class='error']"));

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

//            //close the confirmation popup
//            WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
//            closebtn.click();

            //wait for page to come back to registration page after close button is clicked
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        }

        //Close the workbook
        wb.close();

        //Quit the driver
        driver.quit();
    }
}
