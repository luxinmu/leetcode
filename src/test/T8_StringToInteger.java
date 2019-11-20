package test;

public class T8_StringToInteger {

	public static void main(String[] args) {
		System.out.println(myAtoi0("123"));
		System.out.println(myAtoi0("+123"));
		System.out.println(myAtoi0("+1+23"));
		System.out.println(myAtoi0("   -123"));
		System.out.println(myAtoi0("   -1-23"));
		System.out.println(myAtoi0("   -M"));
		System.out.println(myAtoi0("   -01"));
		System.out.println(myAtoi0("+M"));
		System.out.println(myAtoi0("4193 with words"));
		System.out.println(myAtoi0("words and 987"));
		System.out.println(myAtoi0("-91283472332"));
		System.out.println(myAtoi0("91283472332"));
		System.out.println(myAtoi0("9223372036854775808"));
	}
	
	public static int myAtoi0(String str) {
		if (str == null || str.trim().length() == 0)
			return 0;
		String trimStr = str.trim();
		char first = trimStr.charAt(0);
		boolean lesstran0 = false;
		double ans0 = 0;
		int i = 0;
		if (first == '-') {
			lesstran0 = true;
			i = 1;
		} else if (first == '+') {
			i = 1;
		}
		for (; i < trimStr.length(); i++) {
			if (trimStr.charAt(i) >= '0' && trimStr.charAt(i) <= '9') {
				ans0 = ans0 * 10 + trimStr.charAt(i) - '0';
			} else
				break;
		}
		if (lesstran0)
			return -ans0 < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -ans0;
		else
			return ans0 > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ans0;
	}

	public static int myAtoi10(String str) {
		if (str == null || str.trim().length() == 0)
			return 0;
		String trimStr = str.trim();
		char first = trimStr.charAt(0);
		boolean lesstran0 = false;
		String ans0 = "0";
		int i = 0;
		if (first == '-') {
			ans0 = "-0";
			lesstran0 = true;
			i = 1;
		} else if (first == '+') {
			i = 1;
		}
		for (; i < trimStr.length(); i++) {
			if (trimStr.charAt(i) >= '0' && trimStr.charAt(i) <= '9') {
				ans0 = ans0 + trimStr.charAt(i);
			} else
				break;
		}
		if (lesstran0)
			return Double.parseDouble(ans0) < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.parseInt(ans0);
		else
			return Double.parseDouble(ans0) > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.parseInt(ans0);
	}

}
