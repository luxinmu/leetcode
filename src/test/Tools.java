package test;

public class Tools {

	public static void printArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + (i == nums.length - 1 ? "" : ","));
		System.out.println();
	}

	public static void printArray(int[][] nums) {
		if (nums == null || nums.length == 0)
			return;
		System.out.print("[");
		int k = 0;
		for (int nums0[] : nums) {
			for (int i = 0; nums0 != null && i < nums0.length; i++)
				System.out.print(nums0[i] + (i == nums0.length - 1 ? "" : ","));
			System.out.print(k++ < nums.length - 1 ? "],[" : "");
		}
		System.out.println("]");
	}
}
