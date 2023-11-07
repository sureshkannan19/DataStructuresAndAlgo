package org.sk.princeton.unionfind;

public class WeightedQuickUnionWithPathCompression {

    private final int[] id;
    private final int[] sz;

    public WeightedQuickUnionWithPathCompression(int length) {
        this.id = new int[length];
        this.sz = new int[length];
        for (int i = 0; i < length; i++) {
            sz[i] = 1;
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]]; // Path compression - move nodes from their parents to their grandparents, so that tree does not grow too tall
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
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionWithPathCompression qf = new WeightedQuickUnionWithPathCompression(10);
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


