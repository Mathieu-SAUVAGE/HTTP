package com.kyss;

import java.util.Random;

/**
 * @author Mathieu SAUVAGE
 */
public class CodeFactory {
	private static String numericChars = "0123456789";
	private static String lowerCaseChars = "abcdefghijklmnopqrstuvxyz";
	private static String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVXYZ";

	//<editor-fold desc="Numeric Code">
	public static String createNumericCode() {
		return createNumericCode(5);
	}

	public static String createNumericCode(int size) {
		return createCode(size, numericChars);
	}
	//</editor-fold>

	//<editor-fold desc="Alphabetic Code">
	public static String createNonCaseSensitiveAlphaCode(){
		return createNonCaseSensitiveAlphaCode(5);
	}

	public static String createNonCaseSensitiveAlphaCode(int size){
		return createCode(size, lowerCaseChars);
	}

	public static String createCaseSensitiveAlphaCode(){
		return createNonCaseSensitiveAlphaCode(5);
	}

	public static String createCaseSensitiveAlphaCode(int size){
		return createCode(size, lowerCaseChars+upperCaseChars);
	}
	//</editor-fold>

	//<editor-fold desc="AlphaNumeric Code">
	public static String createNonCaseSensitiveAlphaNumericCode() {
		return createNonCaseSensitiveAlphaNumericCode(5);
	}

	public static String createNonCaseSensitiveAlphaNumericCode(int size) {
		return createCode(size,
						  numericChars+lowerCaseChars);
	}

	public static String createCaseSensitiveAlphaNumericCode() {
		return createCaseSensitiveAlphaNumericCode(5);
	}

	public static String createCaseSensitiveAlphaNumericCode(int size) {
		return createCode(size,
						  numericChars+lowerCaseChars+upperCaseChars);
	}
	//</editor-fold>

	public static String createCode(int size, String charsAllowed) {
		StringBuilder result = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			result.append(charsAllowed.charAt(random.nextInt(charsAllowed.length())));
		}

		return result.toString();
	}
}