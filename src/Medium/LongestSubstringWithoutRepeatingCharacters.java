package Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        Set<Character> seen = new HashSet<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (seen.contains(c)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
