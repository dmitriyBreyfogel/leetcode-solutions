package Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char ch : s.toCharArray()){
            arr[ch] += 1;
        }

        int length = 0;
        boolean odd = false;
        for (int i : arr){
            length += (i / 2) * 2;
            if(i % 2 != 0){
                odd = true;
            }
        }
        return odd ? length + 1 : length ;
    }
}
