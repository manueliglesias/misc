package mx.itesm.intelligentsystems.searchmethods.missionariescannibals;

import java.util.Arrays;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.BreadthFirstSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.IterativeDeepeningSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.SearchApp;
import mx.itesm.intelligentsystems.searchmethods.SearchMethod;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public class MCApp extends SearchApp<MCState> {

	public MCApp(MCState initialState) {
		super(initialState);
	}

	public MCApp(MCState initialState, SearchMethod<MCState> searchMethod) {
		super(initialState, searchMethod);
	}

	public static void main(String[] args) {
		List<? extends SearchMethod<MCState>> searchMethods = Arrays.asList(
				new BreadthFirstSearchMethod<MCState>(),
				new IterativeDeepeningSearchMethod<MCState>());

		MCApp app = null;
		try {
			app = new MCApp(new MCState(3, 3, true));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (SearchMethod<MCState> method : searchMethods) {
			System.out.println("Executing search using "
					+ method.getClass().getSimpleName());
			app.setSearchMethod(method);

			int steps = 0;

			for (TreeNode<?> node : app.executeSearch()) {
				System.out.println(node);
				steps++;
			}
			System.out.println(String.format("Solved in %1$s steps", steps));

		}
	}

	@Override
	public boolean goalTest(MCState testState) {
		return new MCState(0, 0, false).equals(testState);
	}

}
