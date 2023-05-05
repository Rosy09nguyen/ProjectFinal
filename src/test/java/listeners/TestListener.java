package listeners;

import com.aventstack.extentreports.Status;
import helpers.CaptureHelper;
import helpers.PropertiesHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.LogUtils;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext result) {
        PropertiesHelper.loadAllFiles();

    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("End testing " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Running test case " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        //Screenshot khi fail
        CaptureHelper.captureScreenshot(result.getName());
        LogUtils.error(result.getThrowable().toString());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is skipped.");
        LogUtils.error(result.getThrowable().toString());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LogUtils.error("Đây là test case bị Fail nhưng có phần Success: " + result.getName());
        LogUtils.error(result.getThrowable().toString());
    }
}
