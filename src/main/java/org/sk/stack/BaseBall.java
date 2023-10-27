package org.sk.stack;

import java.util.LinkedList;

public class BaseBall {

    public int calPoints(String[] operations) {
        LinkedList<Integer> scoreCard = new LinkedList<>();
        for (String op : operations) {
            switch (op) {
                case "C":
                    scoreCard.pop();
                    break;
                case "D":
                    scoreCard.push(scoreCard.peek() * 2);
                    break;
                case "+":
                    int last = scoreCard.pop();
                    int prevLast = scoreCard.peek();
                    scoreCard.push(last);
                    scoreCard.push(prevLast + last);
                    break;
                default:
                    scoreCard.push(Integer.valueOf(op));
                    break;
            }
        }
        return scoreCard.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        BaseBall bb = new BaseBall();
        System.out.println(bb.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
