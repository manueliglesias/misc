package mx.itesm.intelligentsystems.searchmethods;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public class IterativeDeepeningSearchMethod<S extends IState> implements
		SearchMethod<S> {

	private final int startLevel;

	public IterativeDeepeningSearchMethod(int startLevel) {
		super();
		this.startLevel = startLevel;
	}

	public IterativeDeepeningSearchMethod() {
		this(0);
	}

	public int getStartLevel() {
		return startLevel;
	}

	@Override
	public Iterable<TreeNode<S>> search(TreeNode<S> rootNode,
			GoalTestable<S> goalTest) {
		int level = startLevel;
		while (true) {
			DepthLimitedSearchMethod<S> searchMethod = new DepthLimitedSearchMethod<S>(
					level);

			Iterable<TreeNode<S>> res = searchMethod.search(rootNode, goalTest);

			if (res != null)
				return res;
			else
				level++;
		}
	}
}
