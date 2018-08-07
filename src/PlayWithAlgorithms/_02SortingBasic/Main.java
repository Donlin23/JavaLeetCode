package PlayWithAlgorithms._02SortingBasic;

import java.util.Arrays;

/**
 * @Author: Donlin
 * @Date: Created in 16:55 2018/8/7
 * @Version: 1.0
 * @Description:
 */
public class Main {
    // 比较SelectionSort和InsertionSort两种排序算法的性能效率
    public static void main(String[] args) {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("PlayWithAlgorithms._02SortingBasic.SelectionSort", arr1);
        SortTestHelper.testSort("PlayWithAlgorithms._02SortingBasic.InsertionSort", arr2);

        System.out.println();


        // 测试2 有序性更强的测试
        System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("PlayWithAlgorithms._02SortingBasic.SelectionSort", arr1);
        SortTestHelper.testSort("PlayWithAlgorithms._02SortingBasic.InsertionSort", arr2);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("PlayWithAlgorithms._02SortingBasic.SelectionSort", arr1);
        SortTestHelper.testSort("PlayWithAlgorithms._02SortingBasic.InsertionSort", arr2);

        return;
    }
}
