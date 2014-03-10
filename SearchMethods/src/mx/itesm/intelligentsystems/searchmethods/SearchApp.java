package mx.itesm.intelligentsystems.searchmethods;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public abstract class SearchApp<S extends IState> implements GoalTestable<S> {
	protected final S initialState;
	protected SearchMethod<S> searchMethod;

	public SearchApp(S initialState, SearchMethod<S> searchMethod) {
		this(initialState);
		this.searchMethod = searchMethod;
	}

	public SearchApp(S initialState) {
		super();
		this.initialState = initialState;
	}

	public S getInitialState() {
		return initialState;
	}

	public SearchMethod<S> getSearchMethod() {
		return searchMethod;
	}

	public void setSearchMethod(SearchMethod<S> searchMethod) {
		this.searchMethod = searchMethod;
	}

	public Iterable<TreeNode<S>> executeSearch() {
		return searchMethod.search(new TreeNode<S>(initialState), this);
	}
}
