package pages.Project;

import drivers.DriverManager;
import keywords.WebUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddNewProjectPage {
    // Add new Project Page Objects
    private String PAGE_URL = "https://crm.anhtester.com/admin/projects/project";
    private String PAGE_TEXT = "Add new project";

    private By headerPageAddNewProjects = By.xpath("//div[@class='content']//h4");
    private By headerTabProject = By.xpath("//div[@class='horizontal-tabs']//li[1]");
    private By inputProjectName = By.id("name");
    private By dropdownCustomer = By.xpath("//label[@for='clientid']/following-sibling::div");
    private By inputSearchCustomer = By.xpath("//label[@for='clientid']/following-sibling::div//input[@type='search']");
    private By selectValueCustomer = By.xpath("//label[@for='clientid']/following-sibling::div//a)[1]");

    private By dropdownBillingType = By.xpath("//label[@for='billing_type']/following-sibling::div[2]");
    private By dropdownStatus = By.xpath("//label[@for='status']/following-sibling::div[2]");
    private By inputEstimatedHour = By.id("estimated_hours");
    private By dropdownMember = By.xpath("//label[@for='project_members[]']/following-sibling::div");
    private By inputSearchMember = By.xpath("//label[@for='project_members[]']/following-sibling::div//input[@type='search']");
    private By inputStartDate = By.id("start_date']");
    private By inputDeadline = By.id("deadline");
    private By inputTag = By.xpath("//label[normalize-space()='Tags']/following-sibling::ul//input");
    private By iframeDescription = By.xpath("//body");
    private By checkboxSendEmail = By.id("send_created_email");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");

    //Hàm xử lý
    public void selectCustomer (String customerName) {
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomer,customerName);
        WebUI.clickElement(selectValueCustomer);
    }

    public void selectBillingType (String billingType) {
        WebUI.clickElement(dropdownBillingType);
        By selectBillingType = By.xpath("//label[@for='billing_type']/following-sibling::div[2]//a[contains(.,'"+ billingType + "')]");
        WebUI.clickElement(selectBillingType);
    }

    public void selectStatus (String status) {
        WebUI.clickElement(dropdownStatus);
        By selectStatus = By.xpath("//label[@for='status']/following-sibling::div[2]//a[contains(.,' "+ status +"')]");
        WebUI.clickElement(selectStatus);
    }

    public void selectMember (String member) {
        WebUI.clickElement(dropdownMember);
        WebUI.setText(inputSearchMember, member);
        WebUI.getWebElement(inputSearchMember).sendKeys(member, Keys.ENTER);
        WebUI.clickElement(dropdownMember);
    }

    public void enterDescription (String description) {
        DriverManager.getDriver().switchTo().frame("description_ifr");
        WebUI.setText(iframeDescription, description);
        DriverManager.getDriver().switchTo().parentFrame();
    }

    public String gettextAlert () {
        Alert alert = DriverManager.getDriver().switchTo().alert();
        return alert.getText();
    }

    public void verifyAddNewProjectPage() {
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), PAGE_URL, "URL chưa đúng trang NewCustomer.");
        Assert.assertTrue(WebUI.checkElementExist(headerPageAddNewProjects));
        Assert.assertEquals(WebUI.getTextElement(headerPageAddNewProjects), PAGE_TEXT, "Header Page of New Project page not match.");
    }

    public void addNewProject(String projectName, String customerName, String billingType, String status, String estimatedHour, String member, String startDate, String deadLine, String tag, String description) {
        WebUI.setText(inputProjectName, projectName);
        selectCustomer(customerName);
        WebUI.sleep(1);
        selectBillingType(billingType);
        WebUI.sleep(1);
        selectBillingType(status);
        WebUI.sleep(1);
        WebUI.setText(inputEstimatedHour, estimatedHour);
        selectMember(member);
        WebUI.sleep(1);
        WebUI.setText(inputStartDate, startDate);
        WebUI.setText(inputDeadline, deadLine);
        WebUI.setText(inputTag, tag);
        enterDescription(description);
        WebUI.clickElement(buttonSave);
        WebUI.waitForPageLoaded();
        Assert.assertEquals(gettextAlert(),"Project added successfully.","message wrong");
    }
}
