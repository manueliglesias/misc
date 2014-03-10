package mx.itesm.intelligentsystems.searchmethods.queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;

public class QueensState implements IState {

	private final int[] queensPositions;

	public QueensState(int[] board) {
		super();
		this.queensPositions = board;
	}

	public int[] getBoard() {
		return queensPositions;
	}

	@Override
	public List<IState> expand() {
		List<IState> successors = new ArrayList<IState>();
		int minRow = 0;

		while (queensPositions[minRow] != 0) {
			minRow++;
		}

		if (minRow <= 7) {
			for (int i = 0; i < 8; i++) {
				int[] newState = Arrays.copyOf(Arrays.copyOfRange(
						queensPositions, 0, minRow), 8);

				newState[minRow] = i + 1;

				Arrays.fill(newState, minRow + 1, newState.length, 0);

				successors.add(new QueensState(newState));
			}
		}

		return successors;
	}

	@Override
	public boolean isValid() {

		for (int i = 0; i < queensPositions.length; i++) {
			for (int j = i + 1; j < queensPositions.length; j++) {

				int iv = queensPositions[i];
				int jv = queensPositions[j];

				if (jv != 0) {
					if (iv == jv) {
						return false;
					}

					if (Math.abs(i - j) == Math.abs(queensPositions[i]
							- queensPositions[j])) {
						return false;
					}
				}

			}
		}

		return true;
	}

	public int getNumQueens() {
		int result = 0;

		for (int i : queensPositions) {
			if (i > 0)
				result++;
		}

		return result;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(queensPositions);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QueensState other = (QueensState) obj;
		if (!Arrays.equals(queensPositions, other.queensPositions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < queensPositions.length; i++) {

			for (int j = 0; j < queensPositions.length; j++) {
				int val = queensPositions[i] - 1;
				sb.append(val >= 0 && val == j ? "#" : "0");
				sb.append(" ");
			}

			sb.append("\n");
		}

		return sb.toString();
	}

}
