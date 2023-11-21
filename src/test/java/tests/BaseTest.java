package tests;

import common.DriverInit;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static common.constants.Settings.RUNNING_BROWSER;

public class BaseTest {
    protected static WebDriver driver = DriverInit.getDriver(RUNNING_BROWSER);

    @Before
    public void setup() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new HomePage().openHomePage();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
