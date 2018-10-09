package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 18:39 2018/8/5
 * @Version: 1.0
 * @Description: Write a function to find the longest common prefix string amongst an array of strings.
 * @link: https://leetcode-cn.com/problems/longest-common-prefix/description/
 */
public class leetcode_014 {
    public static void main(String[] args) {

        String[] s = {};
        //StringBuffer a = new StringBuffer();
        //System.out.println("\"" + a.toString() + "\"");
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            boolean isSame = true;

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)){
                    isSame = false;
                    break;
                }
            }
            if (isSame){
                result.append(strs[0].charAt(i));
            }else {
                break;
            }

        }
        return result.toString();
    }

    // the highest score answer!! nice thought!!
    public String longestCommonPrefixDemo(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());       // find the minimum length string

        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
