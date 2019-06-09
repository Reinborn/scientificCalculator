package scientificCalculator;

import java.util.Stack;

public class Operator {
	public static boolean DEG = true;
	
	public static double fact(long op) {
		if(op == 1) {
			return 1;
		}
		else if(op == 0) {
			return 0;
		}
		else {
			return op * fact(op - 1);
		}
	}
	
	public static void processAnOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		double op1 = 0, op2 = 0;
		if(op == '+' || op == '-' || op == '*' || op == '/' || op == 'M' || op == '^' || op == 'y' || op == '%') {
			op1 = operandStack.pop();
			op2 = operandStack.pop();
		}
		else if((op + "").matches("t{0,1}c{0,1}s{0,1}L{0,1}l{0,1}q{0,1}w{0,1}r{0,1}f{0,1}¡Ì{0,1}b{0,1}n{0,1}m{0,1}g{0,1}h{0,1}j{0,1}a{0,1}")) {
			op1 = operandStack.pop();
		}
		

		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if(op == 'M' || op == '%')
			operandStack.push(op2 % op1);
		else if(op == '^')
			operandStack.push(Math.pow(op2, op1));
		else if(op == 'y')
			operandStack.push(Math.pow(op2, 1 / op1));
		else if(op == 't')
			operandStack.push(!DEG ? Math.tan(op1) : Math.tan(Math.PI * op1 / 180));
		else if(op == 's')
			operandStack.push(!DEG ? Math.sin(op1) : Math.sin(Math.PI * op1 / 180));
		else if(op == 'c')
			operandStack.push(!DEG ? Math.cos(op1) : Math.cos(Math.PI * op1 / 180));
		else if(op == 'L')
			operandStack.push(Math.log10(op1));
		else if(op == 'l')
			operandStack.push(Math.log(op1));
		else if(op == 'q')
			operandStack.push(!DEG ? Math.atan(op1) : Math.atan(op1) * 180 / Math.PI);
		else if(op == 'w')
			operandStack.push(!DEG ? Math.acos(op1) : Math.acos(op1) * 180 / Math.PI);
		else if(op == 'r')
			operandStack.push(!DEG ? Math.asin(op1) : Math.asin(op1) * 180 / Math.PI);
		else if(op == 'f')
			operandStack.push(fact(Math.round(op1)));
		else if(op == '¡Ì')
			operandStack.push(Math.sqrt(op1));
		else if(op == 'b')
			operandStack.push(0.5 * Math.log((1 + op1) / (1 - op1)));
		else if(op == 'n')
			operandStack.push(Math.log(op1 + Math.sqrt(op1 * op1 - 1)));
		else if(op == 'm')
			operandStack.push(Math.log(op1 + Math.sqrt(op1 * op1 + 1)));
		else if(op == 'g')
			operandStack.push(Math.tanh(op1));
		else if(op == 'h')
			operandStack.push(Math.cosh(op1));
		else if(op == 'j')
			operandStack.push(Math.sinh(op1));
		else if(op == 'a')
			operandStack.push(Math.abs(op1));
		else {

		}
	}

}
