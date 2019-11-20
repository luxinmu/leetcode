package test;

public class T43_MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("6", "14"));
		System.out.println(multiply("0", "14"));
		System.out.println(multiply("251", "52"));
	}

	public static String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2))
			return "0";
		int carry = 0;
		int multip = 0;
		int len1 = num1.length();
		int len2 = num2.length();
		int ans[] = new int[len1 + len2];
		for (int i = len2 - 1; i >= 0; i--) {
			int ans0[] = new int[len1 + len2];
			int k = len2 - i - 1;
			carry = 0;
			int num2i = num2.charAt(i) - '0';
			for (int j = len1 - 1; j >= 0; j--) {
				multip = num2i * (num1.charAt(j) - '0') + carry;
				carry = multip / 10;
				ans0[k++] = multip % 10;
			}
			if (carry != 0)
				ans0[k++] = carry;
			int m = 0;
			int n = 0;
			int carry1 = 0;
			while (m < k || n < ans.length) {
				int v1 = m < k ? ans0[m] : 0;
				int v2 = n < ans.length ? ans[n] : 0;
				ans[m++] = (v1 + v2 + carry1) % 10;
				carry1 = (v1 + v2 + carry1) / 10;
				n++;
			}
			if (carry1 != 0)
				ans[m] = 1;
		}
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (int ii = ans.length - 1; ii >= 0; ii--) {
			if (!first || ans[ii] != 0) {
				first = false;
				sb.append(ans[ii]);
			}
		}
		return sb.toString();
	}

	public static String multiply1(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2))
			return "0";
		char cn[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int carry = 0;
		int multip = 0;
		String ans = "";
		StringBuilder sb = new StringBuilder();
		for (int i = num2.length() - 1; i >= 0; i--) {
			sb.delete(0, ans.length());
			for (int k = 0; k < num2.length() - i - 1; k++)
				sb.append('0');
			carry = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				multip = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;
				carry = multip / 10;
				sb.append(cn[multip % 10]);
			}
			if (carry != 0)
				sb.append(cn[carry]);
			String tmp = sb.toString();
			sb.delete(0, tmp.length());
			int m = 0;
			int n = 0;
			int carry1 = 0;
			while (m < tmp.length() || n < ans.length()) {
				int v1 = m < tmp.length() ? tmp.charAt(m) - '0' : 0;
				int v2 = n < ans.length() ? ans.charAt(n) - '0' : 0;
				sb.append(cn[(v1 + v2 + carry1) % 10]);
				carry1 = (v1 + v2 + carry1) / 10;
				m++;
				n++;
			}
			if (carry1 != 0)
				sb.append('1');
			ans = sb.toString();
		}
		return sb.reverse().toString();
	}
}
