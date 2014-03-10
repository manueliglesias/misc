package mx.itesm.intelligentsystems.searchmethods.sudoku;

import java.util.Arrays;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.BreadthFirstSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.IterativeDeepeningSearchMethod;
import mx.itesm.intelligentsystems.searchmethods.SearchApp;
import mx.itesm.intelligentsystems.searchmethods.SearchMethod;
import mx.itesm.intelligentsystems.searchmethods.utils.TreeNode;

public class SudokuApp extends SearchApp<SudokuState> {

	public SudokuApp(SudokuState initialState) {
		super(initialState);
	}

	public SudokuApp(SudokuState initialState,
			SearchMethod<SudokuState> searchMethod) {
		super(initialState, searchMethod);
	}

	@Override
	public boolean goalTest(SudokuState testState) {
		return testState.getEmptyCells() == 0 && testState.isValid();
	}

	public static void main(String[] args) {
		SudokuState s = new SudokuState(new int[][] {
				new int[] { 1, 0, 0, 0, 0, 4, 9, 5, 7 },
				new int[] { 0, 4, 0, 8, 6, 5, 0, 0, 0 },
				new int[] { 0, 0, 0, 0, 0, 1, 8, 4, 0 },
				new int[] { 0, 8, 0, 0, 0, 0, 0, 0, 9 },
				new int[] { 0, 5, 0, 0, 0, 9, 0, 8, 1 },
				new int[] { 6, 9, 1, 0, 4, 0, 0, 0, 2 },
				new int[] { 8, 0, 6, 0, 0, 0, 0, 9, 5 },
				new int[] { 9, 0, 4, 0, 2, 0, 7, 3, 8 },
				new int[] { 5, 0, 0, 9, 8, 3, 6, 1, 0 } });
		
		List<? extends SearchMethod<SudokuState>> searchMethods = Arrays
				.asList(new BreadthFirstSearchMethod<SudokuState>(),
						new IterativeDeepeningSearchMethod<SudokuState>());

		SudokuApp app = null;
		try {
			app = new SudokuApp(s);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (SearchMethod<SudokuState> method : searchMethods) {
			System.out.println("Executing search using "
					+ method.getClass().getSimpleName());
			app.setSearchMethod(method);

			int steps = 0;

			for (TreeNode<SudokuState> node : app.executeSearch()) {
				System.out.println(node);
				System.out.println("**********************");
				steps++;
			}
			System.out.println(String.format("Solved in %1$s steps", steps));

		}
	}

}
