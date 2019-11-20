package test;

public class T53_MaximumSubarray {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { 1 }));
		System.out.println(maxSubArray(new int[] { 1, -1, -2 }));
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int ans = nums[0];
		int sum = 0;
		for (int n : nums)
			ans = Math.max(sum = sum > 0 ? sum + n : n, ans);
		return ans;
	}

	/**
	 * 如果sum < 0, 找到最大的负数；如果sum>0,找到所有sum组合中的最大的
	 */
	public static int maxSubArray0(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int ans = nums[0];
		int sum = 0;
		for (int n : nums) {
			if (sum > 0)
				sum += n;
			else
				sum = n;
			ans = Math.max(sum, ans);
		}
		return ans;
	}

	public static int maxSubArray1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int ans = Integer.MIN_VALUE;
		int i = 0;
		int sum = nums[0];
		while (++i < nums.length) {
			ans = Math.max(ans, sum);
			sum = sum < 0 ? Math.max(sum, nums[i]) : sum + nums[i];
		}
		return Math.max(ans, sum);
	}
}
