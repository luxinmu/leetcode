package test;

/**
 * 547. Friend Circles
 * Difficult: Medium
 * <p>
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature. For example, if A is a direct friend of B,
 * and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * Given a N*N matrix M representing the friend relationship between students in the class.
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other,
 * otherwise not. And you have to output the total number of friend circles among all the students.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 * <p>
 * Example 2:
 * Input:
 * [[1,1,0],
 * [1,1,1],
 * [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 * <p>
 * Note:
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 */
public class T547_FriendCircles {
    public static void main(String[] args) {
        T547_FriendCircles test = new T547_FriendCircles();
        System.out.println(test.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(test.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    private int parent[];
    private int count;

    /**
     * union-Find
     * ���鼯����δ�Ż��ⷨ
     * ִ����ʱ :10 ms, 20.84%
     * �ڴ����� :69 MB, 5.02%
     * <p>
     * find�н���·��ѹ���Ż���
     * ִ����ʱ :2 ms, 69.66%
     * �ڴ����� :46.3 MB, 5.02%
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        int len = M.length;
        parent = new int[len];
        // ��ʼ������ͨ
        this.count = len;
        // ���ڵ�ָ���ʼָ���Լ�
        for (int i = 0; i < len; i++)
            parent[i] = i;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < i; j++) //�Ż�������ɨ����������ֻ��ɨ��Խ����·���Ԫ�ؼ���
                if (M[i][j] == 1)
                    union(i, j);
        return count;
    }

    private void union(int i, int j) {
        int iParent = find(i);
        int jParent = find(j);
        if (iParent == jParent)
            return;
        parent[iParent] = jParent;
        count--;
    }

    private int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];  //�Ż� ����·��ѹ��
            i = parent[i];
        }
        return i;
    }
}
