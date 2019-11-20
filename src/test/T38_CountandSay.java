package test;

public class T38_CountandSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
	}

	public static String countAndSay(int n) {
		char cn[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuilder sb = new StringBuilder();
		sb.append('1');
		while (--n > 0) {
			int count = 0;
			String tmp = sb.toString();
			sb.delete(0, tmp.length()); // KEYPOINT
			char target = tmp.charAt(0); // KEYPOINT
			for (char c : tmp.toCharArray())
				if (c == target)
					count++;
				else {
					sb.append(cn[count]).append(target);
					target = c;
					count = 1;
				}
			sb.append(cn[count]).append(target);
		}
		return sb.toString();
	}

	public static String countAndSay1(int n) {
		char cn[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuilder sb = new StringBuilder();
		sb.append('1');
		int count = 1;
		while (--n > 0) {
			String tmp = sb.toString();
			sb = new StringBuilder();
			for (int i = 0; i <= tmp.length() - 1; i++)
				if (i + 1 <= tmp.length() - 1 && tmp.charAt(i) == tmp.charAt(i + 1))
					count++;
				else {
					sb.append(cn[count]).append(tmp.charAt(i));
					count = 1;
				}
		}
		return sb.toString();
	}

}
