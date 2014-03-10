package mx.itesm.intelligentsystems.searchmethods;

import java.util.LinkedList;
import java.util.Queue;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public class BreadthFirstSearchMethod<S extends IState> implements
		SearchMethod<S> {

	@Override
	public Iterable<TreeNode<S>> search(TreeNode<S> rootNode,
			GoalTestable<S> goalTest) {
		Queue<TreeNode<S>> fringe = new LinkedList<TreeNode<S>>();
		LinkedList<TreeNode<S>> pathToResult = new LinkedList<TreeNode<S>>();

		fringe.add(rootNode);
		TreeNode<S> currNode = null;

		while (true) {

			if (fringe.isEmpty())
				return null;

			currNode = fringe.poll();

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

				fringe.addAll(currNode.getChildren());
			}

		}

		TreeNode<S> n = currNode;
		while ((n = n.getParent()) != null) {
			pathToResult.addFirst(n);
		}

		return pathToResult;
	}
}
