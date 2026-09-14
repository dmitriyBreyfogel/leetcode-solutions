package Medium;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        return say(countAndSay(n-1));
    }

    public String say(String str) {
        if (str.length() == 1) return "1" + str;

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i != str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            }
            else {
                sb.append(count);
                sb.append(str.charAt(i));
                count = 1;
            }
        }

        return sb.toString();
    }
}
