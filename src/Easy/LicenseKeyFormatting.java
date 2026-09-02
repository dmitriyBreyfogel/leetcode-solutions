package Easy;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != '-') {
                str.append(c);
            }
        }

        String withoutDash = str.toString().toUpperCase();
        StringBuilder result = new StringBuilder();

        int count = 0;
        for (int i = withoutDash.length() - 1; i >= 0; i--) {
            if (count == k) {
                result.append('-');
                count = 0;
            }
            result.append(withoutDash.charAt(i));
            count++;
        }

        return result.reverse().toString();
    }
}
