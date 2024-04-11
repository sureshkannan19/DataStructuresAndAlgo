package org.sk.linkedlist;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        // circular - 0
        // square - 1

        int[] studentsPreference = {0, 0};
        int count = students.length;
        for (int student : students) {
            studentsPreference[student]++;
        }

        for (int sandwich : sandwiches) {
            if (studentsPreference[sandwich] > 0) {
                count--;
                studentsPreference[sandwich]--;
            } else {
                return count;
            }
        }
        return 0;
    }

    public int countStudents1(int[] students, int[] sandwiches) {
        Queue<Integer> stu = new LinkedList<>();
        Stack<Integer> san = new Stack<>();
        for (int i = 0; i < students.length; i++) {
            stu.offer(students[i]);
            san.push(sandwiches[sandwiches.length - 1 - i]);
        }
        int noOfstudentsNotAteSandwich = 0;
        // exit the loop --> Number of students unable to eat the sandwich in prior iteration and current iteration remains same
        while (noOfstudentsNotAteSandwich != stu.size()) {
            noOfstudentsNotAteSandwich = stu.size();
            for (int i = 0; i < stu.size(); i++) {
                if (Objects.equals(stu.peek(), san.peek())) {
                    stu.poll();
                    san.pop();
                    i--; // To process all(last entry) students
                } else {
                    stu.offer(stu.poll());
                }
            }
        }
        return stu.size();
    }

    public static void main(String[] args) {
        NumberOfStudentsUnableToEatLunch n = new NumberOfStudentsUnableToEatLunch();
        n.countStudents1(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1});
        n.countStudents1(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1});
    }
}
