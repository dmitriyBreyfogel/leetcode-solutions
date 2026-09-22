package Easy;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() == 1) return false;
        if (s.length() != goal.length()) return false;

        int count = 0;
        char[] charsFirst = new char[2];
        char[] charsSecond = new char[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(i)) continue;
            count++;

            if (count == 1) {
                charsFirst[0] = s.charAt(i);
                charsSecond[0] = goal.charAt(i);
            }
            else if (count == 2) {
                charsFirst[1] = s.charAt(i);
                charsSecond[1] = goal.charAt(i);
            }
            else {
                return false;
            }
        }

        if (count == 2) {
            return charsFirst[0] == charsSecond[1] && charsFirst[1] == charsSecond[0];
        }

        if (count == 0) {
            boolean[] seen = new boolean[26];
            for (char c : s.toCharArray()) {
                if (seen[c - 'a']) return true;
                seen[c - 'a'] = true;
            }
            return false;
        }

        return false;
    }
}
