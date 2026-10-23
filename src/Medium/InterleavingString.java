package Medium;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, memo);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        int index = i + j;

        if (index == s3.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean result = false;

        if (i < s1.length() && s3.charAt(index) == s1.charAt(i)) result = dfs(s1, s2, s3, i + 1, j, memo);
        if (!result && j < s2.length() && s3.charAt(index) == s2.charAt(j)) result = dfs(s1, s2, s3, i, j + 1, memo);

        memo[i][j] = result;
        return result;
    }
}
