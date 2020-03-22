package test;

/**
 * 945. Minimum Increment to Make Array Unique
 * Difficult: Medium
 * <p>
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 * Return the least number of moves to make every value in A unique.
 * <p>
 * Example 1:
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 * <p>
 * Example 2:
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 * <p>
 * Note:
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class T945_MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        T945_MinimumIncrementToMakeArrayUnique test = new T945_MinimumIncrementToMakeArrayUnique();
        System.out.println(test.minIncrementForUnique(new int[]{1, 2, 2}));  //1
        System.out.println(test.minIncrementForUnique(new int[]{1, 1, 2, 2, 3, 5}));  //7
        System.out.println(test.minIncrementForUnique(new int[]{1, 1, 2, 2, 3, 5, 5}));  //9
        System.out.println(test.minIncrementForUnique(new int[]{1, 1, 2, 2, 3, 7}));  //6
    }

    /*
     * ִ����ʱ :5 ms, 97.81%
     * �ڴ����� :46.3 MB, 84.31%
     */
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int[] B = new int[40001];
        int bIndex = 0; //B��������λ��
        for (int value : A) {
            B[value]++;
            if (bIndex < value)
                bIndex = value;
        }
        int surplus = 0;  //�ܹ��������
        int ans = 0;
        /*
         * i 0 1 2 3 4 5
         * A 1 1 2 2 3 5
         * B   2 2 1 0 1
         *     1 3 1 0 1
         *     1 1 3 0 1
         *     1 1 1 2 1
         *     1 1 1 1 2
         */
        for (int i = 0; i <= bIndex; i++) {
            if (B[i] == 0 && surplus > 0)  //��ǰλ��û��������ǰ��λ���ж����û����
                surplus--;  //����İ���һ��
            else if (B[i] > 1)  //��ǰλ�þ��ж���ģ���Ҫ�����ܶ������Ŀ
                surplus += B[i] - 1;
            ans += surplus;  //ÿ��λ�ö��������Ҫ�ƶ�����һ��λ��
        }
        //���һ��λ�ÿ��ܻ��ж���ģ���Ҫ���ΰ��š�
        return ans + (surplus - 1) * surplus / 2;
    }
}
