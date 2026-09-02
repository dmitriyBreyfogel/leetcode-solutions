package Easy;

import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int current = 0;
        int previous = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                throw new IllegalArgumentException();
            }

            current = map.get(c);

            if (current > previous) {
                result += current - previous;
            }
            else {
                result += current;
            }

            previous = current;
        }

        return result;
    }
}
