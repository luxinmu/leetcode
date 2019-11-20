package test;

import java.util.HashMap;
import java.util.Map;

public class T13_RomantoInteger {

	/**
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
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MMMDCCCLXXXV"));
		System.out.println(romanToInt("MMMCM"));
		System.out.println(romanToInt("MMMDCCCLX"));
	}

	public static int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<>();
		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("I", 1);
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length() && map.get(s.substring(i, i + 2)) != null) {
				ans = ans + map.get(s.substring(i, i + 2));
				i++;
			} else
				ans = ans + map.get(s.substring(i, i + 1));
		}
		return ans;
	}

}
