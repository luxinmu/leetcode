package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T39_CombinationSum {

	public static void main(String[] args) {
		int nums[] = { 2, 3, 6, 7 };
		System.out.println(combinationSum(nums, 7));
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Set<Integer> set = new HashSet<>();
		List<List<Integer>> list = new ArrayList<>();
		for (int i : candidates) {
			if (target == i) {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				list.add(l);
			} else {
				if(set.contains(i))
				set.add(target - i);
				
			}

		}
		return list;
	}
}
