package Easy;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() == 1) return 0;

        int count = 0;
        int prev = 0;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            }
            else {
                if (prev != 0) {
                    count += Math.min(prev, cur);
                }
                prev = cur;
                cur = 1;
            }
        }

        count += Math.min(prev, cur);

        return count;
    }
}
