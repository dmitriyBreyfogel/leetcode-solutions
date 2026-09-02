package Easy;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int rows = 0;
        int i = 1;

        while (n >= i) {
            n -= i;
            rows++;
            i++;
        }

        return rows;
    }
}
