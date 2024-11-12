public class SnackAutomate {

    private int[] coins;

    // Initialize the available coins
    public SnackAutomate() {
        coins = new int[]{20, 10, 5, 2, 1};
    }

    // Method to buy a product
    public int buy(int price, int paid) throws IllegalArgumentException {
        if (price < 0 || paid < 0) {
            throw new IllegalArgumentException("Beløb og pris må ikke være negative.");
        }
        if (paid < price) {
            throw new IllegalArgumentException("Betalt beløb er mindre end prisen.");
        }
        return paid - price;
    }

    // Method to return change with as few coins as possible
    public int[] change(int amount) {
        int[] coinCounts = new int[coins.length]; // To store counts of each coin type

        for (int i = 0; i < coins.length; i++) {
            coinCounts[i] = amount / coins[i]; // Calculate how many coins of this type
            amount %= coins[i]; // Reduce the amount by the total value of these coins
        }

        return coinCounts;
    }

    // Getter
    public int[] getCoins() {
        return coins;
    }
}