package Easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        boolean search = true;
        int i = 0;
        int j = 0;
        while (search) {
            char[] symbols = new char[strs.length];

            for (String str : strs) {
                if (str.length() > i) {
                    symbols[j] = str.charAt(i);
                }
                j++;
            }

            j = 0;

            long nonEmptyCount = IntStream.range(0, symbols.length)
                    .map(k -> symbols[k])
                    .filter(c -> c != '\0')
                    .count();

            boolean allNonEmptyEqual = IntStream.range(0, symbols.length)
                    .map(k -> symbols[k])
                    .filter(c -> c != '\0')
                    .distinct()
                    .count() == 1;

            if (nonEmptyCount == strs.length && allNonEmptyEqual) {
                i++;
                result.append(symbols[0]);
                Arrays.fill(symbols, '\0');
            }
            else {
                search = false;
            }
        }

        return result.toString();
    }
}
