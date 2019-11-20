package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T6_ZigZagConversion {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(convert("AB", 1));
		System.out.println(convert("123456789abcd", 3));
		System.out.println(convert("123456789abcd", 4));
		System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
		System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
		System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");
	}

	public static String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows <= 1)
			return s;
		Map<Integer, StringBuilder> map = new HashMap<>();
		for (int k = 0; k < numRows; k++)
			map.put(k, new StringBuilder());
		int cur = 0;
		boolean going = false;
		for (char c : s.toCharArray()) {
			map.get(cur).append(c);
			if (cur % (numRows - 1) == 0)
				going = !going;
			cur += going ? 1 : -1;
		}
		for (int k = 1; k < numRows; k++)
			map.get(0).append(map.get(k).toString());
		return map.get(0).toString();
	}

	public static String convert10(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows == 1)
			return s;
		if (numRows <= 0)
			return null;
		Map<Integer, List<Character>> map = new HashMap<>();
		for (int k = 0; k < numRows; k++)
			map.put(k, new ArrayList<>());

		int cur = 0;
		boolean isAdd = true;
		for (int i = 0; i < s.length(); i++) {
			map.get(cur).add(s.charAt(i));
			if (cur == 0)
				isAdd = true;
			else if (cur == numRows - 1)
				isAdd = false;
			if (isAdd)
				cur++;
			else
				cur--;
		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < numRows; k++)
			for (char c : map.get(k))
				sb.append(c);
		return sb.toString();
	}
}
