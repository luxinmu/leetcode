package test;

import java.util.HashMap;
import java.util.Map;

public class T28_ImplementstrStr {

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("hello", "aa"));
		System.out.println(strStr("bbbdbbbcabc", "bbc"));
		System.out.println(strStr("", ""));
		System.out.println(strStr("mississippi", "a"));
		System.out.println(strStr("a", "a"));
		System.out.println(strStr("mississippi", "issip"));
		System.out.println(strStr("mississippi", "issipi"));
	}

	/* Sunday method */
	public static int strStr1(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		if (needle.length() == 0)
			return 0;
		Map<Character, Integer> shift = new HashMap<>();
		int i = 0;
		int plen = needle.length();
		int len = haystack.length();
		int k = 0;
		for (char c : needle.toCharArray()) {
			shift.put(c, plen - k++);
		}
		while (i + plen <= len) {
			if (needle.equals(haystack.substring(i, i + plen)))
				return i;
			else {
				if (i + plen < len && shift.get(haystack.charAt(i + plen)) != null)
					i = i + shift.get(haystack.charAt(i + plen));
				else
					i = i + plen;
			}
		}
		return -1;
	}

	/* force method enhanced */
	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		if (needle.length() == 0)
			return 0;
		int i = 0;
		int j = 0;
		int plen = needle.length();
		for (i = 0; i <= haystack.length() - plen; i++)
			if (haystack.charAt(i) == needle.charAt(j))
				if (needle.equals(haystack.substring(i, i + plen)))
					return i;
		return -1;
	}

	/* force method */
	public static int strStr10(String haystack, String needle) {
		if (haystack == null || needle == null || haystack.length() < needle.length())
			return -1;
		if (needle.length() == 0)
			return 0;
		int i = 0;
		int j = 0;
		for (i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (j++ == needle.length() - 1)
					return i - needle.length() + 1;
			} else {
				i = i - j;
				j = 0;
			}
		}
		return -1;
	}

}
