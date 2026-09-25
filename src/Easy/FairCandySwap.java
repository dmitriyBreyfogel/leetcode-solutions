package Easy;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        for (int num : aliceSizes) sumA += num;

        int sumB = 0;
        for (int num : bobSizes) sumB += num;

        int diff = (sumA - sumB) / 2;

        Set<Integer> bobs = new HashSet<>();
        for (int num : bobSizes) {
            bobs.add(num);
        }

        for (int num : aliceSizes) {
            if (bobs.contains(num - diff)) {
                return new int[]{num, num - diff};
            }
        }

        return new int[0];
    }
}
