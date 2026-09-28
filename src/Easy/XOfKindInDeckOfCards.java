package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class XOfKindInDeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        int g = 0;
        for (int c : map.values()) {
            g = gcd(g, c);
        }

        return g > 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
