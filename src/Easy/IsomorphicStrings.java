package Easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        Map<Character, Character> ST = new HashMap<>();
        Map<Character, Character> TS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character cS = s.charAt(i);
            Character cT = t.charAt(i);

            if (ST.containsKey(cS)) {
                if (ST.get(cS) != cT) {
                    return false;
                }
            }
            else {
                ST.put(cS, cT);
            }

            if (TS.containsKey(cT)) {
                if (TS.get(cT) != cS) {
                    return false;
                }
            }
            else {
                TS.put(cT, cS);
            }
        }

        return true;
    }
}
