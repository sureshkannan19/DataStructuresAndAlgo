package org.sk.linkedlist;

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
}
