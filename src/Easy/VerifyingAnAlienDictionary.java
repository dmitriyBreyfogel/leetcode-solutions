package Easy;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i = 0; i < 26; i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrdered(words[i], words[i + 1], rank)) return false;
        }

        return true;
    }

    private boolean isOrdered(String first, String second, int[] rank) {
        int len = Math.min(first.length(), second.length());

        for (int i = 0; i < len; i++) {
            char a = first.charAt(i);
            char b = second.charAt(i);

            if (a != b) {
                return rank[a - 'a'] < rank[b - 'a'];
            }
        }

        return first.length() <= second.length();
    }
}
