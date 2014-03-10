/**
 * Write an iterative function to reverse a string. Do the same thing as a
 * recursive function.
 * 
 */
public class Main {

	public static void main(String[] args) {
		String inputString = "Alejandro";

		System.out.println(inputString);

		char[] input = inputString.toCharArray();

		char[] output = Main.reverseIterative(input);

		System.out.println(output);

		output = Main.reverseRecursive(new String(input)).toCharArray();

		System.out.println(output);
	}

	private static char[] reverseIterative(char[] arr) {

		int left = 0;
		int right = arr.length - 1;
		while (right - left > 0) {
			char tmp = arr[left];

			arr[left++] = arr[right];
			arr[right--] = tmp;
		}

		return arr;

	}

	private static String reverseRecursive(String input) {
		if (input.length() <= 1) {
			return input;
		}

		return Main.reverseRecursive(input.substring(1)) + input.charAt(0);
	}

}
