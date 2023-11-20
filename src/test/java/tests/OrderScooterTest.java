package tests;

import org.junit.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.page_elements.Header;

import static common.constants.scooter_order_page.Comments.*;
import static common.constants.scooter_order_page.RentPeriods.*;
import static common.constants.scooter_order_page.ScooterColors.*;
import static common.constants.scooter_order_page.UserInfo.*;


public class OrderScooterTest extends BaseTest {
    Header header = new Header();
    OrderPage orderPage = new OrderPage();
    HomePage homePage = new HomePage();

    @Test
    public void makeOrderViaHeader() {
        header.clickMakeOrderButton();
        orderPage.fillOrderFields(
                FIRST_NAME,
                        LAST_NAME,
                        ADDRESS,
                        PHONE_NUMBER,
                        ONE_DAY,
                        BLACK,
                        COMMENT
                )
                .clickConfirmOrder()
                .assertOrderConfirmationWindowAppeared();
    }

    // Если это то, чего требует задание, то это какой-то ужас
    // Если нет, то тогда я вообще не понимаю что требуется
    @Test
    public void makeOrderViaHeaderWithDifferentTestData() {
        header.clickMakeOrderButton();
        orderPage.fillOrderFields(
                        FIRST_NAME,
                        LAST_NAME,
                        ADDRESS,
                        PHONE_NUMBER,
                        SIX_DAYS,
                        GREY,
                        EMPTY_COMMENT
                )
                .clickConfirmOrder()
                .assertOrderConfirmationWindowAppeared();
    }

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
