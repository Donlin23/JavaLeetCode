package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 9:47 2018/8/12
 * @Version: 1.0
 * @Description: Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * @Link: https://leetcode-cn.com/problems/remove-element/description/
 */
public class removeElement {
    public static void main(String[] args) {

        int[] nums = {3,3};
        System.out.println(removeElement(nums, 3));
        System.out.println();
    }

    public static int removeElement(int[] nums, int val){
        int count = 0;
        int fore = 0;
        int end = nums.length - 1;
        while(fore <= end){
            if (nums[fore] == val){
                nums[fore] = nums[end];
                end--;
                count++;
            }else {
                fore++;
            }
        }
        return nums.length - count;
    }
}
