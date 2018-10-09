package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 9:33 2018/8/12
 * @Version: 1.0
 * @Description: Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * @Link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class leetcode_026 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println();
    }

    public static int removeDuplicates(int[] nums){
        //int len = nums.length;
        int cursor = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cursor] != nums[i]){
                nums[cursor+1] = nums[i];
                cursor++;
            }
        }
        return cursor+1;
    }
}
