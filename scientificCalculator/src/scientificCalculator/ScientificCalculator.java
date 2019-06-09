package scientificCalculator;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.math.*;
import java.util.regex.*;




public class ScientificCalculator {
	
	
	public static String exchange(String temp) {
		temp = temp.replace("arctanh", "b");
		temp = temp.replace("arccosh", "n");
		temp = temp.replace("arcsinh", "m");
		temp = temp.replace("tanh", "g");
		temp = temp.replace("cosh", "h");
		temp = temp.replace("sinh", "j");
		temp = temp.replace("arctan", "q");
		temp = temp.replace("arccos", "w");
		temp = temp.replace("arcsin", "r");
		temp = temp.replace("Mod", "M");
		//temp = temp.replace("abs", "a");
		temp = temp.replace("π", Math.PI + "");
		temp = temp.replace("e", Math.E + "");
		
		String regex = "[0-9]{1,}!"; //正则表达式  
		Pattern pattern = Pattern.compile(regex);   
		Matcher m = pattern.matcher(temp);  
		Vector<String> matchRegexList = new Vector<String>();  
		while(m.find()){  
		    matchRegexList.add(m.group());  
		}
		
		for(int i = 0;i<matchRegexList.size();i++) {
			temp = temp.replace(matchRegexList.get(i), "f(" + matchRegexList.get(i).substring(0, matchRegexList.get(i).length() - 1) + ")");
		}
		
		
		return temp;
	}
	
	
	public static void main(String[] args) {
		String expression;
		System.out.print("Enter an expression: ");
		Scanner input = new Scanner(System.in);
		expression = input.nextLine();
		System.out.println(expression + " = " + Expression.evaluateExpression(expression));
	}

	
	
	
	
}


