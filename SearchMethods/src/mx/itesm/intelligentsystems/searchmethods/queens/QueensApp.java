package mx.itesm.intelligentsystems.searchmethods.queens;

import java.util.Arrays;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.BreadthFirstSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.IterativeDeepeningSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.SearchApp;
import mx.itesm.intelligentsystems.searchmethods.SearchMethod;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public class QueensApp extends SearchApp<QueensState> {

	public QueensApp(QueensState initialState) {
		super(initialState);
	}

	public QueensApp(QueensState initialState,
			SearchMethod<QueensState> searchMethod) {
		super(initialState, searchMethod);
	}

	public static void main(String[] args) {
		List<? extends SearchMethod<QueensState>> searchMethods = Arrays
				.asList(new BreadthFirstSearchMethod<QueensState>(),
						new IterativeDeepeningSearchMethod<QueensState>());

		QueensApp app = null;
		try {
			app = new QueensApp(new QueensState(new int[] { 0, 0, 0, 0, 0, 0,
					0, 0 }));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (SearchMethod<QueensState> method : searchMethods) {
			System.out.println("Executing search using "
					+ method.getClass().getSimpleName());
			app.setSearchMethod(method);

			int steps = 0;

			for (TreeNode<?> node : app.executeSearch()) {
				System.out.println(node + "\n");
				steps++;
			}
			System.out.println(String.format("Solved in %1$s steps", steps));

		}
	}

	@Override
	public boolean goalTest(QueensState testState) {
		return testState.getNumQueens() == 8;
	}
}
