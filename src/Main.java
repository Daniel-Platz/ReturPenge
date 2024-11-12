public class Main {
    public static void main(String[] args) {

        SnackAutomate automate = new SnackAutomate();

        int price = 47;
        int paid = 100;

        try {
            // Step 1: Buy the snack and calculate change amount
            int changeAmount = automate.buy(price, paid);
            System.out.println("Beløb " + changeAmount + " kr");

            // Step 2: Calculate the breakdown of coins
            int[] coinCounts = automate.change(changeAmount);
            int[] coins = automate.getCoins();

            // Step 3: Display the breakdown of coins
            for (int i = 0; i < coins.length; i++) {
                System.out.println("Antal " + coins[i] + " kr: " + coinCounts[i]);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}