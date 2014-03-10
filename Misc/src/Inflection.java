import java.util.Arrays;

import com.manuel_iglesias.util.SetGenerator;

public class Inflection {

	public static void main(String[] args) {
		SetGenerator gen = new SetGenerator();

		int size = gen.random(0, 50);
		int r = gen.random(0, Math.max(0, size - 1));
		
		Integer[] arr = gen.range(1, size);


		arr = gen.range(1, size);
		System.out.println(Arrays.toString(arr));
		
		arr = inflect(arr, r);
		System.out.println(Arrays.toString(arr));
		System.out.println(r);
		

		System.out.println(Arrays.toString(arr));
		System.out.println(findInflection(arr, 0));
		
		System.out.println(Arrays.toString(arr));
		System.out.println(findInflection2(arr));
	}

	private static Integer[] inflect(Integer[] arr, int r) {
		
		if(arr.length <= 1) {
			return arr;
		}
		
		r = r % arr.length;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (arr[i] - r + arr.length) % arr.length;
			
			if(arr[i] == 0) {
				arr[i] = arr.length;
			}
		}

		return arr;
	}

	private static int findInflection(Integer[] arr, int pos) {
		int middle = (arr.length - 1 ) / 2;
		
		if(arr.length <= 1 || arr[0] < arr[arr.length - 1]) {
			return pos;
		}
		
		Integer[] half;
		if(arr[0] > arr[middle]) {
			// go left
			half = Arrays.copyOfRange(arr, 0, middle + 1);
		} else {
			// go right
			half = Arrays.copyOfRange(arr, middle + 1, arr.length);
			pos += middle + 1;
		}
		
		return findInflection(half, pos);
	}
	
	private static int findInflection2(Integer[] arr) {
		
		int left = 0;
		int right = arr.length - 1;
		int middle = right / 2;
		
		while(true) {
			if(arr[left] < arr[right]) {
				return left;
			}
			
			if(right - left <= 1) {
				return right;
			}

			if (arr[left] > arr[middle]) {
				// go right
				right = middle;
			} else {
				// go left
				left = middle + 1;
			}

			middle = left + ((right - left) / 2);
		}
	}

}
