package Easy;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;

        boolean isDecreasing = false;
        boolean isIncreasing = false;

        if (nums[0] > nums[nums.length - 1]) isDecreasing = true;
        else isIncreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (isDecreasing) {
                if (nums[i] > nums[i - 1]) return false;
            }

            if (isIncreasing) {
                if (nums[i] < nums[i - 1]) return false;
            }
        }

        return true;
    }
}
