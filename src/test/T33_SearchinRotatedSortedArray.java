package test;

public class T33_SearchinRotatedSortedArray {

	public static void main(String[] args) {

		int nums[] = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		Tools.printArray(nums);
		System.out.println(search(nums, 0));
		System.out.println(search(nums, 3));
		int nums1[] = new int[] { 7, 8, 1, 2, 3, 4, 5, 6 };
		Tools.printArray(nums1);
		System.out.println(search(nums1, 2));
		System.out.println(search(nums1, 0));
		System.out.println(search(nums1, 1));
		int nums2[] = new int[] { 7 };
		Tools.printArray(nums2);
		System.out.println(search(nums2, 7));
		System.out.println(search(nums2, 0));
		int nums3[] = new int[] { 1, 7 };
		Tools.printArray(nums3);
		System.out.println(search(nums3, 7));
		System.out.println(search(nums3, 0));
	}

	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid;
        while (start <= end) { // KEYPOINT
			mid = (end + start) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[end] > nums[mid]) // mid右侧单调递增    -->> KEYPOINT
				if (nums[mid] < target && target <= nums[end]) //在单调递增区间内
					start = mid + 1;
				else
					end = mid - 1;
			else { // mid左侧单调递增    -->> KEYPOINT
				if (nums[start] <= target && target <= nums[mid]) //在单调递增区间内
					end = mid - 1;
				else
					start = mid + 1;
			}
		}
		return -1;
	}

	public static int search2(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = (end + start) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				if (nums[end] > nums[mid] && nums[end] < target)
					end = mid - 1;
				else
					start = mid + 1;
			else {
				if (nums[end] <= nums[mid] && nums[start] > target)
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	public static int search1(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = (end + start) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				if (nums[end] > nums[mid])
					if (nums[end] < target)
						end = mid - 1;
					else
						start = mid + 1;
				else
					start = mid + 1;
			else {
				if (nums[end] > nums[mid])
					end = mid - 1;
				else {
					if (nums[start] > target)
						start = mid + 1;
					else
						end = mid - 1;
				}
			}
		}
		return -1;
	}

	public static int searchErr(int[] nums, int target) {
		int i;
		for (i = 0; i < nums.length - 1; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}
}
