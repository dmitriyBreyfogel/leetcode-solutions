package Easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] parts = s.split(" ");

        return parts[parts.length - 1].length();
    }
}
