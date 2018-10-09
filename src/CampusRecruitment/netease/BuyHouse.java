package CampusRecruitment.netease;

import java.util.Scanner;

/**
 * @Author: Donlin
 * @Date: Created in 15:20 2018/9/8
 * @Version: 1.0
 * @Description:
 */
public class BuyHouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[][] array = new int[t][2];
        for (int i = 0; i < t; i++){
            array[i][0] = in.nextInt();
            array[i][1] = in.nextInt();
        }

        for (int i = 0; i < t; i++){
            int maxNum = 0;
            int a = array[i][0];
            int b = array[i][1];   // 求a个房子，b个住户的最大可能数
            if(a - b >= a / 2 && b!=0 && b!=1 ){
                maxNum = b - 1;
            }else if (a - b == 1 || a == b || b == 0){
                maxNum = 0;
            }else {
                maxNum = a - b;
            }

            System.out.println(0 + " "+ maxNum);
        }

    }



}
