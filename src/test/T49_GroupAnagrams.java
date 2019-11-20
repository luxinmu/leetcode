package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T49_GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "fin", "ell", "nat", "bat" }));
		System.out.println(
				groupAnagrams(new String[] { "cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc" }));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 }; // KEYPOINT
		List<List<String>> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int uniqueId;
		for (String s : strs) {
			uniqueId = 1;
			for (char c : s.toCharArray())
				uniqueId *= prime[c - 'a']; // KEYPOINT
			if (map.get(uniqueId) == null) {
				map.put(uniqueId, i++);
				List<String> list = new ArrayList<>();
				list.add(s);
				ans.add(list);
			} else
				ans.get(map.get(uniqueId)).add(s);
		}
		return ans;
	}

	public static List<List<String>> groupAnagrams9(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();
		List<List<String>> ans = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int i = 0;
		for (String s : strs) {
			char cn[] = s.toCharArray();
			Arrays.sort(cn);
			String tmp = new String(cn);
			System.out.println(s + " " + tmp);
			if (map.get(tmp) == null) {
				map.put(tmp, i++);
				List<String> list = new ArrayList<>();
				list.add(s);
				ans.add(list);
			} else {
				ans.get(map.get(tmp)).add(s);
			}
		}
		return ans;
	}

}
