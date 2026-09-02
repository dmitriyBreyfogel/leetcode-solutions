package Easy;

public class ReverseWordsInString3 {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String string : strings) {
            result.append(new StringBuilder(string).reverse());
            result.append(" ");
        }

        return result.toString().trim();
    }
}
