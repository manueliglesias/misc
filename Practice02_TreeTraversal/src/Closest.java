import java.util.Arrays;
import java.util.Stack;

import com.manuel_iglesias.util.Node;
import com.manuel_iglesias.util.SetGenerator;
import com.manuel_iglesias.util.TreeGenerator;

public class Closest {

	public static void main(String[] args) {

		SetGenerator gen = new SetGenerator();
		TreeGenerator treeGen = new TreeGenerator();

		Integer[] range = gen.range(1, 8);

		Node<Integer> root = treeGen.generateTree(Arrays.asList(range));

		//root = treeGen.generateTree(Arrays.asList(new Integer[] { 2, 4, 6, 10, 11, 12, 14, 16, 18, 20, 22 }));

		System.out.println(root);

		System.out.println(closest(root, Integer.valueOf(19)).value);

	}

	private static <T extends Comparable<T>> Node<T> closest(Node<T> root,
			T value) {

		Node<T> curr = root;

		Stack<Node<T>> stack = new Stack<>();

		while (curr != null) {

			stack.push(curr);

			int diff = curr.value.compareTo(value);

			if (diff == 0) {
				return curr;
			}

			if (diff > 0) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		int diff = Integer.MAX_VALUE;

		Node<T> result = null;
		while (!stack.isEmpty()) {
			Node<T> node = stack.pop();

			int temp = Math.abs(node.value.compareTo(value));

			if (value instanceof Number) {
				temp = Math.abs(((Number) node.value).intValue()
						- ((Number) value).intValue());
			}

			if (temp <= diff) {
				diff = temp;
				result = node;
			}
		}

		return result;
	}

}