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
    public int minEatingSpeed(int[] piles, int hours) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        // minimumEatingSpeed
        int minSpeedTakenToEatTotalBannansPerHour = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long tempHours = 0L;
            for (int pile : piles) {
                if (pile <= mid) {
                    tempHours++;
                } else {
                    int bal = pile / mid; //  eg pile = 20, mid = 5 -- > bal = 20/ 5 = 4 or 5 * 4 = 20
                    tempHours += bal;
                    if (bal * mid != pile) {
                        tempHours++;
                    }
                }
            }
            if (tempHours <= hours) {
                minSpeedTakenToEatTotalBannansPerHour = Math.min(mid, minSpeedTakenToEatTotalBannansPerHour);
            }
            if (tempHours > hours) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return minSpeedTakenToEatTotalBannansPerHour;
    }

    // Brute force approach
    public int minEatingSpeedBF(int[] piles, int hours) {
        int startFrom = 0;
        int max = 0;
        for (int pile : piles) {
            startFrom = Math.min(startFrom, pile);
            max = Math.max(max, pile);
        }
        // minimumEatingSpeed
        int minSpeedTakenToEatTotalBannansPerHour = 0;
        while (startFrom <= max) {
            for (int pile : piles) {
                if (pile <= startFrom) {
                    minSpeedTakenToEatTotalBannansPerHour++;
                } else {
                    int bal = pile - startFrom;
                    minSpeedTakenToEatTotalBannansPerHour++;
                    while (bal > 0) {
                        bal = bal - startFrom;
                        minSpeedTakenToEatTotalBannansPerHour++;
                        if (minSpeedTakenToEatTotalBannansPerHour > hours) {
                            break;
                        }
                    }
                }
                if (minSpeedTakenToEatTotalBannansPerHour > hours) {
                    break;
                }
            }
            if (minSpeedTakenToEatTotalBannansPerHour <= hours) {
                return startFrom;
            }
            minSpeedTakenToEatTotalBannansPerHour = 0;
            startFrom++;
        }
        return minSpeedTakenToEatTotalBannansPerHour;
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
