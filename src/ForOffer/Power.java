package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 10:08 2018/8/23
 * @Version: 1.0
 * @Description: 面试题16: 数值的整数次方
 */
public class Power {
    public static void main(String[] args) throws Exception {

        System.out.println(Power(-2, -12));
    }

    public static double Power(double base, int exponent) throws Exception {
        if (base == 0.0 && exponent<0){
            throw new Exception("base must not be zero.");
        }
        int absExponent = exponent;
        if (exponent<0)
            absExponent = - exponent;

        double result = PowerWithAbsExponent(base, absExponent);
        if (exponent<0)
            result = 1.0 / result;
        return result;
    }

    private static double PowerWithAbsExponent(double base, int absExponent) {

        if (absExponent == 0)
            return 1.0;
        if (absExponent == 1)
            return base;

        double result = PowerWithAbsExponent(base, absExponent>>1);
        result *= result;
        if ((absExponent & 1) == 1)
            result *= base;

        return result;
    }
}
