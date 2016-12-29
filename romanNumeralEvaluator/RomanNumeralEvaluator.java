package romanNumeralEvaluator;

/**
 * 
 * Take the String of Roman Numerals and give out a number.
 * @author Matthew Schweiss
 *
 * Quick Refresher of the Roman Numerals:
 * Values:
 * 		I = 1	C = 100
 * 		V = 5	D = 500
 * 		X = 10	M = 1000
 * 		L = 50
 * 
 * In descending order, the Roman Numerals are added together.
 * Example:
 * 		II = 2	XI = 11	MXI = 1011
 * In ascending order, Roman Numerals are subtracted. This can't make negative numbers.
 * Example:
 * 		IX = 9	IIX = 8 XM	= 990
 * 
 * Do note, zero can not be shown in Roman Numerals.
 */
public class RomanNumeralEvaluator {
	
	RomanNumeralEvaluator(){
		
	}
	
	public String convertNumberToRomanNumeral(int number) throws IllegalArgumentException {
		if (number <= 0 || number > 5000) throw new IllegalArgumentException(
				"Number must be greater then 0 and less than 5000.");
		
		String romanNumeral = "";
		
		do {
			if (number >= 1000) {
				//Number is greater than 1000
				romanNumeral += "M";
				number -= 1000;
			}
			else if (number >= 500) {
				//Number is greater than 500
				romanNumeral += "D";
				number -= 500;
			}
			else if (number >= 100) {
				//Number is greater than 100
				romanNumeral += "C";
				number -= 100;
			}
			else if (number >= 50) {
				//Number is greater than 50
				romanNumeral += "L";
				number -= 50;
			}
			else if (number >= 10) {
				romanNumeral += "X";
				number -= 10;
			}
			else if (number >= 5) {
				romanNumeral += "V";
				number -= 5;
			}
			else if (number >= 1) {
				romanNumeral += "I";
				number -= 1;
			}
			
		} while (number > 0);
		
		return romanNumeral;
	}
	
	public int convertRomanNumeralToNumber(String romanNumeral) throws IllegalArgumentException {
		if (romanNumeral.length() > 200) {
			//Long String, shouldn't be that long.
			throw new IllegalArgumentException(
					"String should not be longer than 200 characters.");
		}
		romanNumeral = romanNumeral.toUpperCase(); //All UpperCase
		
		int number = 0;
		int maxValue = 0;
		int charValue;
		
		//We iterate backward.
		//XIXVX
		//<----
		for (int i = romanNumeral.length() - 1; i >= 0; i--) {
			//Switch Possible Characters
			switch ( romanNumeral.charAt(i) ) {
				case 'M': charValue = 1000; break;
				case 'D': charValue = 500; break;
				case 'C': charValue = 100; break;
				case 'L': charValue = 50; break;
				case 'X': charValue = 10; break;
				case 'V': charValue = 5; break;
				case 'I': charValue = 1; break;
				default:
					//Not Valid Character.
					throw new IllegalArgumentException(
							"Roman Numerals can not have the character: " 
							+ romanNumeral.charAt(i));
			}
			if (maxValue < charValue) {
				//Example Situation: XXI    XIX
				//                   <--    <--
				//                    ^      Does not happen.
				//                    |
				//This is actually normal. Update max value and add the value to number.
				maxValue = charValue;
				number += charValue;
			} else if (maxValue == charValue) {
				///Example Situation: XXI  IXX
				//                    <--  <--
				//                    ^    ^
				//                    |    |
				//Two numbers in a row, this is valid.
				number += charValue;
			} else {
				//Example Situation: IXX    IVX
				//                   ^       ^
				//                   |       |
				//So this value is less then a number we have already seen.
				//This is a subtraction, not an addition.
				number -= charValue;
				
				
			}
			maxValue = Math.max(charValue, maxValue);
				
		}
		return number;
		
	}
	
}
