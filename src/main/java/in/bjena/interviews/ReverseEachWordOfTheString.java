package in.bjena.interviews;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordOfTheString {
	public static void main(String[] args) {
		// input = i.like.this.program.very.much
		// output =i.ekil.siht.margorp.yrev.hcum

		// input = i want to go
		// output = i tnaw ot og

		// input = quick brown fox jumps over lazy dog
		String s = "quick brown fox jumps over lazy dog";

		String reverseWord = Arrays.stream(s.split(" "))
				.map(word -> new StringBuilder(word).reverse())
				.collect(Collectors.joining(" "));
		
		System.out.println("Output : " + reverseWord);
	}

}
