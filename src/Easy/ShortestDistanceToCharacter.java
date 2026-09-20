package Easy;

public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] result = new int[len];

        int prev = -(2 * len);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) prev = i;
            result[i] = i - prev;
        }

        prev = 2 * len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) prev = i;
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }
}
