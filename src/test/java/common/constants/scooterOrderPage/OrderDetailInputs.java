package common.constants.scooterOrderPage;

public class OrderDetailInputs {
    private static final String masterSelector = ".Order_Form__17u6u .Input_InputContainer__3NykH";
    public static final String FIRST_NAME_INPUT_CONTAINER = masterSelector + ":nth-child(1)";
    public static final String LAST_NAME_INPUT_CONTAINER = masterSelector + ":nth-child(2)";
    public static final String ADDRESS_INPUT_CONTAINER = masterSelector + ":nth-child(3)";
    public static final String SUBWAY_STATION_INPUT_ERROR_CONTAINER = ".Order_UnderError__1VSDB";
    public static final String PHONE_NUMBER_INPUT_CONTAINER = masterSelector + ":nth-child(5)";

    public static final String FIRST_NAME_FIELD = FIRST_NAME_INPUT_CONTAINER + " [type='text']";
    public static final String LAST_NAME_FIELD = LAST_NAME_INPUT_CONTAINER + " [type='text']";
    public static final String ADDRESS_FIELD  = ADDRESS_INPUT_CONTAINER + " [type='text']";
    public static final String SUBWAY_STATION_FIELD = "select-search__value";
    public static final String PHONE_NUMBER_FIELD = PHONE_NUMBER_INPUT_CONTAINER + " [type='text']";
}
