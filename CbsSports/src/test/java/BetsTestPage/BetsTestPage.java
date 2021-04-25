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

    @Test(enabled = true)
    public void Bet() throws Exception{
        Bet.Bet();
        assertEqualsGetTitle("Football Betting Online | William Hill Virginia Sportsbook, America's #1 Sportsbook");
    }

    @Test(enabled = true)
    public void Basketball() throws Exception{
        Bet.Basketball();
        assertEqualsGetTitle("Chicago Bulls");
    }
    @Test
    public void Baseball() throws Exception{
        Bet.Baseball();
        assertEqualsGetTitle("San Francisco Giants");
    }

    @Test
    public void Hockey() throws Exception{
        Bet.Hockey();
        assertEqualsGetTitle("Nashville Predators'");
    }
    @Test
    public void Golf() throws Exception{
        Bet.Golf();
        assertEqualsGetTitle("J Rahm/R Palmer");
    }

    @Test
    public void Futures() throws Exception{
        Bet.Futures();
        assertEqualsGetTitle("Play");
    }

    @Test
    public void Inplay() throws Exception{
        Bet.Inplay();
        assertEqualsGetTitle("Play");
    }






}
