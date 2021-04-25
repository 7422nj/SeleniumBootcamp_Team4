package HomeLoansTestPage;

import HomeLoansHomePage.HomeLoansLocators.*;
import HomeLoansHomePage.HomeLoansPage;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;


public class HomeLoanTest extends WebAPI {

    HomeLoansPage Loans = new HomeLoansPage();

    @Test
    public void HomeLoans() throws Exception{
        Loans.Homeloans();
        assertEqualsGetTitle("Update rates");
    }

    @Test
    public void Mortage() throws Exception{
        Loans.Mortage();
        assertEqualsGetTitle("View Rates");
    }

    @Test
    public void Apply() throws Exception{
        Loans.Apply();
        assertEqualsGetTitle("");
    }

    @Test
    public void Refinance() throws Exception{
        Loans.Refinance();
        assertEqualsGetTitle("View rates");
    }

    @Test
    public void Apply1() throws Exception{
        Loans.Apply1();
        assertEqualsGetTitle("No");
    }

    @Test
    public void HomeEquity() throws Exception{
        Loans.HomeEquity();
        assertEqualsGetTitle("Go");
    }
    @Test
    public void Specialest() throws Exception{
        Loans.Specialest();
        assertEqualsGetTitle("866.290.4674");
    }







}


