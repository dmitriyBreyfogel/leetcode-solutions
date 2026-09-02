package Easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> types = new HashSet<>();
        for (int j : candyType) {
            types.add(j);
        }

        int canEat = n / 2;
        int typesCount = types.size();

        return Math.min(canEat, typesCount);
    }
}
