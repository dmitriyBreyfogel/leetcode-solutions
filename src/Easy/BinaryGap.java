package Easy;

public class BinaryGap {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);

        int lastOne = -1;
        int max = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (lastOne != -1) max = Math.max(max, i - lastOne);
                lastOne = i;
            }
        }

        return max;
    }
}
