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
        int insertPos = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public boolean wordPattern(String pattern, String s) {
        char[] patternArray = pattern.toCharArray();
        String[] words = s.split(" ");

        if (patternArray.length != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < patternArray.length; i++) {
            if (charToWord.containsKey(patternArray[i]) && !Objects.equals(charToWord.get(patternArray[i]), words[i])) {
                return false;
            }

            if (wordToChar.containsKey(words[i]) && !Objects.equals(wordToChar.get(words[i]), patternArray[i])) {
                return false;
            }

            charToWord.put(patternArray[i], words[i]);
            wordToChar.put(words[i], patternArray[i]);
        }

        return true;
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 4 == 0) {
            n /= 4;
        }

        return n == 1;
    }

    public void reverseString(char[] s) {
        int j = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> vowels = new ArrayList<>();

        for (char c : chars) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        int index = vowels.size() - 1;

        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = vowels.get(index--);
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(String.valueOf(c));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] result = new int[resultSet.size()];
        int j = 0;
        for (int i : resultSet) {
            result[j++] = i;
        }

        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            int count = counts.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                counts.put(num, count - 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        long start = 1;
        long end = num;

        while (start < end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;

            if (square > num) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        start--;
        return start * start == num;
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (guess(mid) == 0) {
                return mid;
            }

            else if (guess(mid) == 1) {
                start = mid + 1;
            }

            else {
                end = mid;
            }
        }

        return start;
    }

    private int guess(int n) {
        return -1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> chars = new ArrayList<>();

        for (char c : magazine.toCharArray()) {
            chars.add(c);
        }

        for (char c : ransomNote.toCharArray()) {
            Character ch = c;
            if (chars.contains(ch)) {
                chars.remove(ch);
            }
            else {
                return false;
            }
        }

        return true;
    }

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) == i && s.indexOf(s.charAt(i)) == i) {
                return i;
            }
        }

        return -1;
    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!counts.containsKey(c) || counts.get(c) == 0) {
                return c;
            }
            counts.put(c, counts.get(c) - 1);
        }

        return ' ';
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        int i = 0;

        for (int j = 0; j < t.length(); j++) {
            if (s.length() > i) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
            }
        }

        return i == s.length();
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sum(root, false);
    }

    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && isLeft) {
            return root.val;
        }

        return sum(root.left, true) + sum(root.right, false);
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            }

            else if (i % 3 == 0) {
                result.add("Fizz");
            }

            else if (i % 5 == 0) {
                result.add("Buzz");
            }

            else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        if (set.size() < 3) {
            return set.last();
        }

        set.pollLast();
        set.pollLast();
        return set.last();
    }

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int digit2 = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public int countSegments(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }

        return s.trim().split("\\s+").length;
    }

    public int arrangeCoins(int n) {
        int rows = 0;
        int i = 1;

        while (n >= i) {
            n -= i;
            rows++;
            i++;
        }

        return rows;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];

        for (int num : nums) {
            seen[num] = true;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!seen[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < g.length && j < s.length) {
            if (g[i] >= s[j]) {
                count++;
                i++;
            }
            j++;
        }

        return count;
    }

    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) perimeter++;
                    if (i == rows - 1 || grid[i + 1][j] == 0) perimeter++;
                    if (j == 0 || grid[i][j - 1] == 0) perimeter++;
                    if (j == cols - 1 || grid[i][j + 1] == 0) perimeter++;
                }
            }
        }

        return perimeter;
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != '-') {
                str.append(c);
            }
        }

        String withoutDash = str.toString().toUpperCase();
        StringBuilder result = new StringBuilder();

        int count = 0;
        for (int i = withoutDash.length() - 1; i >= 0; i--) {
            if (count == k) {
                result.append('-');
                count = 0;
            }
            result.append(withoutDash.charAt(i));
            count++;
        }

        return result.reverse().toString();
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            }

            if (num == 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }

        max = Math.max(max, count);
        return max;
    }

    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);

        while (area % W != 0) {
            W--;
        }

        int L = area / W;

        return new int[]{L, W};
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        if (timeSeries.length == 1) return duration;
        if (duration == 0) return 0;

        int sum = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            sum += Math.min(diff, duration);
        }

        return sum + duration;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == nums2.length - 1) {
                res[i] = -1;
                continue;
            }

            boolean found = false;
            for (int j = map.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    found = true;
                    break;
                }
            }

            if (!found) {
                res[i] = -1;
            }
        }

        return res;
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (canType(word)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private boolean canType(String word) {
        String FIRST_ROW = "qwertyuiop";
        String SECOND_ROW = "asdfghjkl";
        String THIRD_ROW = "zxcvbnm";

        String normalizedWord = word.toLowerCase();

        char c = normalizedWord.charAt(0);

        if (FIRST_ROW.contains(String.valueOf(c))) {
            return wordFromOneRowKeyboard(normalizedWord, FIRST_ROW);
        }
        else if (SECOND_ROW.contains(String.valueOf(c))) {
            return wordFromOneRowKeyboard(normalizedWord, SECOND_ROW);
        }
        else {
            return wordFromOneRowKeyboard(normalizedWord, THIRD_ROW);
        }
    }

    private boolean wordFromOneRowKeyboard(String word, String symbolsKeyboardRow) {
        for (char c : word.toCharArray()) {
            if (!symbolsKeyboardRow.contains(String.valueOf(c))) {
                return false;
            }
        }

        return true;
    }
}