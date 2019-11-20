package test;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers. If such arrangement is
 * not possible, it must rearrange it as the lowest possible order (ie, sorted
 * in ascending order). The replacement must be in-place and use only
 * constant extra memory. Here are some examples. Inputs are in the left-hand
 * column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2 <br>
 * 3,2,1 → 1,2,3 <br>
 * 1,1,5 → 1,5,1 <br>
 */
public class T31_NextPermutation {

	public static void main(String[] args) {
		int nums0[] = new int[] { 3, 2, 1 };
		nextPermutation(nums0);
		Tools.printArray(nums0);
		int nums1[] = new int[] { 1, 3, 5 };
		nextPermutation(nums1);
		Tools.printArray(nums1);
		int nums2[] = new int[] { 6, 3, 5 };
		nextPermutation(nums2);
		Tools.printArray(nums2);
		int nums3[] = new int[] { 1, 2 };
		nextPermutation(nums3);
		Tools.printArray(nums3);
		int nums4[] = new int[] { 1 };
		nextPermutation(nums4);
		Tools.printArray(nums4);
		int nums5[] = new int[] { 1, 1 };
		nextPermutation(nums5);
		Tools.printArray(nums5);
		int nums6[] = new int[] { 1, 3, 2 };
		nextPermutation(nums6);
		Tools.printArray(nums6);
	}


	/**
	 * 源于离散数学及其应用的算法：（以3 4 5 2 1 为例） <br>
	 * 从后往前寻找第一次出现的正序对：（找到 4,5） <br>
	 * 之后4 的位置应该是：在它之后的，比4大的最小值[5] <br>
	 * 交换这两个值：得到 3 5 4 2 1 <br>
	 * 之后因为从5位置之后的位置都是逆序，所以把他们反转：3 5 1 2 4 <br>
	 * 对于初始即为逆序的序列，将在反转步骤直接完成
	 */
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		int tmp;
		// find first ascend pairs from behind
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
		if (i >= 0) {
			// find first more than nums[i]
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j])
				j--;
			// swap
			tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		// reverse
		int start = i + 1;
		int end = nums.length - 1;
		while (start < end) {
			tmp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = tmp;
		}
	}
}
