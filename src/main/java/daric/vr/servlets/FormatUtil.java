package daric.vr.servlets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
    public static String formatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        return dateFormat.format(date);
    }

    public static String formatMoney(Double sum) {
        return String.format("%.2f", sum);
    }
}
