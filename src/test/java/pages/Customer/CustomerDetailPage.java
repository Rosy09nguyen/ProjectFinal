package pages.Customer;

import keywords.WebUI;
import org.testng.Assert;

import static keywords.WebUI.getAttributeElement;

public class CustomerDetailPage extends AddNewCustomerPage {
    // Customer Detail page Objects

    public void checkCustomerDetail(String customerName) {
        WebUI.waitForPageLoaded();
        // cần truyền data từ excel(chưa làm)
        System.out.println(getAttributeElement(company, "value"));
        System.out.println(getAttributeElement(vat, "value"));
        System.out.println(getAttributeElement(phoneNumber, "value"));

        Assert.assertEquals(getAttributeElement(company, "value"), customerName, "Company Name not match.");
        Assert.assertEquals(getAttributeElement(vat, "value"), "10", "VAT not match.");
        Assert.assertEquals(getAttributeElement(phoneNumber, "value"), "0123456789", "Phone Number not match.");

    }

}
