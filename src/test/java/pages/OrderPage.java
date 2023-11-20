package pages;

import common.Support;
import org.junit.Assert;

import static common.constants.Url.ORDER_PAGE;
import static common.constants.scooter_order_page.Errors.*;
import static common.constants.scooter_order_page.OrderDetailInputs.*;

public class OrderPage extends BasePage {
    private final String firstSubwayStationTitle = ".select-search__options > li > [value='1']";
    private final String nextButton = ".Order_NextButton__1_rCA .Button_Button__ra12g";
    private final String deliveryDateField = "react-datepicker__input-container";
    private final String datePicker = "[aria-label='Choose %s']";
    private final String rentPeriodField = "Dropdown-root";
    private final String commentField = ".Order_Form__17u6u .Input_InputContainer__3NykH .Input_Input__1iN_Z";
    private final String orderButton = ".Button_Inverted__3IF-i + button";
    private final String confirmOrderButton = ".//*[@class='Order_Buttons__1xGrp']/*[text()='Да']";

    public void fillFirstName(String firstName) {
        fillField(findByCssSelector(FIRST_NAME_FIELD), firstName);
    }

    public void fillLastName(String lastName) {
        fillField(findByCssSelector(LAST_NAME_FIELD), lastName);
    }

    public OrderPage fillAddress(String address) {
        fillField(findByCssSelector(ADDRESS_FIELD), address);
        return this;
    }

    public void selectFirstSubwayStation() {
        click(findByClassName(SUBWAY_STATION_FIELD));
        click(findByCssSelector(firstSubwayStationTitle));
    }

    public void fillPhoneNumber(String phoneNumber) {
        fillField(findByCssSelector(PHONE_NUMBER_FIELD), phoneNumber);
    }

    public OrderPage clickNextButton() {
        click(findByCssSelector(nextButton));
        return this;
    }

    public void selectDeliveryDate() {
        click(findByClassName(deliveryDateField));
        click(findByCssSelector(String.format(datePicker, Support.getNextDayDate())));
    }

    public void selectRentPeriod(String period) {
        click(findByClassName(rentPeriodField));
        click(findByCssSelector(period));
    }

    public void selectScooterColor(String color) {
        click(findByCssSelector(color));
    }

    public void addComment(String comment) {
        fillField(findByCssSelector(commentField), comment);
    }

    public void clickOrderButton() {
        click(findByCssSelector(orderButton));
    }

    public OrderPage clickConfirmOrder() {
        click(findByXpath(confirmOrderButton));
        return this;
    }

    public OrderPage assertOrderConfirmationWindowAppeared() {
        findDisplayedText(
                "Заказ оформлен",
                "Номер заказа: ",
                ".  Запишите его: ",
                "пригодится, чтобы отслеживать статус"
        );
        return this;
    }

    public OrderPage fillOrderFields(
            String firstName,
            String lastName,
            String address,
            String phoneNumber,
            String rentPeriod,
            String color,
            String comment
    ) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillAddress(address);
        selectFirstSubwayStation();
        fillPhoneNumber(phoneNumber);
        clickNextButton();
        selectDeliveryDate();
        selectRentPeriod(rentPeriod);
        selectScooterColor(color);
        addComment(comment);
        clickOrderButton();
        return this;
    }

    public OrderPage assertUserDetailInputsErrorMessagesAppear() {
        Assert.assertEquals(findByCssSelector(FIRST_NAME_INPUT_CONTAINER).getText(), FIRST_NAME_INPUT_ERROR_MESSAGE);
        Assert.assertEquals(findByCssSelector(LAST_NAME_INPUT_CONTAINER).getText(), LAST_NAME_INPUT_ERROR_MESSAGE);
        Assert.assertEquals(findByCssSelector(ADDRESS_INPUT_CONTAINER).getText(), ADDRESS_INPUT_ERROR_MESSAGE);
        Assert.assertEquals(findByCssSelector(SUBWAY_STATION_INPUT_ERROR_CONTAINER).getText(), SUBWAY_STATION_INPUT_ERROR_MESSAGE);
        Assert.assertEquals(findByCssSelector(PHONE_NUMBER_INPUT_CONTAINER).getText(), PHONE_NUMBER_INPUT_ERROR_MESSAGE);
        return this;
    }

    public void assertOrderPageIsOpened() {
        assertCurrentUrlEquals(ORDER_PAGE);
        findDisplayedText("Для кого самокат");
    }
}
