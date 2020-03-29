package test;

/**
 * 208. Implement Trie (Prefix Tree)
 * Difficult: Medium
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class T208_ImplementTrie {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
        t.insert("app");
        System.out.println(t.search("app"));
    }


    /**
     * 执行用时 :43 ms, 在所有 Java 提交中击败了88.57% 的用户
     * 内存消耗 :53.8 MB, 在所有 Java 提交中击败了33.42%的用户
     * <p>
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static class Trie {

        static class TrieNode {
            private static final int MAX_LINKS_NUM = 26;

            boolean end;

            TrieNode[] links;

            public TrieNode() {
                end = false;
                links = new TrieNode[MAX_LINKS_NUM];
            }

            public boolean isEnd() {
                return end;
            }

            public void setEnd() {
                this.end = true;
            }

            public boolean containsKey(char key) {
                return links[key - 'a'] != null;
            }

            public void put(char key, TrieNode node) {
                links[key - 'a'] = node;
            }

            public TrieNode get(char key) {
                return links[key - 'a'];
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.containsKey(c)) {
                    cur.put(c, new TrieNode());
                }
                cur = cur.get(c);
            }
            cur.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = search0(word);
            return node != null && node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return null != search0(prefix);
        }

        private TrieNode search0(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.containsKey(c))
                    return null;
                cur = cur.get(c);
            }
            return cur;
        }
    }
}
