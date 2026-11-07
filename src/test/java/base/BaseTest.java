package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");

        driver = new ChromeDriver(options);
        // Explicit wait: 15 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                String status = "PASSED";
                if (result.getStatus() == ITestResult.FAILURE) {
                    status = "FAILED";
                } else if (result.getStatus() == ITestResult.SKIP) {
                    status = "SKIPPED";
                }

                File screenshotDir = new File(System.getProperty("user.dir") + File.separator + "screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();
                }

                File destination = new File(screenshotDir, result.getName() + "_" + status + "_" + System.currentTimeMillis() + ".png");
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
            } catch (Exception e) {
                System.err.println("Could not capture screenshot: " + e.getMessage());
            } finally {
                driver.quit();
            }
        }
    }

    public String takeScreenshot(String name) {
        if (driver != null) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);
                File screenshotDir = new File(System.getProperty("user.dir") + File.separator + "screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();
                }
                File destination = new File(screenshotDir, name + "_" + System.currentTimeMillis() + ".png");
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
                return destination.getAbsolutePath();
            } catch (Exception e) {
                System.err.println("Could not capture screenshot: " + e.getMessage());
            }
        }
        return null;
    }
}