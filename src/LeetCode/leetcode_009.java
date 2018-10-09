package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 10:09 2018/8/3
 * @Version: 1.0
 * @Description: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * @link: https://leetcode-cn.com/problems/palindrome-number/description/
 */
public class leetcode_009 {
    public static void main(String[] args) {
        int x = 123454321;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x){
        if (x < 0){
            return false;
        }
        if ((x / 10) == 0){
            return true;
        }
        int num = x;
        int reverse = 0;
        while(num != 0){
            int temp = num % 10;
            reverse = reverse * 10 + temp;
            num = num / 10;
        }
        if (reverse == x){
            return true;
        }
        return false;
    }
}
