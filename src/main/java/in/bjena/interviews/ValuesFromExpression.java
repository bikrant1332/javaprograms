package in.bjena.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//The program is completed in two different ways,
//using loop and another using Pattern Matcher
public class ValuesFromExpression {
	public static void main(String[] args) {
		// Get valued like a001,002 in a list
		// output can be like this [a001, a002, a003, a004, a002, a005, a006, a001,
		// a007]
		// String str = "((a001*a002)*a003+a004*(a002-a005)/(a006+a001))+a007";
		String str = "((a001*a002)*a003+a004*(a002-a005)/(a006+a001))+a007";

		// List<String> values = getValuesFromExpression(str);
		List<String> values = getValuesFromExpressionUsingPatternMatcher(str);
		System.out.println("The values in the expression : " + values);
		// to get distinct values
		List<String> distList = values.parallelStream().distinct().toList();

		System.out.println("The distinct values in the expression : " + distList);
	}

	public static List<String> getValuesFromExpression(String str) {
		List<String> list = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for (Character ch : str.toCharArray()) {
			if (Character.isLetter(ch) | Character.isDigit(ch)) {
				builder.append(ch);
			} else if (builder.length() > 0) {
				list.add(builder.toString());
				builder.setLength(0); // for restarting the builder
			} else {
				builder.setLength(0);
			}
		}

		// Checking for the final
		if (builder.length() > 0) {
			list.add(builder.toString());
		}
		return list;
	}

	public static List<String> getValuesFromExpressionUsingPatternMatcher(String str) {
		String expression = "(?i)a\\d{3}";
		List<String> list = new ArrayList<>();
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find())
			list.add(matcher.group());

		return list;
	}
}
