import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    // EASY LEVEL
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int num : nums) {
            System.out.println(num);
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        if (x % 10 == 0) {
            return false;
        }

        int reverse = 0;
        int tmp = x;

        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return x == reverse;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int current = 0;
        int previous = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                throw new IllegalArgumentException();
            }

            current = map.get(c);

            if (current > previous) {
                result += current - previous;
            }
            else {
                result += current;
            }

            previous = current;
        }

        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        boolean search = true;
        int i = 0;
        int j = 0;
        while (search) {
            char[] symbols = new char[strs.length];

            for (String str : strs) {
                if (str.length() > i) {
                    symbols[j] = str.charAt(i);
                }
                j++;
            }

            j = 0;

            long nonEmptyCount = IntStream.range(0, symbols.length)
                    .map(k -> symbols[k])
                    .filter(c -> c != '\0')
                    .count();

            boolean allNonEmptyEqual = IntStream.range(0, symbols.length)
                    .map(k -> symbols[k])
                    .filter(c -> c != '\0')
                    .distinct()
                    .count() == 1;

            if (nonEmptyCount == strs.length && allNonEmptyEqual) {
                i++;
                result.append(symbols[0]);
                Arrays.fill(symbols, '\0');
            }
            else {
                search = false;
            }
        }

        return result.toString();
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                switch (c) {
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                        break;
                }
            }
        }

        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }
            else if (list1.val > list2.val) {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
            else {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return dummy.next;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;

        int k = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();

        if (needleLen == 0) {
            return -1;
        }

        return haystack.indexOf(needle);
    }

    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);

        if (index < 0) {
            index = -index - 1;
        }

        return index;
    }

    public int lengthOfLastWord(String s) {
        String[] parts = s.split(" ");

        return parts[parts.length - 1].length();
    }

    public int[] plusOne(int[] digits) {
        int digitsLength = digits.length;

        int lastNumber = digits[digitsLength - 1];

        if (lastNumber < 9) {
            digits[digitsLength - 1]++;
            return digits;
        }

        if (lastNumber == 9) {
            digits[digitsLength - 1] = 0;

            for (int i = digitsLength - 2; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                }
                else {
                    digits[i]++;
                    return digits;
                }
            }
        }

        int[] result = new int[digitsLength + 1];
        result[0] = 1;

        System.arraycopy(digits, 0, result, 1, digitsLength);

        return result;
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            if (aIndex >= 0) {
                carry += a.charAt(aIndex--) - '0';
            }
            if (bIndex >= 0) {
                carry += b.charAt(bIndex--) - '0';
            }
            sb.append(carry % 2);
            carry = carry / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;
        int tmp = 0;

        while (left != right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            }
            else if (square < x) {
                System.out.println(mid);
                tmp = mid;
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return tmp;
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }

        return second;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy.next;

       while (pre.next != null) {
           if (pre.val == pre.next.val) {
               pre.next = pre.next.next;
           }
           else {
               pre = pre.next;
           }
       }
       return dummy.next;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
            else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }

                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }

            result.add(row);
        }

        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rect = generate(rowIndex + 1);
        return rect.get(rowIndex);
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public boolean isPalindrome(String s) {
        String text = s.replaceAll("[^a-zA-Zа-яёА-ЯЁ0-9\\s]", "").toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            if (i == text.length() - i - 1) {
                break;
            }

            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static String[] stringToArray(String s) {
        return s.split(" ");
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }

            visited.add(head);
            head = head.next;
        }

        return false;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        else if (lengthB > lengthA) {
            int diff = lengthB - lengthA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber >= 26) {
            columnNumber--;
            char c = (char) ('A' + columnNumber % 26);
            sb.append(c);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public int titleToNumber(String columnTitle) {
        if (columnTitle.isEmpty()) {
            return 0;
        }

        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            result += result * 26 + (c - 'A' + 1);
        }

        return result;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }

        return n == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            }
            else {
                prev = cur;
            }

            cur = cur.next;
        }

        return dummy.next;
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        Map<Character, Character> ST = new HashMap<>();
        Map<Character, Character> TS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character cS = s.charAt(i);
            Character cT = t.charAt(i);

            if (ST.containsKey(cS)) {
                if (ST.get(cS) != cT) {
                    return false;
                }
            }
            else {
                ST.put(cS, cT);
            }

            if (TS.containsKey(cT)) {
                if (TS.get(cT) != cS) {
                    return false;
                }
            }
            else {
                TS.put(cT, cS);
            }
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int prev = nums[0];
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev != 1) {
                if (start == prev) {
                    result.add(String.valueOf(start));
                }
                else {
                    result.add(start + "->" + prev);
                }
                start = nums[i];
            }
            prev = nums[i];
        }

        if (start == prev) {
            result.add(String.valueOf(start));
        }
        else {
            result.add(start + "->" + prev);
        }

        return result;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        }

        return isPowerOfTwo(n/2);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            return true;
        }

        ListNode reverse = reverse(slow.next);

        if (reverse == null) {
            return head == slow;
        }

        while (reverse != null) {
            if (head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        path(root, "", result);
        return result;
    }

    public void path(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path +  root.val);
            return;
        }

        if (root.left != null) {
            path(root.left, path + root.val + "->", result);
        }

        if (root.right != null) {
            path(root.right, path + root.val + "->", result);
        }
    }

    public int addDigits(int num) {
        int sum = sum(num);

        if (sum < 9) {
            return sum;
        }

        return addDigits(sum);
    }

    private int sum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }

    public int missingNumber(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            if (nums[0] == 0) {
                return 0;
            }

            return 1;
        }

        Arrays.sort(nums);

        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }

        return length;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }

    boolean isBadVersion(int version) {
        return true;
    }

    public void moveZeroes(int[] nums) {

    }
}


