package tests;

import org.junit.Test;
import pages.HomePage;
import pages.pageElements.Header;

public class LogosRedirectingTest extends BaseTest {
    Header header = new Header();
    HomePage homePage = new HomePage();

    @Test
    public void scooterLogoGoesToMainPage() {
        header.clickMakeOrderButton()
                .clickScooterLogo();
        homePage.assertHomePageIsOpened();
    }

    @Test
    public void yandexLogoGoesToMainPage() {
        header.clickYandexLogo();
        homePage.assertMainYandexPageIsOpened();
    }
}
