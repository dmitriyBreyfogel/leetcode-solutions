package Easy;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int k = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
