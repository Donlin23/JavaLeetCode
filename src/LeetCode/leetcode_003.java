package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Donlin
 * @Date: Created in 15:28 2018/8/9
 * @Version: 1.0
 * @Description: Given a string, find the length of the longest substring without repeating characters.
 * @Link: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 */
public class leetcode_003 {
    public static void main(String[] args) {
        String s = "dddweu";
        System.out.println(lengthOfLongestSubstringFromBestLeetCode(s));
    }

    public static int lengthOfLongestSubstring(String s){
        if (s.isEmpty())
            return 0;
        int MaxCount = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            int count = 1;
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))){
                    count++;
                    set.add(s.charAt(j));
                }else {
                    set.clear();
                    break;
                }
            }
            MaxCount = Math.max(MaxCount,count);
            if (s.length() - i < MaxCount){
                break;
            }
        }
        return MaxCount;
    }

    // Excellent! Nice thought!
    public static int lengthOfLongestSubstringFromBestLeetCode(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
