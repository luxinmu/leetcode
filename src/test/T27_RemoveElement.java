package test;

public class T27_RemoveElement {

	public static void main(String[] args) {
		int[] arr0 = new int[] { 1 };
		Tools.printArray(arr0);
		System.out.println("len=" + removeElement(arr0, 1));
		Tools.printArray(arr0);

		int[] arr1 = new int[] { 1, 1, 2 };
		Tools.printArray(arr1);
		System.out.println("len=" + removeElement(arr1, 1));
		Tools.printArray(arr1);

		int[] arr2 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		Tools.printArray(arr2);
		System.out.println("len=" + removeElement(arr2, 1));
		Tools.printArray(arr2);
	}

	public static int removeElement1(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val)
				nums[i++] = nums[j];
		}
		return i;
	}

	public static int removeElement(int[] nums, int val) {
		int i = 0;
		int n = nums.length - 1;
		while (i <= n) {
			if (nums[i] != val)
				i++;
			else
				nums[i] = nums[n--];
		}
		return i;
	}

}
