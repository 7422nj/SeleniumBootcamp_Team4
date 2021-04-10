package homepagetest;

import common.WebAPI;
import homepage.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends WebAPI {

    //////////////////////////////////////////////////////////////////////////////////////////////////////

   //initialized HomePage or create and object of the HomePage class  in HomePageTest in order to access elements
    HomePage homePage = new HomePage();

    //////////////////////////////////////////////////////////////////////////////////////////////////////


@Test
    public void tesDosearch(){
        homePage.doSearch("telephones");

}






}