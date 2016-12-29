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
	
	public int convertRomanNumeralToNumber(String romanNumeral) {
		return 0;
		
	}
	
}
