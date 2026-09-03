package Medium;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] result = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) result[i] = new StringBuilder();

        int j = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            result[j].append(c);

            if (j == 0 || j == numRows - 1) goingDown = !goingDown;

            j += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(result[i].toString());
        }

        return res.toString();
    }
}
