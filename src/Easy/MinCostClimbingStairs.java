package Easy;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int prev = cost[0];
        int curr = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int tmp = cost[i] + Math.min(prev, curr);
            prev = curr;
            curr = tmp;
        }

        return Math.min(prev, curr);
    }
}
