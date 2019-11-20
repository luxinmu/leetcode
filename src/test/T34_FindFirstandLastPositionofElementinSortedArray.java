package test;

public class T34_FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		int nums[] = new int[] { 5, 7, 7, 8, 8, 10 };
		Tools.printArray(nums);
		Tools.printArray(searchRange(nums, 8));
		Tools.printArray(searchRange(nums, 5));
		Tools.printArray(searchRange(nums, 6));
		int nums1[] = new int[] { 1, 1, 1, 1, 1, 1 };
		Tools.printArray(nums1);
		Tools.printArray(searchRange(nums1, 1));
		Tools.printArray(searchRange(nums1, 0));
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		int ans[] = { -1, -1 };
		int start = 0, end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] == target) {
				if (mid - 1 >= 0 && nums[mid - 1] == target) {
					end = mid - 1;
				} else {
					ans[0] = mid;
					break;
				}
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		if (ans[0] == -1)
			return ans;
		start = 0;
		end = nums.length - 1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] == target) {
				if (mid + 1 <= nums.length - 1 && nums[mid + 1] == target) {
					start = mid + 1;
				} else {
					ans[1] = mid;
					break;
				}
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return ans;
	}
}
