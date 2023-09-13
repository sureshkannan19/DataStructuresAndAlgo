package org.sk.arraysAndHashing;

public class ExcelSheetToNumber {

	public int titleToNumber(String columnTitle) {
		int total = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			total = (total * 26) + ((columnTitle.charAt(i) - 65) + 1);
		}
		return total;
	}

	public static void main(String[] args) {
		ExcelSheetToNumber es = new ExcelSheetToNumber();
		System.out.println(es.titleToNumber("ZY")); // 701
		System.out.println(es.titleToNumber("AA"));
		System.out.println(es.titleToNumber("AB"));
		System.out.println(es.titleToNumber("RXW"));
		System.out.println(es.titleToNumber("FXSHRXW")); // 2147483647
	}
}
