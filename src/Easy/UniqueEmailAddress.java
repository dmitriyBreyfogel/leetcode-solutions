package Easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String transform = transform(email);
            set.add(transform);
        }

        return set.size();
    }

    private String transform(String email) {
        int index = email.indexOf("@");
        String local = email.substring(0, index);
        String domain = email.substring(index + 1);

        int plusIndex = local.indexOf("+");
        if (plusIndex != -1) local = local.substring(0, plusIndex);

        local = local.replace(".", "");

        return local + "@" + domain;
    }
}
