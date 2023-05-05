package pages.Customer;

import drivers.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class AddNewCustomerPage {

    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT = "Customer Details";

    public By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    public By company = By.xpath("//input[@id='company']");
    public By vat = By.xpath("//input[@id='vat']");
    public By phoneNumber = By.xpath("//input[@id='phonenumber']");
    public By website = By.xpath("//input[@id='website']");
    public By dropdownGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    public By inputGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");
    private By currency = By.xpath("//button[@data-id='default_currency']");
    private By language = By.xpath("//button[@data-id='default_language']");
    private By address = By.xpath("//textarea[@id='address']");
    private By city = By.xpath("//input[@id='city']");
    private By state = By.xpath("//input[@id='state']");
    private By zipcode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//label[@for='country']/following-sibling::div");
    private By inputCountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");


    public void selectGroups(String groupName){
        WebUI.clickElement(dropdownGroups);
        WebUI.getWebElement(inputGroups).sendKeys(groupName, Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
    }
    public String gettextAlert () {
        Alert alert = DriverManager.getDriver().switchTo().alert();
        return alert.getText();
    }

    public void verifyAddCustomerPage() {
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), PAGE_URL, "URL chưa đúng trang NewCustomer.");
        Assert.assertTrue(WebUI.checkElementExist(tabCustomerDetail));
        Assert.assertEquals(WebUI.getTextElement(tabCustomerDetail),PAGE_TEXT, "Header label of New Customers page not match.");
    }

    public void AddDataNewCustomer(String customerName, String vatNo, String phoneNo, String websiteURL, String groupName, String addressCompany, String cityName, String stateName, String zipNo, String countryName ) {
        WebUI.waitForPageLoaded();

        WebUI.setText(company, customerName);
        WebUI.setText(vat, vatNo);
        WebUI.setText(phoneNumber, phoneNo);
        WebUI.setText(website, websiteURL);
        selectGroups(groupName);
        WebUI.setText(address, addressCompany);
        WebUI.setText(city, cityName);
        WebUI.setText(state, stateName);
        WebUI.setText(zipcode, zipNo);
        WebUI.getWebElement(inputCountry).sendKeys(countryName, Keys.ENTER);
        WebUI.clickElement(buttonSave);

        WebUI.waitForPageLoaded();
    }

}
