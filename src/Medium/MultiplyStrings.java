package Medium;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int firstLen = num1.length();
        int secondLen = num2.length();

        int[] sumLine = new int[firstLen + secondLen];
        for (int i = firstLen - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = secondLen - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int sum = sumLine[i + j + 1] + mul + carry;
                sumLine[i + j + 1] = sum % 10;
                carry = sum / 10;
            }

            sumLine[i] += carry;
        }

        StringBuilder result = new StringBuilder();
        for (int num : sumLine) {
            if (!(result.isEmpty() && num == 0))
                result.append(num);
        }

        return result.isEmpty() ? "0" : result.toString();
    }
}
