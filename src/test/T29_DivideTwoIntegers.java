package test;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor. The integer division
 * should truncate toward zero.
 * <p>
 * Example 1: <br>
 * Input: dividend = 10, divisor = 3 <br>
 * Output: 3
 * <p>
 * Example 2: <br>
 * Input: dividend = 7, divisor = -3 <br>
 * Output: -2
 * <p>
 * Note: Both dividend and divisor will be 32-bit signed integers. The divisor
 * will never be 0. Assume we are dealing with an environment which could only
 * store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 2^31 − 1
 * when the division result overflows.
 */
public class T29_DivideTwoIntegers {

	public static void main(String[] args) {
//		for (int i = 0; i <= 31; i++) {
//			System.out.println(i + " " + (-1 << i));
//			System.out.println(i + " " + (-2 << i));
//			System.out.println(i + " " + (-3 << i));
//			System.out.println(i + " " + (-4 << i));
//		}
		System.out.println((Integer.MIN_VALUE - Integer.MIN_VALUE / 2 - 1) << 1);

//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE + 1);
//		System.out.println(Integer.MIN_VALUE - 1);
//		System.out.println(Integer.MAX_VALUE << 1);
//		System.out.println(Integer.MIN_VALUE << 1);
//		System.out.println(Integer.MAX_VALUE >> 1);
//		System.out.println(Integer.MIN_VALUE >> 1);
//		System.out.println(Integer.MIN_VALUE >> 31);
//		System.out.println(-5 << 2);
		print(100, 3);
		print(7, -3);
		print(0, 1);
		print(Integer.MAX_VALUE, Integer.MAX_VALUE);
		print(Integer.MIN_VALUE, Integer.MIN_VALUE);
		print(Integer.MIN_VALUE, Integer.MAX_VALUE);
		print(Integer.MAX_VALUE, Integer.MIN_VALUE);
		print(Integer.MIN_VALUE, Integer.MIN_VALUE - 1);
		print(Integer.MIN_VALUE, Integer.MIN_VALUE + 1);
		print(Integer.MAX_VALUE, Integer.MAX_VALUE + 1);
		print(Integer.MAX_VALUE, 3);
		print(Integer.MAX_VALUE, 2);
		print(Integer.MAX_VALUE, 1);
		print(Integer.MIN_VALUE, 2);
		print(Integer.MIN_VALUE, 1);
		print(Integer.MAX_VALUE, -1);
		print(Integer.MIN_VALUE, -1);
	}

	public static void print(int a, int b) {
		int d = divide(a, b);
		System.out.println(
				"a=" + a + "  b=" + b + "   a/b=" + a / b + "  divide:" + d + "   " + (a / b == d ? true : false));
	}

	/**
	 * when dividend equals Integer.MIN_VALUE, <br>
	 * 1 Integer.MAX_VALUE - abs(divisor)*1 <br>
	 * 2 ans = ans + 1
	 */
	public static int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if (divisor == Integer.MIN_VALUE)
			return dividend == Integer.MIN_VALUE ? 1 : 0;
		boolean negative = (dividend < 0) ^ (divisor < 0);
		int tmp_divisor = Math.abs(divisor);
		int tmp_dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE - tmp_divisor + 1 : Math.abs(dividend);
		int tmp_ans = dividend == Integer.MIN_VALUE ? 1 : 0;
		int ans = 0;
		int i = 31;
		while (tmp_dividend >= tmp_divisor) {
			if (tmp_dividend >> i >= tmp_divisor) {
				tmp_dividend -= tmp_divisor << i;
				ans += 1 << i;
			}
			i--;
		}
		return negative ? -ans - tmp_ans : ans + tmp_ans;
	}

	public static int divide1(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		boolean negative = (dividend ^ divisor) < 0;
		dividend = dividend < 0 ? dividend : -dividend;
		divisor = divisor < 0 ? divisor : -divisor;
		int ans = 0;
		while (dividend <= divisor) {
			int temp_result = -1;
			int temp_divisor = divisor;
			while (dividend <= (temp_divisor << 1)) { // divisor*2^n < dividend break
				if (temp_divisor < (Integer.MIN_VALUE >> 1)) // 除数特别大时 break
					break;
				temp_result <<= 1;
				temp_divisor <<= 1;
			}
			dividend = dividend - temp_divisor;
			ans += temp_result;
		}
		return negative ? ans : -ans;
	}
}
