package mx.itesm.intelligentsystems.searchmethods.missionariescannibals;

import java.util.ArrayList;
import java.util.List;

import mx.itesm.intelligentsystems.searchmethods.utils.IState;

public class MCState implements IState {

	private static final int MAX = 3;
	private final int numMissionaries;
	private final int numCannibals;
	private boolean boatPresent;

	public MCState(int numMissionaries, int numCannibals, boolean boatPresent) {
		super();

		this.numMissionaries = numMissionaries;
		this.numCannibals = numCannibals;
		this.boatPresent = boatPresent;
	}

	public int getNumMissionaries() {
		return numMissionaries;
	}

	public int getNumCannibals() {
		return numCannibals;
	}

	public boolean isBoatPresent() {
		return boatPresent;
	}

	@Override
	public List<IState> expand() {
		List<IState> successors = new ArrayList<IState>();

		successors.add(new MCState(numMissionaries + (boatPresent ? -1 : 1),
				numCannibals, !boatPresent));

		successors.add(new MCState(numMissionaries + (boatPresent ? -2 : 2),
				numCannibals, !boatPresent));

		successors.add(new MCState(numMissionaries, numCannibals
				+ (boatPresent ? -1 : 1), !boatPresent));

		successors.add(new MCState(numMissionaries, numCannibals
				+ (boatPresent ? -2 : 2), !boatPresent));

		successors.add(new MCState(numMissionaries + (boatPresent ? -1 : 1),
				numCannibals + (boatPresent ? -1 : 1), !boatPresent));

		return successors;
	}

	@Override
	public boolean isValid() {
		boolean valid = true;

		valid &= !(numMissionaries < 0 || numMissionaries > MAX);

		valid &= !(numCannibals < 0 || numCannibals > MAX);

		valid &= !(!boatPresent && ((MAX - numMissionaries)
				+ (MAX - numCannibals) <= 1));

		valid &= !((numMissionaries > 0 && numMissionaries < numCannibals) || ((MAX - numMissionaries) > 0 && ((MAX - numMissionaries) < (MAX - numCannibals))));

		return valid;
	}

	@Override
	public String toString() {
		return String.format("(%1$s %2$s %3$s)", numMissionaries, numCannibals,
				boatPresent ? 1 : 0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (boatPresent ? 1231 : 1237);
		result = prime * result + numCannibals;
		result = prime * result + numMissionaries;
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
		MCState other = (MCState) obj;
		if (boatPresent != other.boatPresent)
			return false;
		if (numCannibals != other.numCannibals)
			return false;
		if (numMissionaries != other.numMissionaries)
			return false;
		return true;
	}

}
