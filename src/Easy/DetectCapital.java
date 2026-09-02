package Easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.isEmpty()) return false;
        if (word.length() == 1) return true;

        boolean allUpper = true;
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isUpperCase(word.charAt(i))) {
                allUpper = false;
            }
        }

        if (allUpper) return true;

        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) return false;
        }

        return true;
    }
}
