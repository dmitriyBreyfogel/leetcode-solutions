package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < min) {
                    res.clear();
                    min = map.get(list2[i]) + i;
                    res.add(list2[i]);
                }
                else if (map.get(list2[i]) + i == min) {
                    res.add(list2[i]);
                }
            }
        }

        return res.toArray(new String[0]);
    }
}
