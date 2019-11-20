package test;

public class T55_JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	/**
	 * ����˼·:
	 * <p>
	 * 1 ����ȫ��Ϊ���ڵ���1��ֵ, ����ܵ����һ������<br>
	 * 2 ������Ϊ0��ֵ, ���ж�0ֵ֮ǰ������, �Ƿ�����Խ��0ֵλ�õ���, ��û��, ���ܴﵽ�������
	 */
	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int len = nums.length;
		if (len == 1)
			return true;
		int i;
		int j;
		for (i = len - 2; i >= 0; i--) {
			if (nums[i] == 0) { // KEYPOINT
				for (j = i - 1; j >= 0; j--) {
					if (nums[j] > i - j)
						break;
				}
				if (j == -1)
					return false;
			}
		}
		return i == -1 ? true : false;
	}

	public static boolean canJump1(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		if (nums[0] >= nums.length - 1)
			return true;
		return canJump10(nums, 0);
	}

	public static boolean canJump10(int[] nums, int start) {
		int max = nums[start];
		while (max > 0) {
			if (start + max >= nums.length - 1)
				return true;
			else if (canJump10(nums, start + max))
				return true;
			max--;
		}
		return false;
	}
}
