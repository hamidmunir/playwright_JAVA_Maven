package com.playwright.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import com.playwright.utils.ExtentManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.List;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void initReport() {
        extent = ExtentManager.getInstance();
    }

   @BeforeMethod
    public void setup(Method method){

        //test = extent.createTest(method.getName());
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().
                setHeadless(false).
                setArgs(List.of("--start-maximized")).
                setSlowMo(100));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result){
       //Reporting logic
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            //take screenshot
            String screenshotPath = "/screenshots/" + result.getName() + ".png";
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(screenshotPath))
                    .setFullPage(true));
            test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else {
            test.skip("Test skipped");
        }


       //Browser cleanup
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
