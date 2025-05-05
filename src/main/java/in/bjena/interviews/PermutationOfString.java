package in.bjena.interviews;

public class PermutationOfString {
	// static List<String> list= new ArrayList<String>();
	public static void main(String[] args) {
		String str = "abcd";
		stringPermuteAndPrint("", str);
	}

	private static void stringPermuteAndPrint(String firstChar, String word) {
		// System.out.println("approach understand =>"+firstChar+" "+word);
		int n = word.length();

		if (n == 0) {
			System.out.println(firstChar + " ");

		} else {
			// System.out.println("word :"+word );
			for (int i = 0; i < n; i++) {
				// System.out.println("inside loop firstChar: "+firstChar + word.charAt(i)+"
				// rest of the word :"+word.substring(0, i)+word.substring(i + 1, n));
				stringPermuteAndPrint(firstChar + word.charAt(i), word.substring(0, i) + word.substring(i + 1, n));
			}
		}
	}
}
