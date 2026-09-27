package Easy;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int i = 0;
        int j = len - 1;
        for (int num : nums) {
            if (num % 2 == 0) result[i++] = num;
            else result[j--] = num;
        }

        return result;
    }
}
