package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T17_LetterCombinationsOfaPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("2"));
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("2347"));
	}

	public static List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0)
			return new ArrayList<>();
		Map<Character, String> phone = new HashMap<Character, String>();
		phone.put('2', "abc");
		phone.put('3', "def");
		phone.put('4', "ghi");
		phone.put('5', "jkl");
		phone.put('6', "mno");
		phone.put('7', "pqrs");
		phone.put('8', "tuv");
		phone.put('9', "wxyz");
		String[] ans = null;
		for (int i = 0; i < digits.length(); i++) {
			ans = letterCombinations0(phone.get(digits.charAt(i)), ans);
		}
		return Arrays.asList(ans);
	}

	public static String[] letterCombinations0(String str, String[] strs) {
		if (str == null)
			return null;
		if (strs == null)
			return str.split("");
		String[] ans0 = new String[strs.length * str.length()];
		int k = 0;
		for (int j = 0; j < strs.length; j++)
			for (int i = 0; i < str.length(); i++)
				ans0[k++] = strs[j] + str.charAt(i);
		return ans0;
	}
}
