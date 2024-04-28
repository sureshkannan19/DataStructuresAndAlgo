package org.sk.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = cache.get(nums[i]);
            if (Objects.nonNull(index)) {
                return true;
            }
            cache.put(nums[i], i);
            if (cache.size() > k) {
                cache.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 cd = new ContainsDuplicate2();
        System.out.println(cd.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(cd.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 3));
        System.out.println(cd.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 1));
    }
}

