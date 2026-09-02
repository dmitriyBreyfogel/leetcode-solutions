package Easy;

public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) == i && s.indexOf(s.charAt(i)) == i) {
                return i;
            }
        }

        return -1;
    }
}
