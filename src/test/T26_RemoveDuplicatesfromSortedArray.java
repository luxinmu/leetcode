package test;

public class T26_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		int[] arr0 = new int[] { 1 };
		Tools.printArray(arr0);
		System.out.println("len=" + removeDuplicates(arr0));
		Tools.printArray(arr0);

		int[] arr1 = new int[] { 1, 1, 2 };
		Tools.printArray(arr1);
		System.out.println("len=" + removeDuplicates(arr1));
		Tools.printArray(arr1);

		int[] arr2 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		Tools.printArray(arr2);
		System.out.println("len=" + removeDuplicates(arr2));
		Tools.printArray(arr2);
	}

	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int slow = 0, fast = 0;
		while (++fast < nums.length)
			if (nums[slow] != nums[fast])
				nums[++slow] = nums[fast];
		return slow + 1;

	}

	public static int removeDuplicates10(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		int j = i + 1;
		int k = 0;
		while (i < nums.length) {
			if (j < nums.length && nums[i] == nums[j])
				j++;
			else {
				nums[k++] = nums[i];
				i = j;
				j = i + 1;
			}
		}
		return k;
	}
}
