package test;

/**
 * 707. Design Linked List
 * Difficult: Medium
 */
class MyLinkedList {

    int size;
    ListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new ListNode(0); //dummy
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size - 1)
            return -1;
        ListNode p = head.next;
        while (index-- > 0)
            p = p.next;
        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion,
     * the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;

        if (index < 0)
            index = 0;

        ListNode p = head;
        while (index-- > 0)
            p = p.next;
        ListNode node = new ListNode(val);
        node.next = p.next;
        p.next = node;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1)
            return;
        ListNode p = head;
        while (index-- > 0)
            p = p.next;
        p.next = p.next.next;
        size--;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

/*
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
