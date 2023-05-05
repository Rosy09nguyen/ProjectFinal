package pages;

import keywords.WebUI;
import pages.Customer.CustomerPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static keywords.WebUI.*;

public class DashboardPage {
    // Dashboard Page Objects
    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";

    By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    By buttonOptionDashboard = By.xpath("//div[@class='screen-options-btn']");


    public void verifyDashboardPage() {
        //Kiểm tra URL chứa phần thuộc trang DB
        //Kiểm tra Text hoặc Object chỉ có trang DB có
        Assert.assertEquals(WebUI.getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Dashboard.");
        Assert.assertTrue(WebUI.checkElementExist(buttonOptionDashboard), "Dashboard Options not existing.");
    }

    //Hàm xử lý
    public CustomerPage openCustomerPage() {
        WebUI. waitForPageLoaded();
        WebUI.clickElement(menuCustomer);
        return new CustomerPage();
    }
}
