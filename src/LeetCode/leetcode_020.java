package LeetCode;

import java.util.*;

/**
 * @Author: Donlin
 * @Date: Created in 19:04 2018/8/8
 * @Version: 1.0
 * @Description: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * @Link: https://leetcode-cn.com/problems/valid-parentheses/description/
 */
public class leetcode_020 {
    public static void main(String[] args) {
        String s = "()[]{}";
        //        Map<Character, Character> map = new HashMap<>();
//        map.put('(', ')');
//        map.put('{', '}');
//        map.put('[', ']');
//        System.out.println(map.get('a'));
        System.out.println(isValid(s));
    }

    //
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('{');
        set.add('[');
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])){
               stack.push(chars[i]);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                if (Character.compare(map.get(stack.peek()), chars[i]) == 0){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
