package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        if (intervals.length == 1) return new int[][]{intervals[0]};

        List<int[]> mergedIntervals = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            else {
                mergedIntervals.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        mergedIntervals.add(new int[]{start, end});
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
