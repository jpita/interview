package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

/**
 */
public class BaseTest {
    private static ChromeDriverService service;
    protected WebDriver driver;

    @BeforeMethod
    public void createDriver() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("chromedriver229"))
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        driver.get("https://app.es.sageone.com/login");
//        driver.manage().window().setSize(new Dimension(1300,1000));

    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

}
