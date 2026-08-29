public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        /*
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        solution.twoSum(nums, 9);

        String[] strs = new String[]{"ab", "a"};

        solution.isPalindrome(121);
        solution.romanToInt("MCMXCIV");
        System.out.println(solution.longestCommonPrefix(strs));
        System.out.println(solution.isValid("({[]})"));

        ListNode head = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode head3 = new ListNode(0);
        head.next = head2;

        ListNode result = solution.mergeTwoLists(head, head3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }*/

        /*System.out.println(solution.addBinary("10111", "11"));
        System.out.println(solution.mySqrt(2147395599));

        int[] tmp1 = new int[] {
                1,2,3,0,0,0
        };
        int m = 3;
        int[] tmp2 = new int[] {
                2,5,6
        };
        int n = 3;

        solution.merge(tmp1, m, tmp2, n);

        for (int i = 0; i < m + n; i++) {
            System.out.println(tmp1[i]);
        }
        */

        // System.out.println(solution.isIsomorphic("badc", "baba"));
        /*int[] nums = new int[] {
                3, 0, 1
        };

        System.out.println(solution.missingNumber(nums));*/

        //System.out.println(solution.countSegments("Hello, my name is John"));

        //System.out.println(solution.arrangeCoins(8));

        int[] nums = new int[] {
                4,3,2,7,8,2,3,1
        };

        solution.findDisappearedNumbers(nums);
    }
}
