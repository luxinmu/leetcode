package test;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {
    }

    public ListNode append(int val) {
        this.next = new ListNode(val);
        return this.next;
    }

    public ListNode append(int[] nums) {
        if (nums == null || nums.length == 0) return this;
        ListNode tail = new ListNode(nums[0]);
        this.next = tail;
        for (int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        return tail;
    }

    public static ListNode create(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ListNode();
        ListNode head = new ListNode(nums[0]);
        ListNode head0 = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return head0;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? "->" : ""));
            head = head.next;
        }
        System.out.println();
    }
}
