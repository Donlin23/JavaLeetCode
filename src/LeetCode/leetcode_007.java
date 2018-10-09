package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Donlin
 * @Date: Created in 18:51 2018/8/2
 * @Version: 1.0
 * @Description: Given a 32-bit signed integer, leetcode_007 digits of an integer.
 * @link: https://leetcode-cn.com/problems/leetcode_007-integer/description/
 */
public class leetcode_007 {
    public static void main(String[] args) {

        int num = -1534236469;
        int numReverse = reverse(num);
        System.out.println(numReverse);
    }

    public static int reverse(int x){
        long temp = x;
        boolean signal = false;
        if (temp < 0){
            temp = Math.abs(temp);
            signal = true;
        }
        List<Long> list = new ArrayList<>();
        while(temp != 0){
            list.add(temp % 10);
            temp = temp / 10;
        }
        temp = 0;
        for (long v : list ) {
            temp = temp * 10 + v;
        }
        if ((signal && ( 0 - temp) < Integer.MIN_VALUE) || ( !signal && temp > Integer.MAX_VALUE)){
            return 0;
        }
        if (signal){
            return 0 - (int)temp;
        }
        return (int)temp;
    }
}
