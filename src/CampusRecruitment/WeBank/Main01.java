package CampusRecruitment.WeBank;

/**
 * @Author: Donlin
 * @Date: Created in 17:16 2018/9/18
 * @Version: 1.0
 * @Description:
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main01 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String GetResult(int N) {
        if(N <= 0) return "";

        int sum = 0, x = 1;
        while (sum < N){
            sum = x*(1+x)/2;
            x++;
        }
        int count = 0;
        String result = "";
        if (sum == N)
            count = x - 1;
        else
            count = x - 2;

        int diff = N - count *(1+count)/2;
        if (count%2==0){
            if (diff!=0){
                int i=count+2-diff;
                int j = diff;
                result = i+"/"+j;
            }else {
                result = count+"/"+1;
            }
            return result;
        }else {
            if(diff!=0){
                int i= count+2-diff;
                int j = diff;
                result = j+"/"+i;
            }else {
                result = 1+"/"+count;
            }
            return result;

        }

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _N;
        _N = Integer.parseInt(in.nextLine().trim());

        res = GetResult(_N);
        System.out.println(res);
    }
}
