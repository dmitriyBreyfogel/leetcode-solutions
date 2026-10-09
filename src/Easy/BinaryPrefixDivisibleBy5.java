package Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<String> strings = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
            strings.add(sb.toString());
        }

        List<Boolean> list = new ArrayList<>();
        for (String string : strings) {
            long value = Long.parseLong(string, 2);
            if (value % 5 != 0) list.add(false);
            else list.add(true);
        }

        return list;
    }
}
