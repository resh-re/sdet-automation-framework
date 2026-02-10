package base;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        attachFailureScreenshot();
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachFailureScreenshot() {
        try { return ScreenshotUtil.png(); }
        catch (Exception e) { return new byte[0]; }
    }
}
