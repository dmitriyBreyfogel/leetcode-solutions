package Easy;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length + 1];

        int duplicate = -1;
        int missing = -1;

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 2) duplicate = i;
            if (count[i] == 0) missing = i;
        }

        return new int[]{duplicate, missing};
    }
}
