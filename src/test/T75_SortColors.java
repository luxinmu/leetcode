package test;

public class T75_SortColors {
    public static void main(String[] args) {
        T75_SortColors t75 = new T75_SortColors();
        int[] nums1 = {2, 0, 1, 1, 0, 2, 1};
        t75.sortColors(nums1);
        Tools.printArray(nums1);
        int[] nums2 = {2, 0, 1};
        t75.sortColors(nums2);
        Tools.printArray(nums2);
        int[] nums3 = {1, 2, 0};
        t75.sortColors(nums3);
        Tools.printArray(nums3);
        int[] nums4 = {2, 1, 2};
        t75.sortColors(nums4);
        Tools.printArray(nums4);
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :35 MB, 43.52%
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        int tmp;
        while (cur <= right)
            if (nums[cur] == 0) {
                tmp = nums[left];
                nums[left++] = nums[cur];
                nums[cur++] = tmp;
            } else if (nums[cur] == 2) {
                tmp = nums[right];
                nums[right--] = nums[cur];
                nums[cur] = tmp;
            } else
                cur++;
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :35 MB, 42.81%
     */
    public void sortColors1(int[] nums) {
        int[] counts = {0, 0, nums.length - 1};
        int tmp;
        for (int i = 0; i < nums.length; i++)
            if (i <= counts[2] && nums[i] != 1) {
                tmp = nums[i];
                nums[i] = nums[counts[tmp]];
                nums[counts[tmp]] = tmp;
                counts[tmp] += (tmp == 0 ? 1 : -1);
                if (tmp == 2)  // KEYPOINT
                    i--;
            }
    }
}
