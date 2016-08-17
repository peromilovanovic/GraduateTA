package library.util;

public class Verification {

	private static final String VERIFICATION = 	"------------------------------ VERIFICATION ------------------------------";
	private static final String TITLE = 		"\tTitle:    ";
	private static final String EXPECTED = 		"\tExpected: ";
	private static final String ACTUAL = 		"\tActual:   ";
	private static final String RESULT = 		"\tResult:   ";
	private static final String END = 			"--------------------------------------------------------------------------";

	private static void print(String expected, String actual, String title, boolean result) {

		System.out.println(VERIFICATION);
		System.out.println(TITLE + title);
		System.out.println(EXPECTED + expected);
		System.out.println(ACTUAL + actual);
		if (result) 
			System.out.println(RESULT + "Passed");
		else 
			System.out.println(RESULT + "Failed");
		System.out.println(END);
		assert result;

	}

	/**
	 * Verify that two strings are equal
	 * 
	 * @param {String}
	 *            expected
	 * @param {String}
	 *            actual
	 * @param {String}
	 *            title
	 */
	public static void verifyString(String expected, String actual, String title) {
		boolean b = actual.contains(expected);
		print(expected, actual, title, b);
	}

	/**
	 * Verify that two boolean are equal
	 * 
	 * @param {boolean}
	 *            expected
	 * @param {boolean}
	 *            actual
	 * @param {String}
	 *            title
	 */
	public static void verifyBoolean(boolean expected, boolean actual, String title) {
		boolean b = expected == actual;
		print(expected + "", actual + "", title, b);
	}

	/**
	 * Verify that two integer are equal
	 * 
	 * @param {int}
	 *            expected
	 * @param {int}
	 *            actual
	 * @param {String}
	 *            title
	 */
	public static void verifyInteger(int expected, int actual, String title) {
		boolean b = expected == actual;
		print(expected + "", actual + "", title + "", b);
	}
}