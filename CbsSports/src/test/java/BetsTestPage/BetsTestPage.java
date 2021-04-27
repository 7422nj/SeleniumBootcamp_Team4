package BetsTestPage;

import BetHomePage.BetHomePage;
import common.WebAPI;
import java.awt.*;
import org.testng.Assert;
import static BetHomePage.BetLocators.*;
import org.testng.annotations.Test;

import static BetHomePage.BetLocators.*;

public class BetsTestPage extends WebAPI {

    BetHomePage Bet = new BetHomePage();

    @Test(enabled = false)
    public void Bet() throws Exception{
        Bet.Bet();
        assertEqualsGetTitle("Football Betting Online | William Hill Virginia Sportsbook, America's #1 Sportsbook");
    }

    @Test(enabled = false)
    public void Basketball() throws Exception{
        Bet.Basketball();
        Assert.assertTrue(isTitleTrue("Chicago Bulls"));
    }
    @Test(enabled = false)
    public void Baseball() throws Exception{
        Bet.Baseball();
        Assert.assertTrue(isTitleTrue("San Francisco Giants"));
    }

    @Test(enabled = false)
    public void Hockey() throws Exception{
        Bet.Hockey();
        Assert.assertTrue(isTitleTrue("\"Nashville Predators'\""));
    }
    @Test(enabled = false)
    public void Golf() throws Exception{
        Bet.Golf();
      Assert.assertTrue(isTitleTrue("J Rahm/R Palmer\""));
    }

    @Test(enabled = false)
    public void Futures() throws Exception{
        Bet.Futures();
        Assert.assertTrue(isTitleTrue("Play"));
    }

    @Test(enabled = false)
    public void Inplay() throws Exception{
        Bet.Inplay();
        Assert.assertTrue(isTitleTrue("Play"));
    }






}
