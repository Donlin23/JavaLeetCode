package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 11:01 2018/8/12
 * @Version: 1.0
 * @Description: Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * @Link: https://leetcode-cn.com/problems/search-insert-position/description/
 */
public class searchInsert {
    public static void main(String[] args) {

        int[] nums = {};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    // utilize bisearch-thought  O(logN)
    public int searchInsertFromLeetCode(int[] nums, int target) {
        //[0,len)开区间
        int i=0,j=nums.length;
        //因为是前闭后开，i=j的时候，其实就是没有意义了
        while(i<j){
            int mid = (i+j)/2;
            if(nums[mid]==target)
                return mid;
            if(target<nums[mid])
                j=mid;//因为开区间，刚好没有取到mid
            else
                i=mid+1;//闭区间，为了不取到mid，只能+1
        }
        return j;
    }
}
