package ro.fortech.converter;

import java.util.Optional;

public class DateConverter {
    public static String DATE_FORMAT = "yyyymmdd";
    public static String VALUE_IGNORE = "9";
    public static String KES_FORMAT_END_OF_DATE = "000000";

    public static Optional<String> convertFromKesToISOdateFormat(String dateKes) {
        String date;
        date = dateKes.substring(DATE_FORMAT.length());
        if (date.substring(1).equals(VALUE_IGNORE)) {
            return Optional.empty();
        }
        return Optional.of(date);
    }

    public static Optional<String> convertFromISOtoKesFormat(String dateIso) {
        if (dateIso.substring(1).equals(VALUE_IGNORE))
            return Optional.empty();
        return Optional.of(dateIso + KES_FORMAT_END_OF_DATE);
    }
}
