package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 20:52 2018/12/24
 * @Version: 1.0
 * @Description: count and say
 * @Link: https://leetcode-cn.com/problems/count-and-say/
 */
public class leetcode_038 {

    public static void main(String[] args) {

        int n = 4;
        System.out.println(countAndSay(n));

    }

    public static String countAndSay(int n) {
        String init = "1";
        for (int i = 1; i < n; i++) {
            init = counter(init);
        }
        return init;
    }

    private static String counter(String s){
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        int count = 1;
        int i = 0;
        char current;
        current = chars[i];

        while((++i) < s.length()){

            if (current == chars[i]){
                count++;
            }else {
                sb.append(count);
                sb.append(current);
                // 恢复计数器
                current = chars[i];
                count = 1;
            }
        }
        sb.append(count);
        sb.append(current);

        return sb.toString();
    }
}
