package romanNumeralEvaluator;

public class RomanNumeralTester {
	
	private static RomanNumeralEvaluator numeralConverter = new RomanNumeralEvaluator();

	public static void main(String[] args) {
		//Generate the Roman Numerals.
		System.out.println("Hello. Welcome to the Roman Numeral Tester");
		System.out.print("66 in Roman Numerals is ");
		System.out.println(numeralConverter.convertNumberToRomanNumeral(66));
		System.out.print("XXII in decimal is ");
		System.out.println(numeralConverter.convertRomanNumeralToNumber("XXII"));
	}
}
