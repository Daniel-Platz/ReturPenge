import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SnackAutomateTest {
    @Test
    public void testValidBuy () {
        SnackAutomate automate = new SnackAutomate();
        int change = automate.buy(50, 100);
        assertEquals(50, change, "Skal være korrekt");
    }

    @Test
    public void testNegativePrice () {
        SnackAutomate automate = new SnackAutomate();
        assertThrows(IllegalArgumentException.class, () -> automate.buy(-10, 50),
                "Negative pris skal kaste en exception.");
    }

    @Test
    public void testNegativePaid() {
        SnackAutomate automate = new SnackAutomate();
        assertThrows(IllegalArgumentException.class, () -> automate.buy(10, -50),
                "Negative betalte beløb skal kaste en exception.");
    }

    @Test
    public void testPaidLessThanPrice() {
        SnackAutomate automate = new SnackAutomate();
        assertThrows(IllegalArgumentException.class, () -> automate.buy(50, 20),
                "Betalt mindre end pris skal kaste en exception.");
    }

    @Test
    public void testNoChange() {
        SnackAutomate automate = new SnackAutomate();
        int change = automate.buy(50, 50);
        assertEquals(0, change, "Hvis betalt beløb er lig med prisen, skal byttepengene være 0.");
    }

    @Test
    public void testValidChange() {
        SnackAutomate automate = new SnackAutomate();
        int amount = 53;
        int[] expected = {2, 1, 0, 1, 1};
        assertArrayEquals(expected, automate.change(amount),
                "Change for 53 should be 2x20, 1x10, 0x5, 1x2, 1x1.");
    }

    @Test
    public void testExactChange() {
        SnackAutomate automate = new SnackAutomate();
        int amount = 20;
        int[] expected = {1, 0, 0, 0, 0};
        assertArrayEquals(expected, automate.change(amount),
                "Change for 20 should be 1x20, 0x10, 0x5, 0x2, 0x1.");
    }

    @Test
    public void testSmallestDenomination() {
        SnackAutomate automate = new SnackAutomate();
        int amount = 1;
        int[] expected = {0, 0, 0, 0, 1};
        assertArrayEquals(expected, automate.change(amount),
                "Change for 1 should be 0x20, 0x10, 0x5, 0x2, 1x1.");
    }

    @Test
    public void testGetCoins() {
        SnackAutomate automate = new SnackAutomate();
        int[] expectedCoins = {20, 10, 5, 2, 1};
        assertArrayEquals(expectedCoins, automate.getCoins(),
                "The available coins should be 20, 10, 5, 2, and 1.");
    }

    @Test
    public void testNoChangeNeeded() {
        SnackAutomate automate = new SnackAutomate();
        int amount = 0;
        int[] expected = {0, 0, 0, 0, 0};
        assertArrayEquals(expected, automate.change(amount),
                "No change should result in 0x20, 0x10, 0x5, 0x2, 0x1.");
    }
}