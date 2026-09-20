package Easy;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String transformed;

            if (isVowel(word.charAt(0))) {
                transformed = word + "ma";
            } else {
                transformed = word.substring(1) + word.charAt(0) + "ma";
            }

            transformed += "a".repeat(i + 1);

            if (i > 0) result.append(" ");
            result.append(transformed);
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return  c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U';
    }
}
