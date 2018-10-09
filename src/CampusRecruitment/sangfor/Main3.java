package CampusRecruitment.sangfor;

import java.util.Scanner;

/**
 * @Author: Donlin
 * @Date: Created in 19:25 2018/9/21
 * @Version: 1.0
 * @Description: 深信服笔试第三题
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        WoolList[] woolLists = new WoolList[T];
        for (int i = 0; i < T; i++) {
            int num = scanner.nextInt();
            woolLists[i] = new WoolList(num);
            for (int j = 0; j < num; j++) {
                woolLists[i].add(scanner.nextInt());
            }
        }
        for (WoolList woolList: woolLists) {
            System.out.println(computeWater(woolList.getWool()));
        }

    }

    static class WoolList{
        int length;
        int[] wool;
        int cursor;
        WoolList(int length){
            this.cursor = 0;
            this.length = length;
            this.wool = new int[length];
        }
        public void add(int i){
            this.wool[cursor] = i;
            cursor++;
        }
        public int[] getWool(){
            return wool;
        }
    }

    private static int computeWater(int[] wool) {
        if (wool==null || wool.length==1){
            return 0;
        }
        int result = 0;
        int currentWool = wool[0];
        for (int i = 1; i < wool.length; i++) {
            if (currentWool >= wool[i] && (i != wool.length-1)){
                result = result + currentWool;
            }else if ((i == wool.length-1) && currentWool >= wool[i]){
                result = result + wool[i];
            }
            else {
                result = result + currentWool;
                currentWool = wool[i];
            }
        }
        return result;
    }


}
