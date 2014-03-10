import com.manuel_iglesias.util.SetGenerator;


/**
 * Implement a function to divide two integers without using the divide operator.
 *
 */
public class Main {

	public static void main(String[] args) {
		SetGenerator gen = new SetGenerator();
		
		int num = gen.random(1, 1000);
		int den = gen.random(1, num);

		System.out.println(String.format("%1$s / %2$s = %3$s", num, den, (double) num / den));

		System.out.println(Main.division(num, den));

		System.out.println(Main.division2(num, den));

		System.out.println(Main.division3(num, den));

	}

	public static int division(int num, int den) {

		int result = 0;

		while ((num -= den) >= 0) {
			result++;
		}

		return result;
	}

	public static int division2(int num, int den) {

		int result = 0;

		while ((num = (num + ~den + 1)) >= 0) {
			result++;
		}

		return result;
	}

	public static int division3(int num, int den) {

		int mask = 1;
		int result = 0;

		while (den <= num) {
			den <<= 1; // * 2
			mask <<= 1; // * 2
		}
		
		while (mask > 1) {
			den >>= 1; // / 2
			mask >>= 1; // / 2

			if (num >= den) {
				num -= den;
				result |= mask;
			}
		}

		return result;
	}

}
