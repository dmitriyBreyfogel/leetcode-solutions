package Medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAdresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) return result;
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<String> result, List<String> parts, String input, int index) {
        if (parts.size() == 4) {
            if (index == input.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (index + len > input.length()) {
                break;
            }

            String part = input.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }

            if (Integer.parseInt(part) > 255) {
                continue;
            }

            parts.add(part);
            backtrack(result, parts, input, index + len);
            parts.removeLast();
        }
    }
}
