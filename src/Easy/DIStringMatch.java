package Easy;

public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int len = s.length();

        int[] result = new int[len + 1];

        int min = 0;
        int max = len;
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == 'I') result[index++] = min++;
            else result[index++] = max--;
        }

        result[len] = min;
        return result;
    }
}
