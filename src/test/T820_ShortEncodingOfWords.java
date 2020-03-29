package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 820. Short Encoding of Words
 * Difficult: Medium
 * <p>
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 * For example, if the list of words is ["time", "me", "bell"],
 * we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 * Then for each index, we will recover the word by reading from the reference string from that
 * index until we reach a "#" character.
 * What is the length of the shortest reference string S possible that encodes the given words?
 * <p>
 * Example:
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 * <p>
 * Note:
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 */
public class T820_ShortEncodingOfWords {
    public static void main(String[] args) {
        T820_ShortEncodingOfWords test = new T820_ShortEncodingOfWords();
        System.out.println(test.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(test.minimumLengthEncoding(new String[]{"time", "me", "bell", "el"}));
        System.out.println(test.minimumLengthEncoding(new String[]{"time", "me", "bell", "ell"}));
    }

    /**
     * 字典树的解法
     */
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int ans = 0;
        return ans;
    }




    /**
     * 使用Set存储后缀，保留所有不是其他单词后缀的单词
     * 执行用时 :19 ms, 在所有 Java 提交中击败了93.51% 的用户
     * 内存消耗 :41.7 MB, 在所有 Java 提交中击败了16.66%的用户
     */
    public int minimumLengthEncoding1(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        // 先将所有单词放入set
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words)
            for (int i = 1; i < word.length(); i++)
                set.remove(word.substring(i)); //移除与单词相同后缀的所有单词
        int ans = 0;
        for (String s : set)
            ans += s.length() + 1;
        return ans;
    }
}
