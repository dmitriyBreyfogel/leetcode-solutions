package Easy;

public class NumberOfLinesToWriteString {
    private final static int MAX_WIDTH = 100;

    public int[] numberOfLines(int[] widths, String s) {
        int countStrings = 0;

        int width = 0;
        for (char ch : s.toCharArray()) {
            int nWidth = widths[ch - 'a'];
            if (width + nWidth > MAX_WIDTH) {
                width = nWidth;
                countStrings++;
                continue;
            }

            width += nWidth;
        }

        if (width != 0) countStrings++;

        return new int[]{countStrings, width};
    }
}
