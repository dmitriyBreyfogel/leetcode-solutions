package Easy;

public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int absent = 0;
        int lateStreak = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absent++;
            }

            if (c == 'L') {
                lateStreak++;
            } else {
                lateStreak = 0;
            }

            if (absent >= 2 || lateStreak >= 3) {
                return false;
            }
        }

        return true;
    }
}
