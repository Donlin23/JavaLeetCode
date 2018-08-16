package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 8:32 2018/8/14
 * @Version: 1.0
 * @Description: 面试题3: 数组中重复的数字
 */
public class duplicate {
    public static void main(String[] args) {
        int[] nums = {3,1,2,0,2,5,3};
        int[] duplication = new int[nums.length];
        System.out.println(duplicate(nums, nums.length, duplication));
        System.out.println();
    }

    public static boolean duplicate(int[] numbers, int length, int[] duplication){
        if (numbers == null || length <= 0){ return false; }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    duplication[i] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
