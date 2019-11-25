package test;

import java.util.ArrayList;
import java.util.List;

public class T60_PermutationSequence {

	public static void main(String[] args) {
		T60_PermutationSequence t60 = new T60_PermutationSequence();
		System.out.println(t60.getPermutation(1, 1));
//		System.out.println(t60.getPermutation(2, 2));
		System.out.println(t60.getPermutation(3, 3));
		System.out.println(t60.getPermutation(4, 9));
	}

	public String getPermutation(int n, int k) {
		if (n == 1)
			return "1";
		int nums[] = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		boolean visited[] = new boolean[n];
		List<Integer> list = new ArrayList<>(n);
		StringBuilder sb = new StringBuilder();
		int tot = 1;
		for (int i = 1; i < n; i++)
			tot *= i;
		int start = k / tot;
		visited[0] = true;
		list.add(nums[start]);
		int tmp = nums[start];
		nums[start] = nums[0];
		nums[0] = tmp;
		getPermutation0(nums, list, visited, start * tot, k);
		for (int i : list)
			sb.append(i);
		return sb.toString();
	}

	public int getPermutation0(int nums[], List<Integer> list, boolean visited[], int c, final int k) {
		if (nums.length == list.size())
			return c + 1;
		for (int i = 0; i < nums.length; i++)
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				c = getPermutation0(nums, list, visited, c, k);
				if (c == k)
					return k;
				list.remove(list.size() - 1);
				visited[i] = false;
			}
		return c;
	}

	public String getPermutation1(int n, int k) {
		int nums[] = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		boolean visited[] = new boolean[n];
		List<Integer> list = new ArrayList<>(n);
		getPermutation0(nums, list, visited, 0, k);
		StringBuilder sb = new StringBuilder();
		for (int i : list)
			sb.append(i);
		return sb.toString();
	}
}
