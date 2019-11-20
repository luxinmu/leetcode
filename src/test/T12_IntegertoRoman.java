package test;

public class T12_IntegertoRoman {

	/**
	 * 1~3999
	 * <p>
	 * Symbol Value <br>
	 * I 1 <br>
	 * V 5 <br>
	 * X 10 <br>
	 * L 50 <br>
	 * C 100 <br>
	 * D 500 <br>
	 * M 1000 <br>
	 */
	public static void main(String[] args) {
//		System.out.println(intToRoman(400));
		for (int i = 1; i <= 3999; i++) {
			System.out.print(intToRoman(i) + " ");
			if (i % 10 == 0)
				System.out.println();
		}
	}

	/* greedy algorithm */
	public static String intToRoman(int num) {
		if (num < 1 || num > 3999)
			return null;
		int i = 0;
		int j = 0;
		int num0 = 0;
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		StringBuilder ans = new StringBuilder();
		while (num > 0) {
			num0 = num / values[i];
			for (j = 0; j < num0; j++)
				ans.append(symbol[i]);
			num = num - num0 * values[i];
			i++;
		}
		return ans.toString();
	}

	public static String intToRoman10(int num) {
		if (num < 1 || num > 3999)
			return null;
		int i = 0;
		int j = 0;
		int num0 = 0;
		String[] symbol = { "I", "V", "X", "L", "C", "D", "M" };
		String ans = "";
		while (num > 0) {
			num0 = num % 10;
			if ((num0 + 1) / 5 == 0)
				for (j = 0; j < num0; j++)
					ans = symbol[i] + ans;
			else if ((num0 + 1) / 5 == 1) {
				String temp = "";
				for (j = 0; j < num0 - 5; j++)
					temp = temp + symbol[i];
				ans = (num0 == 4 ? symbol[i] : "") + symbol[i + 1] + temp + ans;
			} else if ((num0 + 1) / 5 == 2)
				ans = symbol[i] + symbol[i + 2] + ans;
			num = num / 10;
			i = i + 2;
		}
		return ans;
	}
}
