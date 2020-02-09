package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T3_LengthOfLongestSubstring {

	public static void main(String[] args) {
		String str = "aaa";
		String str1 = "";
		String str2 = "a";
		String str3 = "abcde";
		String str4 = "tmmzuxt";
		String str5 = "abcbcd";
        String str6 = " ";
		for (int i = 0; i < str.length(); i++)
			System.out.print(str.charAt(i) + " ");
		System.out.println("\n max length:" + lengthOfLongestSubstring00(str));
		System.out.println("\n max length:" + lengthOfLongestSubstring00(str1));
		System.out.println("\n max length:" + lengthOfLongestSubstring00(str2));
		System.out.println("\n max length:" + lengthOfLongestSubstring00(str3));
		System.out.println("\n max length:" + lengthOfLongestSubstring00(str4));
		System.out.println("\n max length:" + lengthOfLongestSubstring00(str5));
        System.out.println("\n max length:" + lengthOfLongestSubstring00(str6));
	}

	/* sliding window 0 */
	public static int lengthOfLongestSubstring00(String s) {
		int maxlen = s.length();
		int max = 0;
		int i = 0, j = 0;
		int[] indexes = new int[256];
		for (j = 0; j < maxlen; j++) {
			i = Math.max(indexes[s.charAt(j)], i);
			max = Math.max(max, j - i + 1);
			indexes[s.charAt(j)] = j + 1;
			if (max >= maxlen - i)
				break;
		}
		return max;
	}

	/* sliding window 1 */
	public static int lengthOfLongestSubstring0(String s) {
		int maxlen = s.length();
		int max = 0;
		int i = 0, j = 0;
		int[] indexes = new int[512];
		while (i < maxlen && j < maxlen) {
			if (indexes[s.charAt(j)] == 1) {
				indexes[s.charAt(i++)] = 0;
			} else {
				indexes[s.charAt(j++)] = 1;
				max = Math.max(max, j - i);
			}
			if (max >= maxlen - i)
				break;
		}
		return max;
	}

	/* sliding window 2 */
	public static int lengthOfLongestSubstring(String s) {
		int maxlen = s.length();
		int max = 0;
		int i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (i < maxlen && j < maxlen) {
			if (map.containsKey(s.charAt(j))) {
				map.remove(s.charAt(i++));
			} else {
				map.put(s.charAt(j), j++);
				max = Math.max(max, j - i);
			}
			if (max >= maxlen - i)
				break;
		}
		return max;
	}

	public static int lengthOfLongestSubstring1(String s) {
		int[] byteSet = new int[1024];
		int maxlen = s.length();
		int max = 0;
		int i, j;
		for (i = 0; i < maxlen; i++) {
			for (j = i; j < maxlen; j++) {
				if (byteSet[s.charAt(j)] == 1) {
					max = max > (j - i) ? max : (j - i);
					break;
				} else
					byteSet[s.charAt(j)] = 1;
			}
			for (int ii = 0; ii < 1024; ii++)
				byteSet[ii] = 0;
			if (j == maxlen) {
				max = max > (j - i) ? max : (j - i);
				break;
			}
			if (max >= (maxlen - (i + 1)))
				break;
		}
		return max;
	}

	public static int lengthOfLongestSubstring2(String s) {
		Set<Character> existSet = new HashSet<>();
		int maxlen = s.length();
		int max = 0;
		int i, j;
		for (i = 0; i < maxlen; i++) {
			for (j = i; j < maxlen; j++) {
				if (existSet.contains(s.charAt(j))) {
					max = max > (j - i) ? max : (j - i);
					break;
				} else
					existSet.add(s.charAt(j));
			}
			existSet.clear();
			if (j == maxlen) {
				max = max > (j - i) ? max : (j - i);
				break;
			}
			if (max >= (maxlen - (i + 1)))
				break;
		}
		return max;
	}

	/**
	 * @deprecated
	 */
	public static int lengthOfLongestSubstring_d1(String s) {
		Set<Character> existSet = new HashSet<>();
		String substr = null;
		int[] indexes = new int[s.length()];
		for (int j = 0; j < s.length(); j++) {
			substr = s.substring(j);
			int i;
			for (i = 0; i < substr.length(); i++) {
				if (existSet.contains(substr.charAt(i)))
					break;
				else
					existSet.add(substr.charAt(i));
			}
			indexes[j] = i;
			existSet.clear();
		}
		int max = 0;
		for (int tmp : indexes)
			max = tmp > max ? tmp : max;
		return max;
	}
}
