package mx.itesm.intelligentsystems.searchmethods.puzzle3x3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;

public class PuzzleNxNState implements IState {

	private final int n;
	private ArrayList<Integer> puzzleState;
	private final int blankIndex;

	public PuzzleNxNState(Collection<Integer> puzzleState) {
		this.n = (int) Math.sqrt(puzzleState.size());

		if (n * n != puzzleState.size())
			throw new RuntimeException("Invalid size");

		this.puzzleState = new ArrayList<Integer>(puzzleState);

		blankIndex = this.puzzleState.indexOf(0);
	}

	public PuzzleNxNState(int[] puzzleState) {
		this.n = (int) Math.sqrt(puzzleState.length);

		ArrayList<Integer> list = new ArrayList<Integer>(puzzleState.length);
		for (int i : puzzleState) {
			list.add(i);
		}
		this.puzzleState = list;

		for (int i = 0; i < puzzleState.length; i++) {
			if (puzzleState[i] == 0) {
				blankIndex = i;
				return;
			}
		}

		blankIndex = -1;
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<Integer> swap(ArrayList<Integer> list, int index1,
			int index2) {
		ArrayList<Integer> result = (ArrayList<Integer>) list.clone();

		Collections.swap(result, index1, index2);

		return result;
	}

	private PuzzleNxNState moveRight() {
		int column = blankIndex % n;

		switch (n - (column + 1)) {
		case 0:
			return null;
		default:
			return new PuzzleNxNState(swap(puzzleState, blankIndex,
					blankIndex + 1));
		}
	}

	private PuzzleNxNState moveLeft() {
		int column = blankIndex % n;

		switch (column) {
		case 0:
			return null;
		default:
			return new PuzzleNxNState(swap(puzzleState, blankIndex,
					blankIndex - 1));
		}
	}

	private PuzzleNxNState moveDown() {
		int row = blankIndex / n;

		switch (n - (row + 1)) {
		case 0:
			return null;
		default:
			return new PuzzleNxNState(swap(puzzleState, blankIndex, blankIndex
					+ n));
		}
	}

	private PuzzleNxNState moveUp() {
		int row = blankIndex / n;

		switch (row) {
		case 0:
			return null;
		default:
			return new PuzzleNxNState(swap(puzzleState, blankIndex, blankIndex
					- n));
		}
	}

	@Override
	public List<IState> expand() {
		List<IState> successors = new ArrayList<IState>();

		if ((blankIndex + 1) % n != 0)
			successors.add(moveRight());

		if ((blankIndex + 1) % n != 1)
			successors.add(moveLeft());

		if ((blankIndex / n) != 0)
			successors.add(moveUp());

		if ((blankIndex / n) != (n - 1))
			successors.add(moveDown());

		return successors;
	}

	@Override
	public boolean isValid() {
		boolean valid = true;

		valid &= (Math.sqrt(puzzleState.size()) % 1) == 0;

		return valid;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int val = puzzleState.get((i * n) + j);
				sb.append((j != 0 ? " " : "") + (val != 0 ? val : "#")
						+ (((j + 1) % n) == 0 ? "\n" : ""));
			}
		}

		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + n;
		result = prime * result
				+ ((puzzleState == null) ? 0 : puzzleState.hashCode());
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
		PuzzleNxNState other = (PuzzleNxNState) obj;
		if (n != other.n)
			return false;
		if (puzzleState == null) {
			if (other.puzzleState != null)
				return false;
		} else if (!puzzleState.equals(other.puzzleState))
			return false;
		return true;
	}

}
