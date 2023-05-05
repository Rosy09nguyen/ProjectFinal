package Testcases;

import common.BaseTest;
import dataproviders.DataCustomer;
import helpers.PropertiesHelper;
import org.testng.annotations.Test;
import pages.Customer.AddNewCustomerPage;
import pages.Customer.CustomerDetailPage;
import pages.Customer.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.Hashtable;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customersPage;
    AddNewCustomerPage addCustomerPage;
    CustomerDetailPage customerDetailPage;

    // add new customer độc lập
    @Test(dataProvider = "data_provider_addCustomer_excel", dataProviderClass = DataCustomer.class)
    public void addNewCustomer_singleTest(String customerName, String vatNo, String phoneNo, String websiteURL, String groupName, String addressCompany, String cityName, String stateName, String zipNo, String countryName) {

        loginPage = new LoginPage();
        dashboardPage = loginPage.login(PropertiesHelper.getValue("adminEmail"), PropertiesHelper.getValue("adminPassword"));
        customersPage = dashboardPage.openCustomerPage();

        //Verify Customer page load successfully
        customersPage.verifyCustomersPage();
        //Open New Customer Page
        addCustomerPage = customersPage.openAddNewCustomerPage();

        addCustomerPage.AddDataNewCustomer(customerName, vatNo, phoneNo, websiteURL, groupName, addressCompany, cityName, stateName, zipNo, countryName);

        //Mở lại trang Customer
        dashboardPage.openCustomerPage();
        //Search giá trị Customer vừa Add
        customersPage.searchCustomer(customerName);
        //Click vào giá trị Customer Name dòng đầu tiên
        customerDetailPage = customersPage.clickOnFirstRowCustomerName();
        //Check Customer Detail
        customerDetailPage.checkCustomerDetail(customerName);

    }

    // add new customer workflow, sử dụng 1 row value trong file data excel
    @Test(dataProvider = "data_provider_addCustomer_excel_custom_row", dataProviderClass = DataCustomer.class)
    public void addNewCustomer_workFlowTest(Hashtable<String, String> data) {

        dashboardPage = new DashboardPage();
        customersPage = dashboardPage.openCustomerPage();

        //Verify Customer page load successfully
        customersPage.verifyCustomersPage();
        //Open New Customer Page
        addCustomerPage = customersPage.openAddNewCustomerPage();

        addCustomerPage.AddDataNewCustomer(data.get("CUSTOMER NAME"), data.get("VAT NUMBER"),data.get("PHONE NUMBER"),data.get("WEBSITE"), data.get("GROUP"), data.get("ADDRESS"), data.get("CITY"),data.get("STATE"), data.get("ZIPCODE"), data.get("COUNTRY NAME"));

        //Mở lại trang Customer
        dashboardPage.openCustomerPage();
        //Search giá trị Customer vừa Add
        customersPage.searchCustomer(data.get("CUSTOMER NAME"));
        //Click vào giá trị Customer Name dòng đầu tiên
        customerDetailPage = customersPage.clickOnFirstRowCustomerName();
        //Check Customer Detail
        customerDetailPage.checkCustomerDetail(data.get("CUSTOMER NAME"));

    }
}
