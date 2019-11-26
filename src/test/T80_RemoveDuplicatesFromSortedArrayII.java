package test;

public class T80_RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        T80_RemoveDuplicatesFromSortedArrayII t80 = new T80_RemoveDuplicatesFromSortedArrayII();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(t80.removeDuplicates(nums));
        Tools.printArray(nums);
        int[] nums1 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(t80.removeDuplicates(nums1));
        Tools.printArray(nums1);
    }

    /**
     * 执行用时 :1 ms, 99.91%
     * 内存消耗 :37.1 MB, 98.32%
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int len = 0;
        for (int n : nums)
            if (len < 2 || n > nums[len - 2])
                nums[len++] = n;
        return len;
    }

    /**
     * 执行用时 :1 ms, 99.91%
     * 内存消耗 :36.5 MB, 99.74%
     */
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            if (i == 0 || nums[i] == nums[len - 1]) {
                if (count < 2) {
                    nums[len++] = nums[i];
                    count++;
                }
            } else {
                count = 1;
                nums[len++] = nums[i];
            }
        return len;
    }
}
