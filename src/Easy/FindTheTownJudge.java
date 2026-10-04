package Easy;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] trustedMe = new int[n + 1];
        int[] trusted = new int[n + 1];

        for (int[] ints : trust) {
            trustedMe[ints[0]]++;
            trusted[ints[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustedMe[i] == 0 && trusted[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
