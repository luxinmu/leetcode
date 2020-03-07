package test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 137. Single Number II
 * Difficult: Medium
 * Given a non-empty array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 * <p>
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class T137_SingleNumberII {

    public static void main(String[] args) {
        T137_SingleNumberII test = new T137_SingleNumberII();
        System.out.println(test.singleNumber1(new int[]{2, 2, 2, 3}));
        System.out.println(test.singleNumber1(new int[]{2, 2, 2, 3, 3, 4, 3}));
        System.out.println(test.singleNumber1(new int[]{-2, -2, -2, 3, 3, -74, 3}));
        System.out.println(test.singleNumber1(new int[]{2, 2, 2, 1, 1, 3, 3, 4, 3, 1}));
    }

    /**
     * ����ÿһλ�Ķ����Ƶ�1��0�ۼ�������Ȼ��3N����3N+1��
     * Ϊ3N�����λ�����Σ�3N+1�����λ��ֵ��Ȼ������û�����ε�λ | �������ǽ����
     * �������ĺô��������Ŀ�ĳ�K��һ����ֻ��Ҫ�Ѵ���ĳ� cnt % k
     * ִ����ʱ :4 ms, 41.19%
     * �ڴ����� :42.3 MB, 5.12%
     */
    public int singleNumber(int[] nums) {
        if (nums == null)
            return -1;
        int mask, cnt;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            cnt = 0;
            for (int num : nums)
                if ((num & mask) != 0)
                    cnt++;
            if (cnt % 3 == 0)
                continue;
            ans |= mask;
        }
        return ans;
    }

    /**
     * ˼·ͬ�ϣ����̰߳�
     * ִ����ʱ :16 ms, 5.44%
     * �ڴ����� :39.8 MB, 5.12%
     */
    public int singleNumber1(int[] nums) {
        if (nums == null)
            return -1;
        int mask, ans = 0;
        List<FutureTask<Integer>> futures = new LinkedList<>();
        FutureTask<Integer> task;
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            int finalMask = mask;
            task = new FutureTask<>(() -> {
                int cnt = 0;
                for (int num : nums)
                    if ((num & finalMask) != 0)
                        cnt++;
                return cnt;
            });
            futures.add(task);
            new Thread(task).start();
        }
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            try {
                if (futures.get(i).get() % 3 == 0)
                    continue;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            ans |= mask;
        }
        return ans;
    }
}
