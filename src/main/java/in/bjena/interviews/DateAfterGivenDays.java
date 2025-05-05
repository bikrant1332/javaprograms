package in.bjena.interviews;

import java.time.LocalDate;

public class DateAfterGivenDays {
	public static void main(String[] args) {
		// asked in one of the interview of edge verb
		int dd = 21;
		int mm = 04;
		int yyyy = 2023;
		int days = 1000;

		calculateDateAfterDays(dd, mm, yyyy, days);
		calculateDateAfterDaysUsingJava8(dd, mm, yyyy, days);

	}

	private static void calculateDateAfterDays(int day, int month, int year, int addDay) {
		int[] normalYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] leapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int[] refYear = year % 4 == 0 ? leapYear : normalYear;

		while (true) {
			System.out.println("day: " + day + " month: " + month + " year: " + year);
			int diff = addDay - (refYear[month - 1] - day);
			System.out.println("Diff: " + diff);
			if (diff > 0) {
				addDay = diff;
				month++;
				day = 0;
				if (month <= 12) {
					continue;
				}
			} else {
				day = day + addDay;
				break;
			}
			year++;
			month = 1;
			refYear = year % 4 == 0 ? leapYear : normalYear;
		}

		System.out.println("in calaculated : " + year + "-" + month + "-" + day);

	}

	static boolean isLeapYear(int year) {
		return year % 4 == 0 ? true : false;
	}

	private static void calculateDateAfterDaysUsingJava8(int dd, int mm, int yyyy, int days) {
		LocalDate date = LocalDate.of(yyyy, mm, dd).plusDays(days);
		System.out.println("in java8 : " + date);
	}
}
