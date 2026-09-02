package Easy;

import java.util.ArrayList;
import java.util.List;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> chars = new ArrayList<>();

        for (char c : magazine.toCharArray()) {
            chars.add(c);
        }

        for (char c : ransomNote.toCharArray()) {
            Character ch = c;
            if (chars.contains(ch)) {
                chars.remove(ch);
            }
            else {
                return false;
            }
        }

        return true;
    }
}
