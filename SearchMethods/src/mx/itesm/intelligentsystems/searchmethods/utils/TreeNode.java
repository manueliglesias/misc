package mx.itesm.intelligentsystems.searchmethods.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<S extends IState> {
	private final TreeNode<S> parent;
	private List<TreeNode<S>> children;
	private final S state;

	public TreeNode(S state) {
		this(null, state);
	}

	public TreeNode(TreeNode<S> parent, S state) {
		super();
		this.parent = parent;
		this.state = state;
	}

	public TreeNode<S> getParent() {
		return parent;
	}

	public List<TreeNode<S>> getChildren() {
		if (children == null)
			expand();

		return children;
	}

	public S getState() {
		return state;
	}

	public int getDepth() {
		int depth = 0;
		TreeNode<S> n = this;

		while ((n = n.getParent()) != null)
			depth++;

		return depth;
	}

	@SuppressWarnings("unchecked")
	public void expand() {
		boolean avoidAddingParent = true;

		if (children != null)
			return;

		children = new ArrayList<TreeNode<S>>();

		for (IState newState : state.expand()) {

			if (!avoidAddingParent
					|| (getParent() == null || !newState.equals(getParent()
							.getState()))) {
				children.add(new TreeNode<S>(this, (S) newState));
			}
		}
	}

	@Override
	public String toString() {
		return state.toString();
	}

}
