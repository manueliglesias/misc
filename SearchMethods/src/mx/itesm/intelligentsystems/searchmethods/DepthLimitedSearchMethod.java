package mx.itesm.intelligentsystems.searchmethods;

import java.util.LinkedList;
import java.util.Stack;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public class DepthLimitedSearchMethod<S extends IState> implements
		SearchMethod<S> {

	private final int level;

	public DepthLimitedSearchMethod(int level) {
		super();
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	@Override
	public Iterable<TreeNode<S>> search(TreeNode<S> rootNode,
			GoalTestable<S> goalTest) {
		Stack<TreeNode<S>> fringe = new Stack<TreeNode<S>>();
		LinkedList<TreeNode<S>> pathToResult = new LinkedList<TreeNode<S>>();

		fringe.add(rootNode);
		TreeNode<S> currNode = null;

		while (true) {

			if (fringe.isEmpty())
				return null;

			currNode = fringe.pop();

			if (!currNode.getState().isValid()) {
				if (fringe.isEmpty()) {
					pathToResult.addFirst(currNode);
					break;
				}

				continue;
			} else {
				if (goalTest.goalTest(currNode.getState())) {
					pathToResult.addFirst(currNode);
					break;
				}

				int currDepth = currNode.getDepth();
				if (currDepth < level)
					fringe.addAll(currNode.getChildren());
			}
		}

		if (fringe.isEmpty() || !goalTest.goalTest(currNode.getState()))
			return null;

		TreeNode<S> n = currNode;
		while ((n = n.getParent()) != null) {
			pathToResult.addFirst(n);
		}

		return pathToResult;
	}

}
