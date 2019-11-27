package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class T93_RestoreIPAddresses {

    public static void main(String[] args) {
        T93_RestoreIPAddresses t93 = new T93_RestoreIPAddresses();
        System.out.println(t93.restoreIpAddresses("0000"));
        System.out.println(t93.restoreIpAddresses("010010"));
        System.out.println(t93.restoreIpAddresses("25525511135"));
        System.out.println(t93.restoreIpAddresses("252511135"));
        System.out.println(t93.restoreIpAddresses("25021113"));
    }

    /**
     * 整整齐齐的暴力法
     * 执行用时 : 2 ms , 97.72%
     * 内存消耗 : 36 MB , 54.61%
     */
    public List<String> restoreIpAddresses(String s) {
        if (s == null) return null;
        int len = s.length();
        int ip0, ip1, ip2, ip3;
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= 3; i++)
            for (int j = i + 1; j <= i + 3; j++)
                for (int k = j + 1; k <= j + 3; k++)
                    for (int l = k + 1; l <= k + 3; l++)
                        if (l == len)
                            if ((i == 1 || s.charAt(0) != '0')
                                    && (j - i == 1 || s.charAt(i) != '0')
                                    && (k - j == 1 || s.charAt(j) != '0')
                                    && (l - k == 1 || s.charAt(k) != '0')) {
                                ip0 = Integer.parseInt(s.substring(0, i));
                                ip1 = Integer.parseInt(s.substring(i, j));
                                ip2 = Integer.parseInt(s.substring(j, k));
                                ip3 = Integer.parseInt(s.substring(k));
                                if (ip0 <= 255 && ip1 <= 255 && ip2 <= 255 && ip3 <= 255)
                                    ans.add(ip0 + "." + ip1 + "." + ip2 + "." + ip3);
                            }
        return ans;
    }
}
