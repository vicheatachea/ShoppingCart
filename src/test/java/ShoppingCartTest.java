import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testCalculateItemCost() {
        double price = 10.0;
        int quantity = 2;
        double expectedCost = 20.0;
        double actualCost = ShoppingCart.calculateItemCost(price, quantity);
        assertEquals(expectedCost, actualCost, 0.001);
    }

    @Test
    public void testCalculateItemCostZeroQuantity() {
        double price = 1.0;
        int quantity = 0;
        double expectedCost = 0.0;
        double actualCost = ShoppingCart.calculateItemCost(price, quantity);
        assertEquals(expectedCost, actualCost, 0.001);
    }

    @Test
    public void testCalculateTotalCost() {
        double[] prices = {10.0, 20.0, 30.0};
        int[] quantities = {1, 2, 3};
        double expectedTotalCost = 140.0;
        double actualTotalCost = 0.0;

        for (int i = 0; i < prices.length; i++) {
            actualTotalCost += ShoppingCart.calculateItemCost(prices[i], quantities[i]);
        }

        assertEquals(expectedTotalCost, actualTotalCost, 0.001);
    }
}