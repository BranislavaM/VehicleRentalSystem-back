package vehicle_rental_system;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {
    private static DecimalFormat decimalFormat = new DecimalFormat("$0.00");
	private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static String formatCurrency(double amount) {
        return decimalFormat.format(amount);
    }
    
    public static String formatDate(LocalDate date) {
        return dateFormat.format(date);
    }
}
