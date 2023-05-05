package pages.Project;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProjectPage {
    // Project Page Objects
    private String PAGE_URL = "https://crm.anhtester.com/admin/projects";
    private String PAGE_TEXT = "Projects Summary";

    private By headerPageProjects = By.xpath("(//div[@class='panel-body']//h4)[1]");
    private By buttonNewProject = By.xpath("//a[normalize-space()='New Project']");

    private By inputSearch = By.xpath("//input[@class='form-control input-sm']");
    private By columnProjectOntable = By.xpath("//tbody/tr[1]/td[3]/a");


    public void verifyProjectPage() {
        Assert.assertEquals(WebUI.getCurrentUrl(), PAGE_URL, "URL chưa đúng trang Projects.");
        Assert.assertTrue(WebUI.checkElementExist(headerPageProjects), "Header Page Project not existing.");
        Assert.assertEquals(WebUI.getTextElement(headerPageProjects), PAGE_TEXT, "Header Page of Project page not match.");

    }
    public AddNewProjectPage openAddNewProjectPage(){
        WebUI.clickElement(buttonNewProject);
        WebUI.waitForPageLoaded();
        return new AddNewProjectPage();
    }
    public void enterSearchCustomer(String customerName){
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearch,customerName );
        WebUI.sleep(2);
    }
}
