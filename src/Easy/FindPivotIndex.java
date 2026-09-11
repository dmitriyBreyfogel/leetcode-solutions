package Easy;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += i != 0 ? nums[i - 1] : 0;
            if (left == sum - left - nums[i]) return i;
        }

        return -1;
    }
}
