package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 10:49 2018/9/8
 * @Version: 1.0
 * @Description: (No finished.)
 */
public class getNumberOfK {
    public static void main(String[] args) {

        int[] data = {1,2,3,3,3,3,4,5};
        int k = 3;
        System.out.println(GetNumberOfK(data, k));
    }

    public static int GetNumberOfK(int[] data, int k){
        int number = 0;
        if (data.length != 0 && data != null){
            int first = getFirstK(data, k, 0, data.length-1);
            int last = getLastK(data, k, 0, data.length-1);

            if (first != -1 && last != -1){
                number = last - first + 1;
            }
        }
        return number;
    }

    public static int getFirstK(int[] data, int k, int start, int end){
        if (start >= end){
            return -1;
        }
        int mid = (start + end) / 2;
        int midData = data[mid];
        if (midData == k){
            if ((mid > 0 && data[mid - 1] != k ) || mid == 0){
                return mid;
            }else {
                end = mid - 1;
            }
        }else if (midData > k){
            end = mid -1;
        }else {
            start = mid + 1;
        }
        return getFirstK(data, k, start, end);
    }

    public static int getLastK(int[] data, int k, int start, int end){
        if (start >= end){
            return -1;
        }
        int mid = (start + end) / 2;
        int midData = data[mid];
        if (midData == k){
            if ((mid < data.length-1 && data[mid + 1] != k ) || mid == data.length - 1){
                return mid;
            }else {
                start = mid + 1;
            }
        }else if (midData > k){
            end = mid -1;
        }else {
            start = mid + 1;
        }
        return getLastK(data, k, start, end);
    }
}
