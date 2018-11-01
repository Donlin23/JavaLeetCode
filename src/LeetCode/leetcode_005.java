package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 21:11 2018/11/1
 * @Version: 1.0
 * @Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * @Link: https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 */
public class leetcode_005 {
    public static void main(String[] args) {
        String s = "aababba";
        s = longestPalindrome(s);
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {
        // 给字符串的每个字符之间加入“#”，使字符串长度保持为奇数
        String new_s = addSomeMarks(s);
        // 求以每个字符为中心的最长回文子串的最右端字符与该字符的距离
        int[] len = new int[new_s.length()];
        int max = Integer.MIN_VALUE;
        int flag = 0;           // 记录最大值下标
        for (int i = 0; i < new_s.length(); i++) {
            len[i] = mostRightString(new_s, i);
            if (len[i] > max){
                flag = i;
                max = len[i];
            }
        }
        String end_s = new_s.substring(flag-len[flag]+1, flag+len[flag]).replaceAll("#","");
        return end_s;
    }

    private static int mostRightString(String s, int index){
        int cursor = 1;
        while((index+cursor)<s.length() && (index-cursor)>=0 && s.charAt(index+cursor) == s.charAt(index-cursor)){
            cursor++;
        }
        return cursor;
    }

    private static String addSomeMarks(String s){
        StringBuffer new_s = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            new_s.append("#");
            new_s.append(s.charAt(i));
        }
        new_s.append("#");
        //System.out.println(new_s);
        return new_s.toString();
    }
}
