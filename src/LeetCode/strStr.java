package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 10:18 2018/8/12
 * @Version: 1.0
 * @Description: Implement strStr(). It means String.indexOf() implement.
 * @Link: https://leetcode-cn.com/problems/implement-strstr/description/
 */
public class strStr {
    public static void main(String[] args) {

        String haystack = "mississippi";
        String needle = "pi";
        System.out.println(strStr(haystack, needle));
        System.out.println(haystack.indexOf(needle));
    }

    public static int strStr(String haystack, String needle){
        if (needle.length() == 0 || needle == null || haystack.equals(needle)){
            return 0;
        }
        if (needle.length() > haystack.length()){
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean flag = false;
            for (int j = 0; j < needle.length(); j++) {
                if (Character.compare(haystack.charAt(i+j), needle.charAt(j)) != 0){
                    flag = false;
                    break;
                }else {
                    flag = true;
                }
            }
            if (flag){ return i;}
        }
        return -1;
    }
}
