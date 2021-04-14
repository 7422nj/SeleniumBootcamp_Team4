package HomePage.AirDataDriver;

import common.WebAPI;
import databases.ConnectToSqlDB;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.StaleElementReferenceException;
import utilities.DataReader;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static HomePage.HomePageWebElement.*;


public class DataSource extends WebAPI {

    public static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    public static DataReader excelReader = new DataReader();

    // Insert Data from into Database
    public static void insertDataIntoDB(){
        List<String> list = getItemValue();
        connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayListToSqlTable(list,"AirbnbItems","items");
    }

    //  From Class/ Same class
    public static List<String> getItemValue() {
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("Beach");
        itemsList.add("Views");
        itemsList.add("Travel");
        itemsList.add("Farm");
        itemsList.add("Cottage");
        itemsList.add("4846239282");
        itemsList.add("4381313181");
        return itemsList;
    }


    //Database
    public static List<String> getItemsListFromDB() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list = connectToSqlDB.readDataBase("AirbnbItems", "items");
        return list;
    }

    //Excel file
    public static List<String> getItemsListFromExcel() throws Exception, IOException, SQLException, ClassNotFoundException{
        String path = "../Airbnb/DataTest/Airbnb.xlsx";
        String[] myStringArray = excelReader.fileReader2(path, 0);
        for(int i=1;i<myStringArray.length; i++)
            System.out.println(myStringArray[i] + " ");
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < myStringArray.length; i++) {
            list.add(myStringArray[i]);
        }
        return list;
    }

    public static void enterExcelDataInSearchNRefreshAirbnb() throws IOException, AWTException, StaleElementReferenceException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prita\\IdeaProjects\\BootcampSelenium_Team4\\Generic\\BrowserDriver\\windows\\chromedriver.exe");
        File file = new File("../Airbnb/DataTest/Airbnb.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        find(WEB_ELEMENT_SEARCH_LOCATOR);
        for (int i = 1; i <= rowCount; i++) {
            if (i > rowCount) {
                wb.close();
            } else {
                wb.close();
                try {
                    typeOnElementNEnter(WEB_ELEMENT_SEARCH_LOCATOR, sheet.getRow(i).getCell(0).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            clickByXNCssUsingJavaScript(WEB_ELEMENT_BUTTON_SUBMIT_SEARCH);
            clickByXNCssUsingJavaScript(WEB_ELEMENT_AIRBNB_LOGO);
        }
        //Close
        wb.close();
    }
}
