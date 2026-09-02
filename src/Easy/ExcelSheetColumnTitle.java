package Easy;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber >= 26) {
            columnNumber--;
            char c = (char) ('A' + columnNumber % 26);
            sb.append(c);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}
