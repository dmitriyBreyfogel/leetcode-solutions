package Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> current, int start, int end, int k) {
        if (current.size() == k) {
            list.add(current);
            return;
        }

        for (int i = start; i <= end; i++) {
            current.add(i);
            backtrack(list, current, i + 1, end, k);
            current.remove(current.size() - 1);
        }
    }
}
