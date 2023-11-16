package tests;

import org.junit.Test;
import pages.HomePage;
import pages.OrderPage;
import pages.pageElements.Header;

import static common.constants.scooterOrderPage.RentPeriods.*;
import static common.constants.scooterOrderPage.ScooterColors.*;
import static common.constants.scooterOrderPage.Comments.*;
import static common.constants.scooterOrderPage.UserInfo.*;

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

    @Test
    public void makeOrderViaHomePage() {
        homePage.clickMakeOrderButton();
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
