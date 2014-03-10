import java.util.Arrays;

import com.manuel_iglesias.util.SetGenerator;

public class MergeSort {

	public static void main(String[] args) {
		SetGenerator gen = new SetGenerator();

		int size = 50;

		Integer[] arr = gen.randomize(gen.range(1, gen.random(1, size)));
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString(sort(arr)));
		
	}

	private static <T extends Comparable<T>> T[] sort(T[] arr) {
		if (arr.length == 1) {
			return arr;
		}

		int middle = (arr.length - 1) / 2;
		
		T[] left = Arrays.copyOfRange(arr, 0, Math.max(middle, 1));
		T[] right = Arrays.copyOfRange(arr, Math.max(middle, 1), arr.length);
		
		return merge(arr, sort(left), sort(right));
	}

	private static <T extends Comparable<T>> T[] merge(T[] arr, T[] left, T[] right) {
		int j = 0;
		int k = 0;

		for (int i = 0; i < arr.length; i++) {
			if (k == right.length || (j < left.length && (left[j].compareTo(right[k]) < 0))) {
				arr[i] = left[j++];
			} else {
				arr[i] = right[k++];
			}
		}
		
		return arr;
	}

}
