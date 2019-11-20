package test;

public class T5_LongestPalindrome {

	public static void main(String[] args) {
		String s1 = "aba";
		String s2 = "ababc";
		String s3 = "abbcdebcde";
		String s4 = "";
		String s5 = "a";
		String s6 = "aaa";
		String s7 = "abababab";
		String s8 = "abba";
		System.out.println("string:" + s3 + "\n ans:" + longestPalindrome(s3));
		System.out.println("string:" + s8 + "\n ans:" + longestPalindrome(s8));
		System.out.println("string:" + s1 + "\n ans:" + longestPalindrome(s1));
		System.out.println("string:" + s2 + "\n ans:" + longestPalindrome(s2));
		System.out.println("string:" + s4 + "\n ans:" + longestPalindrome(s4));
		System.out.println("string:" + s5 + "\n ans:" + longestPalindrome(s5));
		System.out.println("string:" + s6 + "\n ans:" + longestPalindrome(s6));
		System.out.println("string:" + s7 + "\n ans:" + longestPalindrome(s7));
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	public static String longestPalindrome1(String s) {
		if (s == null || s.length() < 1)
			return "";
		int i, len1, len2, len = 0;
		int start = 0, end = 0;
		int L, R;
		int maxlen = s.length();
		for (i = 0; i < maxlen; i++) {
			L = i;
			R = i;
			while (L >= 0 && R < maxlen && s.charAt(L) == s.charAt(R)) {
				L--;
				R++;
			}
			len1 = R - L - 1;
			L = i;
			R = i + 1;
			while (L >= 0 && R < maxlen && s.charAt(L) == s.charAt(R)) {
				L--;
				R++;
			}
			len2 = R - L - 1;
			len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	public static String longestPalindromeErr(String s) {
		if (s == null || s.length() < 1)
			return "";
		int i, j;
		int maxlen = s.length();
		int indexes[] = new int[256];
		int diff = 0;
		String longest = "";
		boolean equal = true;
		for (j = 0; j < maxlen; j++) {
			if (indexes[s.charAt(j)] > 0) {
				equal = true;
				diff = j - indexes[s.charAt(j)] + 1;
				for (i = indexes[s.charAt(j)]; i < diff; i++) {
					if (i + diff >= maxlen || s.charAt(i) != s.charAt(i + diff)) {
						equal = false;
						break;
					}
				}
				if (equal)
					if (longest.length() < j - (indexes[s.charAt(j)] - 1))
						longest = s.substring(indexes[s.charAt(j)] - 1, j + 1);
			}
			indexes[s.charAt(j)] = j + 1;
		}
		if (longest.length() == 0) {
			longest = s.length() == 0 ? "" : s.substring(0, 1);
		}
		return longest;
	}
}
