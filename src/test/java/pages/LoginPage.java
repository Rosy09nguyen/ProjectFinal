package pages;

import helpers.PropertiesHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import static keywords.WebUI.*;

public class LoginPage {
    // Login page Objects

    private String PAGE_URL = "https://crm.anhtester.com/admin/authentication";
    private String PAGE_TEXT = "Login";

    By headerPage = By.xpath("//h1");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By messageErrorEmail = By.xpath("//div[@class='text-center alert alert-danger']");


    public void verifyHeaderPage() {
        Assert.assertEquals(WebUI.getTextElement(headerPage), PAGE_TEXT, "FAIL. Header not match.");
    }

    public void verifyErrorMessageDisplay() {
        Assert.assertTrue(WebUI.getWebElement(messageErrorEmail).isDisplayed(), "FAIL. Error message no displays.");
        Assert.assertEquals(WebUI.getTextElement(messageErrorEmail), "Invalid email or password", "FAIL. Content of the Error message not match.");

    }

    public void enterEmail(String email) {

        WebUI.setText(inputEmail, email);
    }

    public void enterPassword(String password) {

        WebUI.setText(inputPassword, password);
    }

    public void clickOnLoginButton() {

        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage login(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        Assert.assertTrue(verifyElementNotPresent(messageErrorEmail, 5), "Login không thành công.");
        return new DashboardPage();
    }

    public void loginInvalidEmail(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        //Kểm tra message thông báo lỗi khi sai email
        verifyErrorMessageDisplay();
    }

    public void loginInvalidPassword(String email, String password) {
        WebUI.openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
        //Kểm tra message thông báo lỗi khi sai email
        verifyErrorMessageDisplay();
    }
}
