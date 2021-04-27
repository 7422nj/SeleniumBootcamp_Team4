package SoccerTestPage;

import SoccerHomePage.soccerHomePage;
import common.WebAPI;
import org.testng.Assert;
import org.testng.annotations.Test;


public class soccerTestPage extends WebAPI {

    soccerHomePage Soccer = new soccerHomePage();

    @Test(enabled = true)
    public void Soccer() throws Exception{
        Soccer.clickonSoccer();
        Assert.assertTrue(isTitleTrue("Soccer Teams, Scores, Stats, News, Fixtures, Results, Tables - ESPN"));
    }

    @Test(enabled = true)
    public void Score() throws Exception{
        Soccer.clickonScore();
        Assert.assertTrue(isTitleTrue("'Manchester City"));
    }

    @Test(enabled = false)
    public void Schedule() throws Exception{
        Soccer.clickonSchedule();
        Assert.assertTrue(isTitleTrue("LA GALAXY"));
    }

    @Test(enabled = false)
    public void Transfer() throws Exception{
        Soccer.clickonTransfer();
        Assert.assertTrue(isTitleTrue("Weston McKennie"));
    }

    @Test(enabled = false)
    public void Teams() throws Exception{
        Soccer.clickonTeams();
        Assert.assertTrue(isTitleTrue("Liverpool"));
    }







}
