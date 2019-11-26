package test;

public class T81_SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        T81_SearchInRotatedSortedArrayII t81 = new T81_SearchInRotatedSortedArrayII();
        System.out.println(t81.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(t81.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(t81.search(new int[]{3, 1, 1}, 3));
        System.out.println(t81.search(new int[]{3, 1}, 3));
        System.out.println(t81.search(new int[]{3, 1, 1, 1, 1}, 3));
        System.out.println(t81.search(new int[]{1}, 1));
        System.out.println(t81.search(new int[]{1, 1, 3, 1}, 3));
    }

    /**
     * 执行用时 :1 ms, 99.69%
     * 内存消耗 :38.4 MB, 36.61%
     */
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end + start) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[start]) {  //KEYPOINT
                start++;
                continue;
            } else if (nums[mid] == nums[end]) {  //KEYPOINT
                end--;
                continue;
            }
            if (nums[end] > nums[mid]) // mid右侧单调递增    //KEYPOINT
                if (nums[mid] < target && target <= nums[end]) //在单调递增区间内
                    start = mid + 1;
                else
                    end = mid - 1;
            else { // mid左侧单调递增    //KEYPOINT
                if (nums[start] <= target && target <= nums[mid]) //在单调递增区间内
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return false;
    }
}
