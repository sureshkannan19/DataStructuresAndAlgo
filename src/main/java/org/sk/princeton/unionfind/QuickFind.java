package org.sk.princeton.unionfind;

public class QuickFind {

    private final int[] id;

    public QuickFind(int length) {
        this.id = new int[length];
        for (int i = 0; i < length; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        // 0 1 2 3 4 5 6 7 8 9
        // 4, 3 -->
        // 3, 8 -->
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        qf.union(1, 2);
        qf.union(3, 4);
        qf.union(5, 6);
        qf.union(7, 8);
        qf.union(7, 9);
        qf.union(2, 8);
        qf.union(0, 5);
        qf.union(1, 9);
        System.out.println(qf.isConnected(1 , 8)); // true
        System.out.println(qf.isConnected(1 , 7)); // true
        System.out.println(qf.isConnected(6 , 0)); // true
        System.out.println(qf.isConnected(6 , 8)); // false
        System.out.println(qf.isConnected(3 , 5)); // false
    }
}


