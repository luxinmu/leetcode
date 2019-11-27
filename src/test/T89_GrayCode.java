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
     * ��ʵ����һ���������뵽�������ת����
     * �������£�
     * G[i]��ʾ������ĵ�iλ��B[i]��ʾҪת���Ķ�������ĵ�iλ
     * G[high] = B[high]
     * G[i] = B[i] ^ B[i-1] �������������� G = B ^ B>>1��
     * n��bit�Ķ�����������Ӧ1<<n��������
     *
     * ִ����ʱ :1 ms, 98.13%
     * �ڴ����� :34 MB, 29.30%
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++)
            ans.add(i ^ i >> 1);  // KEYPOINT
        return ans;
    }
}
