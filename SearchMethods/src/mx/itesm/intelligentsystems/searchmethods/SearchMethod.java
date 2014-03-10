package mx.itesm.intelligentsystems.searchmethods;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public interface SearchMethod<S extends IState> {

	public Iterable<TreeNode<S>> search(TreeNode<S> rootNode,
			GoalTestable<S> goalTest);

}
