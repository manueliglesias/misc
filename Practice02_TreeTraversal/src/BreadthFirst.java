import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.manuel_iglesias.util.Node;
import com.manuel_iglesias.util.SetGenerator;
import com.manuel_iglesias.util.TreeGenerator;

public class BreadthFirst {

	public static void main(String[] args) {

		SetGenerator gen = new SetGenerator();
		TreeGenerator treeGen = new TreeGenerator();

		Integer[] range = gen.range(1, 12);

		Node<Integer> root = treeGen.generateTree(Arrays.asList(range));

		System.out.println(root);

		traverse(root, new NodeVisitor() {
			@Override
			public <T extends Comparable<T>> void visit(Node<T> node) {
				System.out.print(node.value);
				System.out.print(' ');
			}
		});
	}

	private interface NodeVisitor {
		<T extends Comparable<T>> void visit(Node<T> node);
	}

	private static <T extends Comparable<T>> void traverse(Node<T> node,
			NodeVisitor visitor) {
		
		Queue<Node<T>> queue = new LinkedList<>();
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node<T> curr = queue.poll();
			visitor.visit(curr);

			if(curr.left != null) {
				queue.add(curr.left);
			}
			
			if(curr.right != null) {
				queue.add(curr.right);
			}
		}
	}
}
