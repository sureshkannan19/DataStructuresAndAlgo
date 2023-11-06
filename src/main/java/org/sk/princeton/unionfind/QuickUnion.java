package org.sk.princeton.unionfind;

public class QuickUnion {

    private final int[] id;

    public QuickUnion(int length) {
        this.id = new int[length];
        for (int i = 0; i < length; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public int root(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        // 0 1 2 3 4 5
        // Form tree structure, form branches based on root node -> Chase parent root node.
        // union(0,1) --> 1 1 2 3 4 5
        // union(4,5) --> 1 1 2 3 5 5
        // union(1,5) --> 1 5 2 3 5 5
        // connected(0,5) --> Zeroth index has 1 , index 1 has 5 and index 5 has 5, hence it's connected.
        int pid = root(p);
        int qid = root(q);
        id[pid] = qid;
    }

    public static void main(String[] args) {
        QuickUnion qf = new QuickUnion(10);
        qf.union(1, 2);
        qf.union(3, 4);
        qf.union(5, 6);
        qf.union(7, 8);
        qf.union(7, 9);
        qf.union(2, 8);
        qf.union(0, 5);
        qf.union(1, 9);
        System.out.println(qf.isConnected(1, 8)); // true
        System.out.println(qf.isConnected(1, 7)); // true
        System.out.println(qf.isConnected(6, 0)); // true
        System.out.println(qf.isConnected(6, 8)); // false
        System.out.println(qf.isConnected(3, 5)); // false
    }
}


