package test;

import java.util.ArrayList;
import java.util.List;

public class T89_GrayCode {
    public static void main(String[] args) {
        T89_GrayCode t89 = new T89_GrayCode();
        System.out.println(t89.grayCode(0));
        System.out.println(t89.grayCode(1));
        System.out.println(t89.grayCode(2));
        System.out.println(t89.grayCode(3));
        System.out.println(t89.grayCode(4));
    }

    /**
     * 其实就是一个二进制码到格雷码的转换，
     * 方法如下：
     * G[i]表示格雷码的第i位，B[i]表示要转换的二进制码的第i位
     * G[high] = B[high]
     * G[i] = B[i] ^ B[i-1] 整体来看，就是 G = B ^ B>>1，
     * n个bit的二进制数，对应1<<n个格雷码
     *
     * 执行用时 :1 ms, 98.13%
     * 内存消耗 :34 MB, 29.30%
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++)
            ans.add(i ^ i >> 1);  // KEYPOINT
        return ans;
    }
}
