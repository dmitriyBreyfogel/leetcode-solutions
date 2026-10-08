package Easy;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;

        if (sum % 3 != 0) return false;
        int target = sum / 3;

        int parts = 0;
        int tmpSum = 0;
        for (int num : arr) {
            tmpSum += num;
            if (tmpSum == target) {
                parts++;
                tmpSum = 0;
            }
        }

        return parts >= 3;
    }
}
