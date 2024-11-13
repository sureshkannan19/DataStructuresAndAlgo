package org.sk.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
    static Map<Character, Integer> balloonOccurenceMap = new HashMap<>();
    static {
        for (char c : "balloon".toCharArray()) {
            balloonOccurenceMap.compute(c, (k, v) -> v != null ? v + 1 : 1);
        }
    }

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> inputCharactersMap = new HashMap<>();
        populateOccurrenceMap(inputCharactersMap, text);

        int minOccurenceOfBalloon = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry: balloonOccurenceMap.entrySet()) {
            minOccurenceOfBalloon = Math.min(inputCharactersMap.getOrDefault(entry.getKey(), 0) / entry.getValue(), minOccurenceOfBalloon);
        }
        return minOccurenceOfBalloon;
    }

    private static void populateOccurrenceMap(Map<Character, Integer> cccurenceMap, String input) {
        for (char c : input.toCharArray()) {
            if(!balloonOccurenceMap.containsKey(c)) continue;
            cccurenceMap.compute(c, (k, v) -> v != null ? v + 1 : 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("lloo"));
    }
}
