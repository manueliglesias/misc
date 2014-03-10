public class Bits {

	public static void main(String[] args) {
		int a = 0b01001101;
		int b = ~a;

		System.out.println(a);
		System.out.println(b);

		System.out.println(Bits.toBin(a));
		System.out.println(Bits.toBin(b));

		System.out.println(Bits.toBin(~a << 1));
	}

	public static String toBin(int num) {

		StringBuilder sb = new StringBuilder();

		do {
			sb.append(num & 1);
		} while ((num = (num >>> 1)) > 0);

		return sb.reverse().toString();
	}

}
