package test;

public class T88_MergeSortedArray {
    public static void main(String[] args) {
        T88_MergeSortedArray t88 = new T88_MergeSortedArray();
        int[] nums1 = {1, 2, 6, 7, 0, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6, 8};
        t88.merge(nums1, 4, nums2, 4);
        Tools.printArray(nums1);
        int[] nums3 = {1, 2, 3, 0, 0, 0};
        int[] nums4 = new int[]{2, 5, 6};
        t88.merge(nums3, 3, nums4, 3);
        Tools.printArray(nums3);
    }

    /**
     * 关键点是从后往前放
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :36 MB, 85.64%
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return;
        int i = m - 1, j = n - 1;
        int k = nums1.length - 1;
        while (i >= 0 && j >= 0)
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];

        while (j >= 0)
            nums1[k--] = nums2[j--];
    }

    /**
     * 执行用时 :0 ms, 100.00%
     * 内存消耗 :36.1 MB, 84.94%
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return;
        int i = m - 1, j = n - 1;
        int k = nums1.length - 1;
        while (j >= 0)
            nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    }
}
