package Easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) end = j;
                else break;
            }

            if (end - start >= 2) result.add(List.of(start, end));
            i = end;
        }

        return result;
    }
}
