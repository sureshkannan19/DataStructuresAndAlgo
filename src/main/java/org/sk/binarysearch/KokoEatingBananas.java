package org.sk.binarysearch;

public class KokoEatingBananas {

    //  piles = [3,6,7,11], h = 8 output = 4
    //  from piles[0] -->  3 bananas
    //  1h = 3
    //  from piles[1] -->  6 bananas
    //  2h = 4 and 3h = 2
    //  from piles[2] -->  7 bananas
    //  4h = 4 and 5h = 3
    //  from piles[3] -->  11 bananas
    //  6h = 4 and 7h = 4 and 8h = 3
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MAX_VALUE;

        int minSpeedAtWhichKokosAteBananasPerHour = end;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            int tempHours = 0;
            for (int pile : piles) {
                tempHours += (pile / mid);
                if ((pile % mid) != 0) {
                    tempHours++;
                }
                if (tempHours > h) { // if tempHours its already exceeded the total hours break
                    break;
                }
            }
            if (tempHours > h) { // eating too slow
                start = mid + 1;
            } else { // eating too fast
                minSpeedAtWhichKokosAteBananasPerHour = Math.min(minSpeedAtWhichKokosAteBananasPerHour, mid);
                end = mid - 1;
            }
        }
        return minSpeedAtWhichKokosAteBananasPerHour;
    }

    public static void main(String[] args) {
        KokoEatingBananas keb = new KokoEatingBananas();
        System.out.println(keb.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(keb.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(keb.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(keb.minEatingSpeed(new int[]{312884470}, 312884469));
        System.out.println(keb.minEatingSpeed(new int[]{1, 1, 1, 999999999}, 10));
        System.out.println(keb.minEatingSpeed(new int[]{805306368, 805306368, 805306368}, 1000000000));
    }
}
