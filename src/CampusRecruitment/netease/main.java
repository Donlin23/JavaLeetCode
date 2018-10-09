package CampusRecruitment.netease;

import java.util.Scanner;

/**
 * @Author: Donlin
 * @Date: Created in 16:19 2018/9/8
 * @Version: 1.0
 * @Description:
 */
public class main{

   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       while (in.hasNextLine()) {
           String s = in.nextLine();
           int res = LargestNumOfString(s);
           System.out.println(res);
       }
   }

    private static int LargestNumOfString(String s){
        int b_num = 0;
        int w_num = 0;
        int maxNum = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='b'){
                b_num++;
            }
            if(ch=='w'){
                w_num++;
            }
        }
        int all_num = b_num + w_num;

        return maxNum;
    }

}
