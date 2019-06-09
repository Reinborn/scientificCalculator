package scientificCalculator;

import java.util.Stack;
import java.util.Vector;

public class Expression {
	public static double evaluateExpression(String expression) {
		expression = ScientificCalculator.exchange(expression);
		Stack<Double> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();
		Vector<String> tokens = Split.split(expression);

		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).charAt(0) == '+' || tokens.get(i).charAt(0) == '-') {
				while (!operatorStack.empty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '/' || operatorStack.peek() == '*'
						|| operatorStack.peek() == 'c' || operatorStack.peek() == 's' || operatorStack.peek() == 't' || operatorStack.peek() == 'L' || operatorStack.peek() == '%'
						|| operatorStack.peek() == 'l' || operatorStack.peek() == 'q' || operatorStack.peek() == 'w' || operatorStack.peek() == 'r' || operatorStack.peek() == 'M'
						|| operatorStack.peek() == 'f' || operatorStack.peek() == '¡Ì' || operatorStack.peek() == 'y' || (operatorStack.peek() + "").matches("b{0,1}n{0,1}m{0,1}g{0,1}h{0,1}j{0,1}a{0,1}")))
					Operator.processAnOperator(operandStack, operatorStack);

				operatorStack.push(tokens.get(i).charAt(0));
			}
			else if (tokens.get(i).charAt(0) == '*' || tokens.get(i).charAt(0) == '/' || tokens.get(i).charAt(0) == 'M' || tokens.get(i).charAt(0) == '%') {
				while (!operatorStack.empty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == 'c' || operatorStack.peek() == 's' || operatorStack.peek() == '%'
						|| operatorStack.peek() == 't' || operatorStack.peek() == 'L' || operatorStack.peek() == 'l' || operatorStack.peek() == 'a' || operatorStack.peek() == 'M'
						 || operatorStack.peek() == 'q' || operatorStack.peek() == 'w' || operatorStack.peek() == 'r' || operatorStack.peek() == 'f' || operatorStack.peek() == '¡Ì'
						 || operatorStack.peek() == 'y' || (operatorStack.peek() + "").matches("b{0,1}n{0,1}m{0,1}g{0,1}h{0,1}j{0,1}a{0,1}")))
					Operator.processAnOperator(operandStack, operatorStack);

				operatorStack.push(tokens.get(i).charAt(0));
			}
			else if(tokens.get(i).charAt(0) == '^') {
				while(!operatorStack.empty() && (operatorStack.peek() == '^' || operatorStack.peek() == 'y'))
					Operator.processAnOperator(operandStack, operatorStack);
				
				operatorStack.push(tokens.get(i).charAt(0));
			}
			else if(tokens.get(i).charAt(0) == 'y') {
				while(!operatorStack.empty() && operatorStack.peek() == 'y')
					Operator.processAnOperator(operandStack, operatorStack);
				
				operatorStack.push(tokens.get(i).charAt(0));
			}
			else if(tokens.get(i).matches("t{0,1}c{0,1}s{0,1}L{0,1}l{0,1}q{0,1}w{0,1}r{0,1}f{0,1}¡Ì{0,1}b{0,1}n{0,1}m{0,1}g{0,1}h{0,1}j{0,1}a{0,1}")) {
				operatorStack.push(tokens.get(i).charAt(0));
			}
			else if (tokens.get(i).charAt(0) == '(')
				operatorStack.push(tokens.get(i).charAt(0));
			else if (tokens.get(i).charAt(0) == ')') {
				while (operatorStack.peek() != '(')
					Operator.processAnOperator(operandStack, operatorStack);

				operatorStack.pop();
			}
			else {
				operandStack.push(Double.valueOf(tokens.get(i)));
			}
		}

		while (!operatorStack.empty())
			Operator.processAnOperator(operandStack, operatorStack);

		return operandStack.pop();
		
	}
	

}
