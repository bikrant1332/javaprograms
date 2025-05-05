package in.bjena.interviews;

import java.util.Stack;

public class BalancedParanthesis {
	public static void main(String[] args) {
		String str = "{[{}{}]}[()]";
		//String str = "{[{}{}]}[()])"; //false  //TO-DO
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		Character top = ' ';
		for (Character ch : str.toCharArray()) {

			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			}

			if (ch == ')' || ch == ']' || ch == '}') {
				if (stack.isEmpty())
					flag = false;

				top = stack.pop();
				if ((top == '(' && ch != ')') || (top == '[' && ch != ']') || (top == '{' && ch != '}'))
					flag = false;
			}
		}
		if (stack.isEmpty())
			flag = true;

		System.out.println(str + " is balanced : " + flag);
	}

}
