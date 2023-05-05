package Testcases;

import common.BaseTest;
import pages.LoginPage;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginTestSuccess(){
        loginPage = new LoginPage();
        loginPage.login(PropertiesHelper.getValue("adminEmail"), PropertiesHelper.getValue("adminPassword"));
    }

    @Test
    public void loginTestInvalidEmail(){
        loginPage = new LoginPage();
        loginPage.loginInvalidEmail("admin@example.com123", PropertiesHelper.getValue("adminPassword"));
    }
    public void loginTestInvalidPassword(){
        loginPage = new LoginPage();
        loginPage.loginInvalidEmail(PropertiesHelper.getValue("adminEmail"), "54321");
    }
}
