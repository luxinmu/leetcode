package test;

public class T35_SearchInsertPosition {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 3, 5, 6};
        Tools.printArray(nums);
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }

    public static int searchInsert1(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}
