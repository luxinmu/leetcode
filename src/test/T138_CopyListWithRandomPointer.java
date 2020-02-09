package test;

import java.util.HashMap;
import java.util.Map;

/*
 * 138. Copy List with Random Pointer
 * Difficult: Medium
 * <p>
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * The Linked List is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to,
 * or null if it does not point to any node.
 * <p>
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * <p>
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * <p>
 * Constraints:
 * -10000 <= Node.val <= 10000
 * Node.random is null or pointing to a node in the linked list.
 * Number of Nodes will not exceed 1000.
 */

/**
 * @see T133_CloneGraph
 */
public class T138_CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n1.random = n3;
        n2.random = n1;
        n3.random = n1;
        T138_CopyListWithRandomPointer t = new T138_CopyListWithRandomPointer();
        Node.show(n1);
        Node.show(t.copyRandomList(n1));
    }

    private Map<Node, Node> map = new HashMap<>();

    /**
     * 递归解法(DFS)
     * 执行用时 :1 ms, 77.66%
     * 内存消耗 :39.3 MB, 14.77%
     **/
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        //查找map中是否存在，head-> new Node的映射，存在则直接返回head节点对应的new Node；
        if (map.containsKey(head))
            return map.get(head);
        //若不存在，则创建节点，值同head相同，同时将head和新节点的对应关系放入map；
        Node node = new Node(head.val);
        map.put(head, node);
        //递归的创建next和random引用指向的节点。
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public static void show(Node head) {
            while (head != null) {
                System.out.print(head.val + ", ");
                head = head.next;
            }
            System.out.println();
        }
    }
}
