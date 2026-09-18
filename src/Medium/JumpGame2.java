package Medium;

public class JumpGame2 {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) return 0;

        int jumps = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i != end) continue;

            jumps++;
            end = max;
            if (end >= len - 1) break;
        }

        return jumps;
    }
}
