package ElectronicsHome;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"Pritam", "Macbook"},
                {"George", "iPhone"},
                {"Achene", "Airpods"}
        };
    }
}
