package dataproviders;

import helpers.ExcelHelper;
import helpers.PropertiesHelper;
import helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataCustomer {
    // Tạo data provider đọc tất cả các dòng trong file excel
    @DataProvider(name = "data_provider_addCustomer_excel")
    public Object[][] dataAddCustomerFromExcel() {
        ExcelHelper excelHelpers = new ExcelHelper();
        Object[][] data = excelHelpers.getExcelData(SystemHelper.getCurrentDir() + PropertiesHelper.getValue("dataPath"), PropertiesHelper.getValue("CustomerSheet"));
        System.out.println("Customer Data from Excel: " + data);
        return data;
    }

    // Tạo data provider đọc các dòng trong file excel theo chỉ định
    @DataProvider(name = "data_provider_addCustomer_excel_custom_row")
    public Object[][] dataAddCustomerFromExcelCustomRow() {
        ExcelHelper excelHelpers = new ExcelHelper();
        Object[][] data = excelHelpers.getDataHashTable(SystemHelper.getCurrentDir() + PropertiesHelper.getValue("dataPath"), PropertiesHelper.getValue("CustomerSheet"), 1, 1);
        System.out.println("Customer Data from Excel: " + data);
        return data;
    }
}
