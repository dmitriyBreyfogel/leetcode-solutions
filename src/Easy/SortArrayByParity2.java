package Easy;

public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int odd = 0;
        int even = 1;

        while (odd < len && even < len) {
            if (nums[odd] % 2 == 0) {
                odd += 2;
            }
            else if (nums[even] % 2 == 1) {
                even += 2;
            }
            else {
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
                odd += 2;
                even += 2;
            }
        }

        return nums;
    }
}
