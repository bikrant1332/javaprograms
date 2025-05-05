package in.bjena.interviews;

public class ConvertNumbersToWord {
	static String[] units = { "", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ",
			" ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ",
			"nineteen " };

	static String[] tens = { "", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
			"ninety " };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int n = 1452931;
		// int n = 579861234;
		int n = 874915;
		System.out.println("number : " + n);
		String numberInWord = convert(n);
		System.out.println(n + " in word : " + numberInWord);
	}

	private static String convert(int n) {
		if (n < 0) {
			return "minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			// for numbers between 20 and 99, we use the tens array and the units array
			String tenth = tens[n / 10];
			String unit = units[n % 10];
			return tenth + unit;
			// return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}
		if (n < 1000) {
			// for numbers between 100 and 999, we recursively call convert with the
			// quotient and remainder
			String hund = units[n / 100] + "hundered ";
			String rest = convert(n % 100);
			return hund + rest;
			// return units[n / 100] + " hundred" + ((n % 100 != 0) ? " and " : "") +
			// convert(n % 100);
		}

		if (n < 1000000) {
			// for numbers between 1000 and 9999, we recursively call convert with the
			// quotient and remainder
			String thousand = convert(n / 1000) + "thousand ";
			String rest = convert(n % 1000);
			return thousand + rest;
			// return convert(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") +
			// convert(n % 1000);
		}

		if (n < 1000000000) {
			// for numbers between 1000000 and 9999999, we recursively call convert with the
			// quotient and remainder
			String milions = convert(n / 1000000) + "milions ";
			String rest = convert(n % 1000000);
			return milions + rest;
			// return convert(n / 1000000) + " million" + ((n % 1000000 != 0) ? " " : "") +
			// convert(n % 1000000);
		}

		String bilion = convert(n / 1000000000) + "bilions ";
		String rest = convert(n % 1000000000);
		return bilion + rest;
	}
}
