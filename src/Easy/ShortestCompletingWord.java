package Easy;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] required = new int[26];
        int requiredLength = 0;

        for (char c : licensePlate.toCharArray()) {
            c = Character.toLowerCase(c);

            if (c >= 'a' && c <= 'z') {
                required[c - 'a']++;
                requiredLength++;
            }
        }

        String answer = null;
        for (String word : words) {
            if (answer != null && word.length() >= answer.length()) continue;

            if (word.length() < requiredLength) continue;

            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < required[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) answer = word;
        }

        return answer;
    }
}
