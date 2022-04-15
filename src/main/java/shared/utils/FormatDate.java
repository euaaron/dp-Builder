package shared.utils;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {

    /**
     * @return A string with today's date formatted as dd/MM/yyyy
     */
    public static String now() {
        return from(new Date());
    }

    /**
     * @param date a Date object
     * @return The given Date as a string formatted as dd/MM/yyyy
     */
    public static @NotNull String from(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return formatter.format(date);
    }
}
