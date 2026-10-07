package Easy;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        char[] chars = binary.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') chars[i] = '1';
            else chars[i] = '0';
        }

        String resultString = new String(chars);
        return Integer.parseInt(resultString, 2);
    }
}
