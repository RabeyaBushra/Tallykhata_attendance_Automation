package TestRunner;


import Pages.LogInPage;
import SetUp.SetUp;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class LogInTestRunner extends SetUp {
    @Test
    public void userLogin() throws InterruptedException, IOException, ParseException {

        LogInPage logInPage = new LogInPage(driver);
        driver.get("https://hr.surecash.net/web/login");
        Utils utils = new Utils(driver);
        utils.readJSON();
        String Name=logInPage.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(Name.contains("Rabeya Bushra"));
        logInPage.setAttendance();
        logInPage.Check();
    }
}
