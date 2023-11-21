package tests;

import org.junit.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.page_elements.Header;

import static common.constants.scooter_order_page.UserInfo.*;

public class OrderScooterTest extends BaseTest {
    Header header = new Header();
    OrderPage orderPage = new OrderPage();
    HomePage homePage = new HomePage();

    @Test
    public void makeOrderViaHomePage() {
        homePage.clickMakeOrderButton();
        orderPage.assertOrderPageIsOpened();
    }

    @Test
    public void inputErrorMessagesAppear() {
        homePage.clickMakeOrderButton();
        orderPage.clickNextButton()
                .fillAddress(INVALID_ADDRESS)
                .assertUserDetailInputsErrorMessagesAppear();
    }

    @Test
    public void incorrectOrderNumberShowsError() {
        header.clickOrderStatusButton()
                .enterInvalidOrderNumber()
                .clickGoButton()
                .assertOrderNotExist();
    }
}
