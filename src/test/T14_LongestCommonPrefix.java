package test;

public class T14_LongestCommonPrefix {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {}));
		System.out.println(longestCommonPrefix(new String[] { "aa", "ab", "ac" }));
		System.out.println(longestCommonPrefix(new String[] { "hello", "hella", "helo" }));
		System.out.println(longestCommonPrefix(new String[] { "hello", "world", "helo" }));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int minlen = strs[0].length();
		int i = 0;
		for (String s : strs) {
			minlen = Math.min(s.length(), minlen);
		}
		for (i = 0; i < minlen; i++)
			for (int j = 0; j < strs.length - 1; j++)
				if (strs[j].charAt(i) != strs[j + 1].charAt(i))
					return i == 0 ? "" : strs[0].substring(0, i);
		return i == 0 ? "" : strs[0].substring(0, i);
	}
}
