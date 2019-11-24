package test;

public class T69_Sqrtx {
    public static void main(String[] args) {
        T69_Sqrtx t69 = new T69_Sqrtx();
        System.out.println(t69.mySqrt(4));
        System.out.println(t69.mySqrt(8));
        System.out.println(t69.mySqrt(100));
        System.out.println(t69.mySqrt(Integer.MAX_VALUE));
    }

    /**
     * 执行用时 : 2 ms ,  84.04%
     * 内存消耗 : 33.6 MB ,  75.11%
     */
    public int mySqrt(int a) {
        long x = a;
//        while (x > a / x)
        while (x * x > a)
            x = (x + a / x) / 2;
        return (int) x;
    }
}
