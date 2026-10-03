package Easy;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int i = nums.length - 1;
        while (left < right) {
            int leftAbs = Math.abs(nums[left]);
            int rightAbs = Math.abs(nums[right]);
            if (rightAbs > leftAbs) {
                result[i--] = rightAbs * rightAbs;
                right--;
            }
            else if (rightAbs == leftAbs) {
                result[i--] = rightAbs * rightAbs;
                result[i--] = leftAbs * leftAbs;
                left++;
                right--;
            }
            else {
                result[i--] = leftAbs * leftAbs;
                left++;
            }
        }

        if (i != -1)
            result[i] = nums[left] * nums[left];

        return result;
    }
}
