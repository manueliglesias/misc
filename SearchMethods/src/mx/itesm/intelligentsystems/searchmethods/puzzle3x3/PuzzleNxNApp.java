package mx.itesm.intelligentsystems.searchmethods.puzzle3x3;

import java.util.Arrays;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.BreadthFirstSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.IterativeDeepeningSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.SearchApp;
import mx.itesm.intelligentsystems.searchmethods.SearchMethod;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public class PuzzleNxNApp extends SearchApp<PuzzleNxNState> {

	public PuzzleNxNApp(PuzzleNxNState initialState) {
		super(initialState);
	}

	public PuzzleNxNApp(PuzzleNxNState initialState,
			SearchMethod<PuzzleNxNState> searchMethod) {
		super(initialState, searchMethod);
	}

	public static void main(String[] args) {
		List<? extends SearchMethod<PuzzleNxNState>> searchMethods = Arrays
				.asList(new BreadthFirstSearchMethod<PuzzleNxNState>(),
						new IterativeDeepeningSearchMethod<PuzzleNxNState>());

		PuzzleNxNApp app = null;
		try {
			app = new PuzzleNxNApp(new PuzzleNxNState(new int[] { 1, 0, 3, 4,
					2, 5, 6, 7, 8 }));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (SearchMethod<PuzzleNxNState> method : searchMethods) {
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
	public boolean goalTest(PuzzleNxNState testState) {
		return new PuzzleNxNState(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 })
				.equals(testState);
	}
}
