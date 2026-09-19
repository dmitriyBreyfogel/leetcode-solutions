package Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }

            list.add(num);
            backtrack(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
