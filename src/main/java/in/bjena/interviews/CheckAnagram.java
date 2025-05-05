package in.bjena.interviews;

import java.util.Arrays;

public class CheckAnagram {
	public static void main(String[] args) {
		String a = "CAT";
		String b = "aCt";
		boolean result = isAnagram(a, b);
		System.out.println((result) ? "Anagrams" : "Not Anagrams");
	}

	static boolean isAnagram(String a, String b) {
		if (a.length() != b.length())
			return false;
		char[] ar = a.toUpperCase().toCharArray();
		char[] br = b.toUpperCase().toCharArray();

		Arrays.sort(ar);
		Arrays.sort(br);

		for (int i = 0; i < ar.length; i++) {
			if (ar[i] != br[i])
				return false;
		}
		return true;
	}
}
