package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Support {
    public static String getNextDayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrowDate = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("EEEE, d-е MMMM yyyy г.");
        return format.format(tomorrowDate);
    }


    public static String generateRandomStringValue() {
        final String cyrillicAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        StringBuilder stringBuilder = new StringBuilder(10);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(cyrillicAlphabet.length());
            stringBuilder.append(cyrillicAlphabet.charAt(index));
        }

        return stringBuilder.toString();
    }
}
