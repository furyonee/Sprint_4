package pages.page_elements;

import pages.BasePage;

import static common.constants.Url.ORDER_PAGE;
import static common.constants.scooter_order_page.OrderDetailInputs.INVALID_ORDER_NUMBER;

public class Header extends BasePage {
    private final String makeOrderButton = ".Header_Nav__AGCXC .Button_Button__ra12g";
    private final String yandexLogo = "Header_LogoYandex__3TSOI";
    private final String scooterLogo = "Header_LogoScooter__3lsAR";
    private final String orderStatusButton = "Header_Link__1TAG7";
    private final String orderNumberField = "Header_Input__xIoUq";
    private final String goButton = "Header_Button__28dPO";

    public Header clickMakeOrderButton() {
        click(findByCssSelector(makeOrderButton));
        assertCurrentUrlEquals(ORDER_PAGE);
        return this;
    }

    public Header clickYandexLogo() {
        click(findByClassName(yandexLogo));
        return this;
    }

    public Header clickScooterLogo() {
        click(findByClassName(scooterLogo));
        return this;
    }

    public Header clickOrderStatusButton() {
        click(findByClassName(orderStatusButton));
        return this;
    }

    public Header enterInvalidOrderNumber() {
        fillField(findByClassName(orderNumberField), INVALID_ORDER_NUMBER);
        return this;
    }

    public Header clickGoButton() {
        scrollTo(findByClassName(goButton));
        click(findByClassName(goButton));
        return this;
    }

    public void assertOrderNotExist() {
        assertTextNotFound("Курьер задерживается");
    }
}
