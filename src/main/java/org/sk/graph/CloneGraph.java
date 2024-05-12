package org.sk.graph;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldNodeToNew = new HashMap<>();
        cloneNode(node, oldNodeToNew);
        return oldNodeToNew.get(node);
    }

    private static void cloneNode(Node node, Map<Node, Node> oldNodeToNew) {
        Queue<Node> neighbors = new LinkedList<>();
        neighbors.add(node);
        while (!neighbors.isEmpty()) {
            int size = neighbors.size();
            for (int i = 0; i < size; i++) {
                Node cur = neighbors.poll();
                Node newCur = oldNodeToNew.get(cur);
                if (newCur == null) {
                    newCur = new Node(cur.val, new ArrayList<>(cur.neighbors.size()));
                    oldNodeToNew.put(cur, newCur);
                }
                if (newCur.neighbors.isEmpty()) {
                    System.out.println(" Vertice: " + cur.val);
                    for (Node temp : cur.neighbors) {
                        System.out.print(" Neighbors: " + temp.val);
                        Node newTemp = oldNodeToNew.compute(temp, (k, v) -> v != null ? v : new Node(temp.val, new ArrayList<>(temp.neighbors.size())));
                        neighbors.add(temp);
                        newCur.neighbors.add(newTemp);
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors = Arrays.asList(two, four);
        two.neighbors = Arrays.asList(one, three);
        three.neighbors = Arrays.asList(two, four);
        four.neighbors = Arrays.asList(one, three);

        CloneGraph.cloneGraph(one);
    }
}