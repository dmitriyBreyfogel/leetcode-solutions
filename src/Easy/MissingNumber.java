package Easy;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            if (nums[0] == 0) {
                return 0;
            }

            return 1;
        }

        Arrays.sort(nums);

        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }

        return length;
    }
}
