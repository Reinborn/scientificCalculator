package scientificCalculator;

import java.util.Vector;

public class Split {
	public static Vector<String> split(String expression) {
		Vector<String> v = new Vector<>();
		StringBuffer numberString = new StringBuffer();

		for (int i = 0; i < expression.length(); i++) {
			if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.' || expression.charAt(i) == 'E')
				numberString.append(expression.charAt(i));
			else if((expression.charAt(i) + "").matches("t{0,1}c{0,1}s{0,1}L{0,1}a{0,1}")) {//tan cos sin Log
				v.add(expression.charAt(i) + "");
				i += 2;
			}
			else if((expression.charAt(i) + "").matches("l{0,1}")) {//ln
				v.add(expression.charAt(i) + "");
				i += 1;
			}
			else if((expression.charAt(i) + "").matches("q{0,1}w{0,1}r{0,1}f{0,1}¡Ì{0,1}b{0,1}n{0,1}m{0,1}g{0,1}h{0,1}j{0,1}")) {//arctan arcsin arccos n! ¡Ì
				v.add(expression.charAt(i) + "");
				i += 0;
			}
			else {
				if (numberString.length() > 0) {
					v.add(numberString.toString());
					numberString.setLength(0);
				}

				if (!Character.isSpaceChar(expression.charAt(i))) {
					v.add(expression.charAt(i) + "");
				}
			}
		}

		if (numberString.length() > 0)
			v.add(numberString.toString());

		return v;
	}


}
