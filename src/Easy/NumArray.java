package Easy;

class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }
}

/**
 * Your Easy.NumArray object will be instantiated and called as such:
 * Easy.NumArray obj = new Easy.NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */