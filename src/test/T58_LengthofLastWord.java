package test;

public class T58_LengthofLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world  "));
		System.out.println(lengthOfLastWord("hello world"));
		System.out.println(lengthOfLastWord("hello world find"));
	}

	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ')
				len++;
			else if (len > 0)
				break;
		}
		return len;
	}

}
