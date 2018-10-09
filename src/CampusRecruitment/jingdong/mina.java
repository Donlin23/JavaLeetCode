package CampusRecruitment.jingdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Donlin
 * @Date: Created in 20:25 2018/9/9
 * @Version: 1.0
 * @Description:
 */
public class mina {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String S = scanner.nextLine();
//        String T = scanner.nextLine();
        String S = "ababcb";
        String T = "xyx";
        System.out.println(S.length() + " "+ T.length());
        // todo:统一编码
        int count = 0;
        for (int i = 0; i < S.length() - T.length() + 1; i++) {
            if(isSimilar(S.substring(i, i + T.length()-1), T)){
                count++;
            }
            System.out.println();
        }
        System.out.println(count);
    }

    private static boolean isSimilar(String S, String T){
        String newS = encode(S);
        String newT = encode(T);
        if (newS.equals(newT)){
            return true;
        }
        return false;
    }

    private static String encode(String code){
        Map<Character, String> map = new HashMap<>();
        StringBuffer encode = new StringBuffer();
        for (int i = 0; i < code.length(); i++) {
            if (map.isEmpty() || !map.containsKey(code.charAt(i))){
                map.put(code.charAt(i), String.valueOf(i));
                encode.append(String.valueOf(i));
            }else {
                encode.append(map.get(code.charAt(i)));
            }
        }
        return encode.toString();
    }
}
