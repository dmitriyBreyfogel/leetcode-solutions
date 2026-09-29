package Easy;

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        int nameLen = name.length();
        int typedLen = typed.length();
        while (i < nameLen && j < typedLen) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }
            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }

        if (i < nameLen) return false;

        while (j < typedLen) {
            if (typed.charAt(j) != typed.charAt(j - 1)) return false;
            j++;
        }

        return true;
    }
}
