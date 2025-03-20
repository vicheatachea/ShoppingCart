import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {

    public static double calculateItemCost(double price, int quantity) {
        return price * quantity;
    }


    public static void main(String[] args) {
        System.out.println("Select a language:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();


        Locale locale;
        switch (choice) {
            case 1:
                locale = new Locale("en", "US");
                break;
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                System.out.println("Invalid language selection. Defaulting to English.");
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            System.out.println("Invalid language selection. Defaulting to English.");
            rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        }

        System.out.println(rb.getString("items"));
        int items = scanner.nextInt();
        double totalCost = 0;

        for (int i = 1; i <= items; i++) {
            System.out.println(rb.getString("price"));
            double price = scanner.nextDouble();
            System.out.println(rb.getString("quantity"));
            int quantity = scanner.nextInt();

            double itemCost = calculateItemCost(price, quantity);
            totalCost += itemCost;
        }

        String output = MessageFormat.format(rb.getString("total"), String.format("%.2f", totalCost));

        System.out.println(rb.getString("total") + output);

        scanner.close();
    }
}
