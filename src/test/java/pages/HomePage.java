package pages;

import org.junit.Assert;

import java.util.Set;

import static common.constants.Url.*;

public class HomePage extends BasePage {
    private final String questionsListItem = "accordion__button";
    private final String questionsList = "accordion";
    private final String makeOrderButton = ".Home_RoadMap__2tal_ .Button_Button__ra12g";

    public HomePage assertHomePageIsOpened() {
        assertCurrentUrlEquals(BASE_URL);
        return this;
    }

    public HomePage openHomePage() {
        openPage(BASE_URL);
        findDisplayedText("Учебный тренажер");
        return this;
    }

    public HomePage expandQuestionsListItem(String text) {
        scrollTo(findByClassName(questionsList));
        findByXpath(String.format(".//*[@class='%s'][text()='%s']", questionsListItem, text)).click();
        return this;
    }

    public HomePage clickMakeOrderButton() {
        scrollTo(findByCssSelector(makeOrderButton));
        click(findByCssSelector(makeOrderButton));
        assertCurrentUrlEquals(ORDER_PAGE);
        return this;
    }

    public void assertMainYandexPageIsOpened() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        Assert.assertFalse(driver.getCurrentUrl().contains(BASE_URL));
    }
}
