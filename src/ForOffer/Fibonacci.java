package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 10:44 2018/8/15
 * @Version: 1.0
 * @Description: 面试题10: 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Fibonacci(39));
    }

    public static int Fibonacci(int n){
        if (n==0) return 0;
        if (n==1) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
