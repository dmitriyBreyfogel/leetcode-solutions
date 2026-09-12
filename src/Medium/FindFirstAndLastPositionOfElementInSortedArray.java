package Medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = leftIndex(nums, target);
        if (left >= nums.length || nums[left] != target) return new int[]{-1, -1};

        int right = rightIndex(nums, target);
        if (right < 0 || nums[right] != target) return new int[]{-1, -1};

        return new int[]{left, right};
    }

    private int leftIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }

    private int rightIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }

        return end;
    }
}
