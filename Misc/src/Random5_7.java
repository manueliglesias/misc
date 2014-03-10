import java.util.Random;

/**
 * If you have access to a function that returns a random integer from one to
 * five, write another function which returns a random integer from one to
 * seven.
 * 
 */
public class Random5_7 {
	private Random rnd = new Random();

	public int random(int min, int max) {
		return min + rnd.nextInt(max - min + 1);
	}

	public int random5() {
		return this.random(1, 5);
	}

	public int random7() {

		int maxPos = ((5 * 5) / 7) * 7;
		int pos;
		int res;

		do {
			int row = this.random5();
			int col = this.random5();

			pos = ((row - 1) * 5) + col;
			res = (pos % 7) + 1;
		} while (pos > maxPos);

		return res;
	}

	public static void main(String[] args) {

		Random5_7 instance = new Random5_7();

		int howMany = 10;
		while (howMany-- > 0) {
			System.out.println(instance.random7());
		}

	}
}
