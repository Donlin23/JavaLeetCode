package CampusRecruitment.WeBank;

import java.util.Scanner;

/**
 * @Author: Donlin
 * @Date: Created in 15:55 2018/9/18
 * @Version: 1.0
 * @Description:
 */
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        int[][] ints = new int[testNum][2];
        for (int i = 0; i < testNum; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
        }

        double[] result = new double[testNum];

        // 求出当前最小的距离
        for (int i = 0; i < testNum - 1; i++) {
            double min = Double.MAX_VALUE;
            int minA=0,minB=0;
            for (int j = i + 1; j < testNum; j++) {
                double weight = twoPointDis(ints[i][0],ints[i][1], ints[j][0],ints[j][1]);
                if (min > weight){
                    min = weight;
                    minA = i;
                    minB = j;
                }
            }
            if (result[minB]==0){
                result[minA] = result[minB] = (min/2);
            }

        }


        for (int i = 0; i < testNum; i++) {

        }


        for (int i = 0; i < testNum; i++) {
            System.out.printf("%.3f ",result[i]);
        }

    }

    private static double twoPointDis(int A_x, int A_y, int B_x, int B_y){
        return Math.sqrt(Math.pow((A_x-B_x),2)+Math.pow((A_y-B_y),2));
    }
}
