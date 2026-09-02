package Easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int digitsLength = digits.length;

        int lastNumber = digits[digitsLength - 1];

        if (lastNumber < 9) {
            digits[digitsLength - 1]++;
            return digits;
        }

        if (lastNumber == 9) {
            digits[digitsLength - 1] = 0;

            for (int i = digitsLength - 2; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                }
                else {
                    digits[i]++;
                    return digits;
                }
            }
        }

        int[] result = new int[digitsLength + 1];
        result[0] = 1;

        System.arraycopy(digits, 0, result, 1, digitsLength);

        return result;
    }
}
