package pages.Customer;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

import static keywords.WebUI.*;

public class CustomerPage {
    // Customers Page Objects
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    private By headerPageCustomers = By.xpath("(//div[@class='panel-body']//h4)[1]");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//div[@class='_buttons']//a[normalize-space()='Contacts']");
    private By inputSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input");
    private By tdCustomerName = By.xpath("//table[@id='DataTables_Table_0']//tbody/tr[1]/td[3]/a");

    //Các hàm xử lý cho chức năng thuộc Customers Page

    public void verifyCustomersPage() {
        Assert.assertEquals(WebUI.getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Customers.");
        Assert.assertTrue(WebUI.checkElementExist(headerPageCustomers), "Header Page Customers not existing.");
        Assert.assertEquals(WebUI.getTextElement(headerPageCustomers), PAGE_TEXT, "Header Page of Customers page not match.");

    }

    public AddNewCustomerPage openAddNewCustomerPage(){
        WebUI.clickElement(buttonAddCustomer);
        return new AddNewCustomerPage();
    }

    public void searchCustomer(String companyName){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearch, companyName);
        WebUI.sleep(2);
    }

    public CustomerDetailPage clickOnFirstRowCustomerName(){
        WebUI.waitForPageLoaded();
        WebUI.clickElement(tdCustomerName);

        return new CustomerDetailPage();
    }
}
