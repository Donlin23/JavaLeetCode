package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 18:07 2018/8/1
 * @Version: 1.0
 * @Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * @Link: https://leetcode-cn.com/problems/two-sum/description/
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.print("result: [ " );
        for (int i = 0; i < result.length; i++) {
            System.out.print( result[i] + " ");
        }
        System.out.println("]");

    }

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((target - nums[i]) == nums[j]){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
            if (result[0] != result[1])
                break;
        }
        return result;
    }
}
