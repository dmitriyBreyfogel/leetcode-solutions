package Easy;

public class FindIndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();

        if (needleLen == 0) {
            return -1;
        }

        return haystack.indexOf(needle);
    }
}
