package common.constants.scooter_order_page;

import java.util.concurrent.ThreadLocalRandom;

import static common.Support.generateRandomStringValue;

public class UserInfo {
    public static final String FIRST_NAME = generateRandomStringValue();
    public static final String LAST_NAME = generateRandomStringValue();
    public static final String ADDRESS = generateRandomStringValue();
    public static final String PHONE_NUMBER = String.valueOf(ThreadLocalRandom.current().nextLong(10000000000L, 100000000000L));

    public static final String INVALID_ADDRESS = " ";
}
