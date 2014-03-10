package mx.itesm.intelligentsystems.searchmethods.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;

public class SudokuState implements IState {

	private final int[][] board;

	public SudokuState(int[][] board) {
		this.board = board;
	}

	@Override
	public List<IState> expand() {
		List<IState> successors = new ArrayList<IState>();

		outer: for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					for (int k = 1; k < 10; k++) {
						int[][] newState = new int[board.length][board.length];

						for (int l = 0; l < board.length; l++) {
							newState[l] = Arrays.copyOf(board[l], board.length);
						}

						newState[i][j] = k;

						successors.add(new SudokuState(newState));
					}

					break outer;
				}
			}
		}

		return successors;
	}

	@Override
	public boolean isValid() {

		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board.length; j++) {

				int sr = (i / 3) * 3;
				int sc = (j / 3) * 3;

				for (int m = 0; m < 3; m++)
					for (int n = 0; n < 3; n++)
						if (board[i][j] != 0 && (i != sr + m && j != sc + n)
								&& board[i][j] == board[sr + m][sc + n])
							return false;

				for (int k = 0; k < board.length - 1; k++) {
					if (j != k + 1 && board[i][j] == board[i][k + 1]
							&& board[i][j] != 0)
						return false;

					if (i != k + 1 && board[i][j] == board[k + 1][j]
							&& board[i][j] != 0)
						return false;
				}
			}
		}

		return true;
	}

	public int getEmptyCells() {
		int emptyCells = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0)
					emptyCells++;
			}
		}

		return emptyCells;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < board.length; i++) {

			if (i != 0 && i % 3 == 0)
				sb.append("---------------------------------\n");

			for (int j = 0; j < board.length; j++) {
				int val = board[i][j];
				sb.append(val > 0 ? val : " ");

				sb.append(((j + 1) % 3 == 0) && ((j + 1) / 3 != 3) ? " | "
						: "   ");
			}

			sb.append("\n");
		}

		return sb.toString();
	}
}
