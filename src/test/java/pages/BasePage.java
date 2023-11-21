package pages;

import common.DriverInit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.constants.Settings.RUNNING_BROWSER;

public class BasePage {
    protected static WebDriver driver = DriverInit.getDriver(RUNNING_BROWSER);

    public void click(WebElement element) {
        element.click();
    }

    public void fillField(WebElement field, String value) {
        field.sendKeys(value);
    }

    public WebElement findByXpath(String value) {
        return driver.findElement(By.xpath(value));
    }

    public WebElement findByClassName(String value) {
        return driver.findElement(By.className(value));
    }

    public WebElement findByCssSelector(String value) {
        return driver.findElement(By.cssSelector(value));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void findDisplayedText(String... text) {
        for (String s : text) {
            WebElement textValue = findByXpath(String.format("//*[text()='%s']", s));
            textValue.isDisplayed();
        }
    }

    public void assertTextNotFound(String... text) {
        List<WebElement> textElements = driver.findElements(By.xpath(String.format("//*[text()='%s']", text)));
        Assert.assertEquals(0, textElements.size());
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void assertCurrentUrlEquals(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
