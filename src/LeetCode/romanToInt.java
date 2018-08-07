package LeetCode;

import java.util.HashMap;

/**
 * @Author: Donlin
 * @Date: Created in 20:02 2018/8/7
 * @Version: 1.0
 * @Description:
 */
public class romanToInt {
    public static void main(String[] args) {

        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    //  roman number
//        I - 1
//        V - 5
//        X - 10
//        L - 50
//        C - 100
//        D - 500
//        M - 1000
    public static int romanToInt(String s){
        int result = 0;
        char[] chars = s.toCharArray();
        int i = 0;
       while(i < chars.length){
           if (i + 1 >= chars.length){
               switch (chars[i]){
                   case 'I':
                       result = result + 1;
                       break;
                   case 'V':
                       result = result + 5;
                       break;
                   case 'X':
                       result = result + 10;
                       break;
                   case 'L':
                       result = result + 50;
                       break;
                   case 'C':
                       result = result + 100;
                       break;
                   case 'D':
                       result = result + 500;
                       break;
                   case 'M':
                       result = result + 1000;
                       break;
               }
               break;
           }
           switch(chars[i]){
               case 'I':
                   if (chars[i+1] == 'V'){
                       result = result + 4;
                       i+=2;
                   }else if (chars[i+1] == 'X'){
                       result = result + 9;
                       i+=2;
                   }else {
                       result = result + 1;
                       i++;
                   }
                   break;
               case 'V':
                   result = result + 5;
                   i++;
                   break;
               case 'X':
                   if (chars[i+1] == 'L'){
                       result = result + 40;
                       i+=2;
                   }else if (chars[i+1] == 'C'){
                       result = result + 90;
                       i+=2;
                   }else {
                       result = result + 10;
                       i++;
                   }
                   break;
               case 'L':
                   result = result + 50;
                   i++;
                   break;
               case 'C':
                   if (chars[i+1] == 'D'){
                       result = result + 400;
                       i+=2;
                   }else if (chars[i+1] == 'M'){
                       result = result + 900;
                       i+=2;
                   }else {
                       result = result + 100;
                       i++;
                   }
                   break;
               case 'D':
                   result = result + 500;
                   i++;
                   break;
               case 'M':
                   result = result + 1000;
                   i++;
                   break;
           }
       }
        return result;
    }

    // a solution from LeetCode with the best runtime
    public int romanToInt_fromLeetCode(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int l = s.length();
        int result = 0;
        int i = 0;
        while (i < l) {
            if (i < l - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i += 2;
            } else {
                result += map.get(s.charAt(i));
                i++;
            }
        }
        return result;
    }
}
