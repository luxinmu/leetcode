package test;

/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class T4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        T4_MedianOfTwoSortedArrays t4 = new T4_MedianOfTwoSortedArrays();
        System.out.println(t4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(t4.findMedianSortedArrays(new int[]{1, 2, 6, 7}, new int[]{3, 4, 5, 8}));
        System.out.println(t4.findMedianSortedArrays(new int[]{1, 2, 6}, new int[]{3, 4, 5, 8}));
        System.out.println(t4.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    /**
     * 执行用时 : 3 ms , 98.72%
     * 内存消耗 : 46.1 MB , 97.14%
     * 时间复杂度 : O(log(min(M + N)))
     * 空间复杂度 : O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null)
            throw new IllegalArgumentException("parameters error!");
        if (nums1 == null)
            return findMedianSortedArrays(new int[]{}, nums2);
        else if (nums2 == null)
            return findMedianSortedArrays(new int[]{}, nums1);
        else if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);  //为了减少比较次数, 从较短的数组中二分查找
        }
        int m = nums1.length;
        int n = nums2.length;
        int i, j;  //i为nums1的分割位置, j为nums2的分割位置
        int left = 0;
        int right = m;
        /* 需满足:
         * 1、 i + j = (nums1.length + nums2.length + 1) / 2
         * 2、nums1[i - 1] <= nums2[j] and nums1[i] >= nums2[j - 1]
         */
        int totLeft = (m + n + 1) >>> 1;  //总的左偏移量
        while (left < right) {
            i = (left + right) >>> 1;
            j = totLeft - i;
            if (nums1[i] < nums2[j - 1])
                left = i + 1;
            else
                right = i;
        }
        i = left;
        j = totLeft - i;
        int iLeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int iRightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int jLeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int jRightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if (((m + n) & 1) == 1)
            return Math.max(iLeftMax, jLeftMax);
        else
            return (double) (Math.max(iLeftMax, jLeftMax) + Math.min(iRightMin, jRightMin)) / 2;
    }
}
