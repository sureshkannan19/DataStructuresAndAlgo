package org.sk.slidingwindow;

public class MaxProfit {

	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int minPrice = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > minPrice) {
				maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			} else {
				minPrice = prices[i];
			}
		}
		return maxProfit;
	}

	public int maxProfit1(int[] prices) {
		int maxProfit = 0;
		for (int left = 0, right = left + 1; left < prices.length && right < prices.length;) {
			if (prices[left] > prices[right]) {
				left++;
				// buy and sell should be different days
				if (left == right) {
					right++;
				}
			} else {
				maxProfit = Math.max((prices[right] - prices[left]), maxProfit);
				right++;
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		MaxProfit mp = new MaxProfit();
		System.out.println(mp.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(mp.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.println(mp.maxProfit(new int[] { 3, 3 }));
		System.out.println(mp.maxProfit(new int[] { 1, 2, 4 }));
	}

}
