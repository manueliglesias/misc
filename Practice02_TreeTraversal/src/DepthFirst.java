import java.util.Arrays;

import com.manuel_iglesias.util.Node;
import com.manuel_iglesias.util.SetGenerator;
import com.manuel_iglesias.util.TreeGenerator;

public class DepthFirst {

	public static void main(String[] args) {

		SetGenerator gen = new SetGenerator();
		TreeGenerator treeGen = new TreeGenerator();

		Integer[] range = gen.range(1, 12);

		Node<Integer> root = treeGen.generateTree(Arrays.asList(range));

		System.out.println(root);

		NodeVisitor nodeVisitor = new NodeVisitor() {
			@Override
			public <T extends Comparable<T>> void visit(Node<T> node) {
				System.out.print(node.value);
				System.out.print(' ');
			}
		};

		traverse(root, nodeVisitor, ORDER.PREORDER);
		System.out.println();
		traverse(root, nodeVisitor, ORDER.INORDER);
		System.out.println();
		traverse(root, nodeVisitor, ORDER.POSTORDER);
	}

	private enum ORDER {
		PREORDER, INORDER, POSTORDER;
	}

	private interface NodeVisitor {
		<T extends Comparable<T>> void visit(Node<T> node);
	}

	private static <T extends Comparable<T>> void traverse(Node<T> node,
			NodeVisitor visitor, ORDER order) {

		if (node == null) {
			return;
		}
		
		if(ORDER.PREORDER.equals(order)) {
			visitor.visit(node);
		}
		
		traverse(node.left, visitor, order);
		
		if(ORDER.INORDER.equals(order)) {
			visitor.visit(node);
		}
		
		traverse(node.right, visitor, order);
		
		if(ORDER.POSTORDER.equals(order)) {
			visitor.visit(node);
		}

	}
}
