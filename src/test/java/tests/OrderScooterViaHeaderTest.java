package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.OrderPage;
import pages.page_elements.Header;

import static common.constants.scooter_order_page.Comments.*;
import static common.constants.scooter_order_page.RentPeriods.*;
import static common.constants.scooter_order_page.ScooterColors.*;
import static common.constants.scooter_order_page.UserInfo.*;

@RunWith(Parameterized.class)
public class OrderScooterViaHeaderTest extends BaseTest {
    Header header = new Header();
    OrderPage orderPage = new OrderPage();

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String rentPeriod;
    private String color;
    private String comment;

    public OrderScooterViaHeaderTest(
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
                {FIRST_NAME_ALTERNATIVE, LAST_NAME_ALTERNATIVE, ADDRESS_ALTERNATIVE, PHONE_NUMBER_ALTERNATIVE, SIX_DAYS, GREY, EMPTY_COMMENT}
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
}
