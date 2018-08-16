package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 14:24 2018/8/14
 * @Version: 1.0
 * @Description: 面试题4: 二维数组中的查找
 */
public class Find {
    public static void main(String[] args) {

        int[][] nums = {{1,4,6,9,10},{2,3,5,7,11},{4,6,7,10,23}};
        System.out.println(Find(23, nums));
        System.out.println();
    }

    public static boolean Find(int target, int[][] array){
        int columns = array.length;
        int rows = array[0].length;
        boolean found = false;

        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0){
            if (target == array[column][row]){
                found = true;
                break;
            }else if (target > array[column][row]){
                row++;
            }else {
                column--;
            }
        }
        return found;
    }
}
