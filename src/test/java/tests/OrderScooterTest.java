package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;
import pages.OrderPage;
import pages.page_elements.Header;

import static common.constants.scooter_order_page.RentPeriods.*;
import static common.constants.scooter_order_page.ScooterColors.*;
import static common.constants.scooter_order_page.Comments.*;
import static common.constants.scooter_order_page.UserInfo.*;

@RunWith(Parameterized.class)
public class OrderScooterTest extends BaseTest {
    Header header = new Header();
    OrderPage orderPage = new OrderPage();
    HomePage homePage = new HomePage();

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String rentPeriod;
    private String color;
    private String comment;

    public OrderScooterTest(
            String firstName,
            String lastName,
            String address,
            String phoneNumber,
            String rentPeriod,
            String color,
            String comment
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rentPeriod = rentPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters()
    public static Object[][] getOrderDetails() {
        return new Object[][]{
                {FIRST_NAME, LAST_NAME, ADDRESS, PHONE_NUMBER, ONE_DAY, BLACK, COMMENT},
                {FIRST_NAME, LAST_NAME, ADDRESS, PHONE_NUMBER, SIX_DAYS, GREY, EMPTY_COMMENT}
        };
    }

    @Test
    public void makeOrderViaHeader() {
        header.clickMakeOrderButton();
        orderPage.fillOrderFields(
                        firstName,
                        lastName,
                        address,
                        phoneNumber,
                        rentPeriod,
                        color,
                        comment
                )
                .clickConfirmOrder()
                .assertOrderConfirmationWindowAppeared();
    }

    @Test
    public void makeOrderViaHomePage() {
        homePage.clickMakeOrderButton();
        orderPage.fillOrderFields(
                        firstName,
                        lastName,
                        address,
                        phoneNumber,
                        rentPeriod,
                        color,
                        comment
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
