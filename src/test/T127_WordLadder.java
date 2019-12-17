package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 127. Word Ladder
 * Difficult: Medium
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * <p>
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class T127_WordLadder {
    public static void main(String[] args) {
        T127_WordLadder t127 = new T127_WordLadder();
        System.out.println(t127.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    /**
     * BFS
     * 执行用时 : 402 ms ,  33.10%
     * 内存消耗 : 37.1 MB ,  94.99%
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        int size = wordList.size();
        int len = 1;
        boolean visited[] = new boolean[size];
        queue.offer(beginWord);
        String cur;
        int curSize;
        while (!queue.isEmpty()) {
            len++;
            curSize = queue.size();
            while (curSize-- > 0 && !queue.isEmpty()) {
                cur = queue.poll();
                for (int i = 0; i < size; i++)
                    if (!visited[i])
                        if (diff1(cur, wordList.get(i))) {
                            if (wordList.get(i).equals(endWord))
                                return len;
                            queue.offer(wordList.get(i));
                            visited[i] = true;
                        }
            }
        }
        return 0;
    }

    private boolean diff1(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i)) count++;
        return count < 2;
    }

}
