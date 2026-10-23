package Medium;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        return generate(1, n, memo);
    }

    private int generate(int left, int right, int[] memo) {
        if (left > right) return 1;

        int size = (right - left) + 1;
        if (memo[size] != 0) return memo[size];

        int count = 0;
        for (int i = left; i <= right; i++) {
            int leftCount = generate(left, i - 1, memo);
            int rightCount = generate(i + 1, right, memo);

            count += leftCount * rightCount;
        }

        memo[size] = count;
        return count;
    }
}
