package test;

import java.util.Stack;

public class T20_ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("{)"));
		System.out.println(isValid("{}[]()"));
		System.out.println(isValid("{[]()}"));
		System.out.println(isValid("{[]}()"));
		System.out.println(isValid("{[}]()"));
	}

	public static boolean isValid(String s) {
        if (s == null)
			return false;
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '('))
					return false;
			}
		}
		return stack.isEmpty() ? true : false;
    }
}
