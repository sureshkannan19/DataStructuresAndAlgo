package org.sk.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> nodeMap = new HashMap<>();

        Node current = getCurrent(head, nodeMap);
        head = head.next;
        Node result = current;

        while (head != null) {
            current.next = getCurrent(head, nodeMap);
            head = head.next;
            current = current.next;
        }
        return result;
    }

    private Node getCurrent(Node head, Map<Node, Node> nodeMap) {
        Node current = getNewNode(nodeMap, head);
        Node next = getNewNode(nodeMap, head.next);
        Node random = getNewNode(nodeMap, head.random);
        current.next = next;
        current.random = random;
        return current;
    }

    private Node getNewNode(Map<Node, Node> nodeMap, Node node) {
        Node temp = null;
        if (node != null) {
            temp = nodeMap.getOrDefault(node, new Node(node.val));
            nodeMap.put(node, temp);
        }
        return temp;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer rp = new CopyListWithRandomPointer();
        Node input = new Node(7);
        input
                .add(13, null, 0)
                .add(11, null, 4)
                .add(10, null, 2)
                .add(1, null, 0);
        Node.print(rp.copyRandomList(input));

    }

}