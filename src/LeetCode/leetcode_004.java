package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 14:30 2018/10/8
 * @Version: 1.0
 * @Description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * @Link: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 */
public class leetcode_004 {
    public static void main(String[] args) {

        int[] a = {1,5,6,23,45,444,2345};
        int[] b = {2,3,6,7,12,14,18,34,55};
        System.out.println(findMedianSortedArrays(a,b));

    }

    // 时间复杂度为O(m+n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sums = new int[nums1.length+nums2.length];
        int i = nums1.length-1;
        int j = nums2.length-1;
        int k = sums.length-1;
        while(i>=0 && j>=0){
            if (nums1[i] > nums2[j]){
                sums[k] = nums1[i];
                i--;
            }else {
                sums[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (i<0 && j>=0){
            sums[k] = nums2[j];
            j--;
            k--;
        }
        while (j<0 && i>=0){
            sums[k] = nums1[i];
            i--;
            k--;
        }
        if (sums.length % 2 == 1)
            return (double) sums[(sums.length)/2];
        return (sums[sums.length/2]+sums[sums.length/2-1])/2.0;
    }

}
